package com.devhwang.a84974.pettogether.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.devhwang.a84974.pettogether.R
import com.devhwang.a84974.pettogether.databinding.FragmentProfileBinding
import com.devhwang.a84974.pettogether.model.PetProfile
import com.devhwang.a84974.pettogether.utilities.InjectorUtils
import com.devhwang.a84974.pettogether.viewmodel.PetListViewModel

class ProfileFragment : Fragment() {
    private val arraySpinner = arrayOf("Mèo", "Chó", "Other")
    lateinit var binding: FragmentProfileBinding
    lateinit var petListViewModel: PetListViewModel
    private var handlerProfile = HandlerProfile()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val factory = InjectorUtils.providePetListViewModelFactory(requireActivity())
        petListViewModel = ViewModelProviders.of(this, factory).get(PetListViewModel::class.java)
        binding = DataBindingUtil.inflate<FragmentProfileBinding>(inflater, R.layout.fragment_profile, container, false)
            .apply {
                viewModel = petListViewModel
                handler = handlerProfile
                lifecycleOwner = this@ProfileFragment
            }
        addItemSpinner()
        return binding.root
    }

    inner class HandlerProfile {
        fun onClickSave() {
            var x = (0..1000).random()
            Log.d("TestDDDD", "$x")
            //petListViewModel.insertPet(PetProfile(binding.nameProfile.text.toString(),binding.typeProfile.text.toString(),"default",x.toLong()))
            var petProfile = PetProfile()
            petProfile.name = binding.nameProfile.text.toString()
            petProfile.age = 5
            //petProfile.type = binding.typeProfile.text.toString()
            petProfile.imageUrl = "default"
            petListViewModel.insertPet(petProfile)
        }
    }

    fun addItemSpinner() {

        var arrayAdapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, arraySpinner)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.typeSpinner.adapter = arrayAdapter
        binding.typeSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(context, arraySpinner[position], Toast.LENGTH_SHORT).show()
                if(position==1){

                }else if(position==2){

                }else if(position==3){

                }
            }

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}