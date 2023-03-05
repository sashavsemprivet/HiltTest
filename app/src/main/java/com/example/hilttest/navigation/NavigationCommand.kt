package com.example.hilttest.navigation

sealed class NavigationCommand {
    data class ToDirection(val direction: Int) : NavigationCommand()
    object Back : NavigationCommand()
}
