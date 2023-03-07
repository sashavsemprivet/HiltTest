package com.example.hilttest.presentation

sealed class ActionEvent {
    object Started : ActionEvent()
    object NotStarted : ActionEvent()
}
