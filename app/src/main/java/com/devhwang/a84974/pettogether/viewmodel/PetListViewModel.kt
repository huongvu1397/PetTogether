package com.devhwang.a84974.pettogether.viewmodel

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.devhwang.a84974.pettogether.data.PetRepository
import com.devhwang.a84974.pettogether.model.PetProfie

class PetListViewModel internal constructor(private val petListRepository: PetRepository): ViewModel() {

    fun getPet(stringId: String) = petListRepository.getPet(stringId)

    //fun deleteSign(sign: PetProfie) = petListRepository.deleteSign(sign)

    fun getPets() = petListRepository.getPets()

    fun insertPet(pet: PetProfie) = petListRepository.insertPet(pet)


}