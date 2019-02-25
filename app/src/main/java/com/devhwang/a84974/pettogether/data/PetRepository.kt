package com.devhwang.a84974.pettogether.data

import com.devhwang.a84974.pettogether.model.PetProfile

class PetRepository private constructor(private val petDao: PetDao) {

    fun getPets() = petDao.getPets()

    fun getPet(petId: String) = petDao.getPet(petId)

    fun insertPet(pet:PetProfile) = petDao.insertPet(pet)

    fun deletePet(pet:PetProfile) = petDao.deletePet(pet)

    companion object {
        @Volatile
        private var instance: PetRepository? = null
        fun getInstance(petDao:PetDao) =
                instance?: synchronized(this){
                    instance ?: PetRepository(petDao).also { instance = it }
                }
    }

}