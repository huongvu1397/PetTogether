package com.devhwang.a84974.pettogether.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.devhwang.a84974.pettogether.MainActivity
import com.devhwang.a84974.pettogether.R
import com.devhwang.a84974.pettogether.data.PetAdapter
import com.devhwang.a84974.pettogether.databinding.FragmentMainBinding
import com.devhwang.a84974.pettogether.databinding.FragmentProfileBinding
import com.devhwang.a84974.pettogether.utilities.InjectorUtils
import com.devhwang.a84974.pettogether.viewmodel.PetListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainFragment : Fragment() {
    private lateinit var viewModel: PetListViewModel
    private lateinit var mainActivity: MainActivity
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val context = context ?: return binding.root
        val factory = InjectorUtils.providePetListViewModelFactory(context)
        viewModel = ViewModelProviders.of(this, factory).get(PetListViewModel::class.java)
        val adapter = PetAdapter(viewModel, requireActivity())


        binding.rcvPets.adapter = adapter
        return binding.root
    }

    private fun updateData() {
        with(viewModel) {
            if (isSetAge()) {
                clearAge()
            } else {
                setPetAge(2)
            }
        }
    }

}