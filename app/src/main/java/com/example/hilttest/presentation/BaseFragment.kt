package com.example.hilttest.presentation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.hilttest.navigation.NavigationCommand
import com.example.hilttest.navigation.observeNonNull

open class BaseFragment : Fragment() {

    fun observeNavigation(viewModel: BaseViewModel) {
        viewModel.navigation.observeNonNull(viewLifecycleOwner) {
            it.getContentIfNotHandled()?.let { navigationCommand ->
                handleNavigation(navigationCommand)
            }
        }
    }

    private fun handleNavigation(navCommand: NavigationCommand) {
        when (navCommand) {
            is NavigationCommand.Back -> findNavController().navigateUp()
            is NavigationCommand.ToDirection -> findNavController().navigate(navCommand.direction)
        }
    }
}