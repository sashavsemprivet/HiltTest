package com.example.hilttest.domain

import com.example.hilttest.data.Repository
import kotlinx.coroutines.flow.Flow

class GetDataUseCase(private val repository: Repository) {
    fun execute(): Flow<Car> {
        return repository.getData()
    }
}