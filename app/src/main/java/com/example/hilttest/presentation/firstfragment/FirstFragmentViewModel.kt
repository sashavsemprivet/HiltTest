package com.example.hilttest.presentation.firstfragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hilttest.R
import com.example.hilttest.domain.Car
import com.example.hilttest.domain.GetDataUseCase
import com.example.hilttest.presentation.ActionEvent
import com.example.hilttest.presentation.BaseViewModel
import com.example.hilttest.presentation.SingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FirstFragmentViewModel @Inject constructor(private val getDataUseCase: GetDataUseCase) :
    BaseViewModel() {

    private var _sharedFlowCars = MutableSharedFlow<MutableList<Car>>(replay = 1)
    val sharedFlowCars = _sharedFlowCars.asSharedFlow()

    val actionEvent = MutableStateFlow<ActionEvent>(ActionEvent.NotStarted)

    fun getCars() {
        val listCars = mutableListOf<Car>()
        actionEvent.value = ActionEvent.Started
        viewModelScope.launch {
            getDataUseCase.execute().collect {
                listCars.add(it)
                _sharedFlowCars.emit(listCars)
            }
        }
    }

    fun toSecondFragment() {
        navigate(R.id.action_firstFragment_to_secondFragment)
    }
}