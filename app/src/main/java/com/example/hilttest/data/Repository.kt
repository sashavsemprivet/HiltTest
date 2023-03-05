package com.example.hilttest.data

import com.example.hilttest.domain.Car
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class Repository @Inject constructor() {
    private val listCars = listOf(
        Car(1, "Mercedes"),
        Car(2, "BMW"),
        Car(3, "LADA"),
        Car(4, "Ferrari"),
        Car(5, "Peugeot"),
        Car(6, "Audi"),
        Car(7, "Cherry"),
        Car(8, "Ford"),
        Car(9, "Volvo"),
        Car(10, "Renault"),
        Car(11, "Volga"),
        Car(12, "Tesla")
    )

    fun getData() = flow {
        for (it in listCars) {
            delay(2000)
            emit(it)
        }
    }

}