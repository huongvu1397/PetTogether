package com.devhwang.a84974.pettogether.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.devhwang.a84974.pettogether.R
import com.devhwang.a84974.pettogether.databinding.FragmentProfileBinding
import com.devhwang.a84974.pettogether.model.PetProfie
import com.devhwang.a84974.pettogether.utilities.InjectorUtils
import com.devhwang.a84974.pettogether.viewmodel.PetListViewModel
import kotlin.random.Random

class ProfileFragment : Fragment() {
    lateinit var binding:FragmentProfileBinding
    lateinit var petListViewModel : PetListViewModel
    private var handlerProfile = HandlerProfile()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val factory = InjectorUtils.providePetListViewModelFactory(requireActivity())
        petListViewModel = ViewModelProviders.of(this,factory).get(PetListViewModel::class.java)
        binding= DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false).apply {
            viewModel = petListViewModel
            handler = handlerProfile
            lifecycleOwner = this@ProfileFragment
        }
        return binding.root
    }

    inner class HandlerProfile{
        fun onClickSave(){
            var random = Random(10000)
            var x = random.nextInt()
            Log.d("TestDDDD","$x")
            petListViewModel.insertPet(PetProfie("$x",binding.nameProfile.text.toString(),binding.typeProfile.text.toString(),"default",2))

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}