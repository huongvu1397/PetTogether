package com.devhwang.a84974.pettogether.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.devhwang.a84974.pettogether.model.PetProfie

@Dao
interface PetDao {
    @Query("SELECT * FROM pets ORDER BY name")
    fun getPets(): LiveData<List<PetProfie>>

    @Query("SELECT * FROM pets WHERE age = :age ORDER BY name")
    fun getPetsWithAge(age: Long): LiveData<List<PetProfie>>

    @Query("SELECT * FROM pets WHERE id = :petId")
    fun getPet(petId: String): LiveData<PetProfie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(pets: List<PetProfie>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPet(pet:PetProfie)

    @Delete
    fun deletePet(pet: PetProfie)
}