package com.devhwang.a84974.pettogether.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.devhwang.a84974.pettogether.MainActivity
import com.devhwang.a84974.pettogether.R
import com.devhwang.a84974.pettogether.data.PetAdapter
import com.devhwang.a84974.pettogether.databinding.FragmentMainBinding
import com.devhwang.a84974.pettogether.utilities.InjectorUtils
import com.devhwang.a84974.pettogether.viewmodel.PetListViewModel

class MainFragment : Fragment() {
    private lateinit var viewModel: PetListViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var mainActivity: MainActivity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root
        val factory = InjectorUtils.providePetListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(PetListViewModel::class.java)
        val adapter = PetAdapter(viewModel, requireActivity())
        binding.rcvPets.adapter = adapter
        subScribe(adapter)
        return binding.root
    }

    private fun subScribe(adapter: PetAdapter) {
        binding.rcvPets.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.getPets().observe(viewLifecycleOwner, Observer { pets -> if (pets != null)
            adapter.updateData(pets!!) })

        binding.fab.setOnClickListener {

            Navigation.findNavController(it)
                .navigate(R.id.action_mainFragment_to_profileFragment) //(R.id.profileFragment)
//            var xxx = arrayListOf<PetProfie>(PetProfie("Cuong3333","cuong cuong ","hooman","default",0))
//            adapter.updateData(xxx)
        }
    }


}