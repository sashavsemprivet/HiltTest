package com.example.hilttest.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hilttest.navigation.EventNavigation
import com.example.hilttest.navigation.NavigationCommand

open class BaseViewModel : ViewModel() {
    private val _navigation = MutableLiveData<EventNavigation<NavigationCommand>>()
    val navigation: LiveData<EventNavigation<NavigationCommand>> get() = _navigation

    fun navigate(navDirections: Int) {
        _navigation.value = EventNavigation(NavigationCommand.ToDirection(navDirections))
    }
}