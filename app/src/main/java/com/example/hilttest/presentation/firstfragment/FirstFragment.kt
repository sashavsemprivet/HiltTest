package com.example.hilttest.presentation.firstfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.hilttest.databinding.FragmentFirstBinding
import com.example.hilttest.domain.Car
import com.example.hilttest.presentation.ActionState
import com.example.hilttest.presentation.BaseFragment
import com.example.hilttest.presentation.recyclerview.CarsRecyclerViewAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FirstFragment : BaseFragment() {

    private lateinit var binding: FragmentFirstBinding

    //    private val viewModel: FirstFragmentViewModel by viewModels()
    private val viewModel: FirstFragmentViewModel by activityViewModels()

    lateinit var adapter: CarsRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeNavigation(viewModel)

        binding.buttonToSecond.setOnClickListener {
            viewModel.toSecondFragment()
        }

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.actionState.collect {
                when (it) {
                    ActionState.NotStarted -> {
                        viewModel.getCars()
                        val list = mutableListOf<Car>(Car(22, "7777"))
                        adapter = CarsRecyclerViewAdapter(list)
                        binding.recyclerview.adapter = adapter
                    }
                    ActionState.Started -> println("Hello")
                }
            }
        }



        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.sharedFlowCars.collect {

                adapter.setListOfCars(it)
//                binding.recyclerview.adapter = CarsRecyclerViewAdapter(it)

            }
        }
    }
}