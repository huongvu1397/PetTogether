package com.devhwang.a84974.pettogether.data

class PetRepository private constructor(private val petDao: PetDao) {

    fun getPets() = petDao.getPets()

    fun getPet(petId: String) = petDao.getPet(petId)

    fun getPetsWithAge(age: Long) = petDao.getPetsWithAge(age)

    companion object {
        @Volatile
        private var instance: PetRepository? = null
        fun getInstance(petDao:PetDao) =
                instance?: synchronized(this){
                    instance ?: PetRepository(petDao).also { instance = it }
                }
    }

}