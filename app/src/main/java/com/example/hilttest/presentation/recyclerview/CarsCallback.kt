package com.example.hilttest.presentation.recyclerview

import androidx.recyclerview.widget.DiffUtil
import com.example.hilttest.domain.Car
import javax.inject.Inject

class CarsCallback(private val oldList: MutableList<Car>, private val newList: MutableList<Car>) :
    DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCar = oldList[oldItemPosition]
        val newCar = newList[newItemPosition]
        return oldCar.id == newCar.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldCar = oldList[oldItemPosition]
        val newCar = newList[newItemPosition]
        return oldCar.brand == newCar.brand
    }
}