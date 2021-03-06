package com.example.becomingdev.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.becomingdev.base.BaseViewModel
import com.example.becomingdev.base.States
import com.example.becomingdev.domain.usecase.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase): BaseViewModel() {

    private var _getMembersResult = MutableLiveData<States.GetMembersState>()
    val getMembersResult: LiveData<States.GetMembersState> = _getMembersResult


    fun getMembers(){
        viewModelScope.launch {homeUseCase.getMembers()
            .flowOn(Dispatchers.Main)
            .onStart { _getMembersResult.value = States.GetMembersState.Loading }
            .catch { _getMembersResult.value = States.GetMembersState.Failure(it.message.toString()) }
            .collect{ _getMembersResult.value = States.GetMembersState.Success(it)}
        }
    }
}