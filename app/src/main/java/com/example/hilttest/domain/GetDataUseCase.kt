package com.example.hilttest.domain

import com.example.hilttest.data.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDataUseCase @Inject constructor(private val repository: Repository) {
    fun execute(): Flow<Car> {
        return repository.getData()
    }
}