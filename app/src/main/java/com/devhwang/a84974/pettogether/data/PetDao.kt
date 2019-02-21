package com.devhwang.a84974.pettogether.data

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.devhwang.a84974.pettogether.model.PetProfie

interface PetDao {
    @Query("SELECT * FROM pets ORDER BY name")
    fun getPets(): LiveData<List<PetProfie>>

    @Query("SELECT * FROM pets WHERE age = :age ORDER BY name")
    fun getPetsWithAge(age: Long): LiveData<List<PetProfie>>

    @Query("SELECT * FROM pets WHERE id = :petId")
    fun getPet(petId: String): LiveData<PetProfie>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(plants: List<PetProfie>)

}