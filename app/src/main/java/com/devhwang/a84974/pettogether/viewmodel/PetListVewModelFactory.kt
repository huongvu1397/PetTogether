package com.devhwang.a84974.pettogether.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.devhwang.a84974.pettogether.data.PetRepository

class PetListVewModelFactory(private val repository: PetRepository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = PetListViewModel(repository) as T
}