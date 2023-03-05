package com.example.hilttest.presentation.secondfragment

import com.example.hilttest.R
import com.example.hilttest.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SecondFragmentViewModel @Inject constructor() : BaseViewModel() {

    fun toFirstFragment() {
        navigate(R.id.action_secondFragment_to_firstFragment)
    }

}