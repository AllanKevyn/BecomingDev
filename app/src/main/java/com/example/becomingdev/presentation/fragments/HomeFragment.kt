package com.example.becomingdev.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.becomingdev.R
import com.example.becomingdev.base.States
import com.example.becomingdev.databinding.FragmentHomeBinding
import com.example.becomingdev.presentation.adapter.MembersAdapter
import com.example.becomingdev.presentation.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var membersAdapter: MembersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setup()
    }

    private fun setup(){
        viewModel.getMembers()
        setupObservers()
        setupAdapters()
    }

    private fun setupObservers(){
        viewModel.getMembersResult.observe(viewLifecycleOwner){
            when(it){
                is States.GetMembersState.Success ->{

                }
                is States.GetMembersState.Loading ->{

                }
                is States.GetMembersState.Failure ->{

                }
            }
        }
    }

    private fun setupAdapters(){
        membersAdapter = MembersAdapter()
        binding.rvMembers.adapter = membersAdapter
    }
}