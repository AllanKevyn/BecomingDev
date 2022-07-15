package com.example.becomingdev.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.becomingdev.R
import com.example.becomingdev.databinding.FragmentHomeBinding
import com.example.becomingdev.presentation.adapter.MembersAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

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
        setupObservers()
        setupAdapters()
    }

    private fun setupObservers(){

    }

    private fun setupAdapters(){
        membersAdapter = MembersAdapter()
        binding.rvMembers.adapter = membersAdapter
    }
}