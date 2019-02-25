package com.devhwang.a84974.pettogether.viewmodel

import android.arch.lifecycle.ViewModel
import com.devhwang.a84974.pettogether.data.PetRepository
import com.devhwang.a84974.pettogether.model.PetProfile

class PetListViewModel internal constructor(private val petListRepository: PetRepository): ViewModel() {

    fun getPet(stringId: String) = petListRepository.getPet(stringId)

    //fun deleteSign(sign: PetProfie) = petListRepository.deleteSign(sign)

    fun getPets() = petListRepository.getPets()

    fun insertPet(pet: PetProfile) = petListRepository.insertPet(pet)


}