package com.example.hilttest.presentation

sealed class ActionState {
    object Started : ActionState()
    object NotStarted : ActionState()
}
