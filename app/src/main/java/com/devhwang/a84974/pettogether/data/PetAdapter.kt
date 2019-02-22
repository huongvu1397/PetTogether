package com.devhwang.a84974.pettogether.data

import android.support.v4.app.FragmentActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.devhwang.a84974.pettogether.databinding.ItemOneBinding
import com.devhwang.a84974.pettogether.model.PetProfie
import com.devhwang.a84974.pettogether.viewmodel.PetListViewModel

class PetAdapter(private val petListViewModel: PetListViewModel, private val activity: FragmentActivity) :
    RecyclerView.Adapter<PetAdapter.ViewHolder>() {

    companion object {
        var pets: ArrayList<PetProfie> = arrayListOf()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(
            ItemOneBinding.inflate(
                LayoutInflater.from(p0.context), p0, false
            )
        )
    }

    override fun getItemCount(): Int {
        return if (pets == null) 0
        else pets.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val pet = pets?.get(p1)
        p0.apply {
            p0.bind(createOnClickSelected(pet), pet)
        }
    }

    private fun createOnClickSelected(pet: PetProfie): View.OnClickListener {
        return View.OnClickListener {
            Toast.makeText(activity, " " + pet.name, Toast.LENGTH_SHORT).show()
        }
    }

    fun updateData(petscheck:List<PetProfie>){
        if(petscheck ==null){
            return
        }
        pets.clear()
        pets.addAll(petscheck)
        notifyDataSetChanged()
    }


    class ViewHolder(private val binding: ItemOneBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(onSelected: View.OnClickListener, item: PetProfie) {
            binding.apply {
                selected = onSelected
                pet = item

                executePendingBindings()
                //avatarCat.setImageResource()
            }
        }

    }
}