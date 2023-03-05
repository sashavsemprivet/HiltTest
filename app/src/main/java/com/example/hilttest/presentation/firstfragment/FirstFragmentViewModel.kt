package com.example.hilttest.presentation.firstfragment

import androidx.lifecycle.viewModelScope
import com.example.hilttest.R
import com.example.hilttest.data.Repository
import com.example.hilttest.domain.Car
import com.example.hilttest.domain.GetDataUseCase
import com.example.hilttest.presentation.ActionState
import com.example.hilttest.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FirstFragmentViewModel @Inject constructor(private val repository: Repository) :
    BaseViewModel() {

    private var _sharedFlowCars = MutableSharedFlow<MutableList<Car>>(replay = 1)
    val sharedFlowCars = _sharedFlowCars.asSharedFlow()

    val actionState = MutableStateFlow<ActionState>(ActionState.NotStarted)

    fun getCars() {
        actionState.value = ActionState.Started
        val listCars = mutableListOf<Car>()
        viewModelScope.launch {
            GetDataUseCase(repository).execute().collect {
                listCars.add(it)
                _sharedFlowCars.emit(listCars)
            }
        }
    }

    fun toSecondFragment() {
        navigate(R.id.action_firstFragment_to_secondFragment)
    }
}