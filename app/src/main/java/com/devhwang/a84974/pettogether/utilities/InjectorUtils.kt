package com.devhwang.a84974.pettogether.utilities

import android.content.Context
import com.devhwang.a84974.pettogether.data.AppDatabase
import com.devhwang.a84974.pettogether.data.PetRepository
import com.devhwang.a84974.pettogether.viewmodel.PetListVewModelFactory

object InjectorUtils {

    private fun getPetRepository(context: Context): PetRepository {
        return PetRepository.getInstance(AppDatabase.getInstance(context).petDao())
    }

    fun providePetListViewModelFactory(context: Context):PetListVewModelFactory{
        val repository = getPetRepository(context)
        return PetListVewModelFactory(repository)
    }



}