package com.devhwang.a84974.pettogether.viewmodel

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.devhwang.a84974.pettogether.data.PetRepository
import com.devhwang.a84974.pettogether.model.PetProfie

class PetListViewModel internal constructor(private val petListRepository: PetRepository): ViewModel() {

    private val age = MutableLiveData<Long>()
    private val petList = MediatorLiveData<List<PetProfie>>()

    init{
        age.value =  noAge
        val livePetList = Transformations.switchMap(age){
            if(it == noAge){
                petListRepository.getPets()
            }else{
                petListRepository.getPetsWithAge(it)
            }
        }
        petList.addSource(livePetList,petList::setValue)
    }

    fun getPets() = petList

    fun setPetAge(age:Long){
        this.age.value = age
    }

    fun clearAge(){
        this.age.value = noAge
    }

    fun isFiltered() = age.value != noAge

    companion object {
        private const val noAge = -1L
    }

}