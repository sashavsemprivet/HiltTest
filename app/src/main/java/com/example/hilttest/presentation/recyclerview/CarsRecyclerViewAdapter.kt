package com.example.hilttest.presentation.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.hilttest.databinding.SingleItemBinding
import com.example.hilttest.domain.Car

class CarsRecyclerViewAdapter(private var listCars: MutableList<Car>) :
    RecyclerView.Adapter<CarsRecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: SingleItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    fun setListOfCars(newListCars: MutableList<Car>) {
        val diffCallback = CarsCallback(listCars, newListCars)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listCars[position]) {
                Log.d("AAA", "New item: $position")
                binding.idCar.text = this.id.toString()
                binding.brandCar.text = this.brand
            }
        }
    }

    override fun getItemCount(): Int {
        return listCars.size
    }
}