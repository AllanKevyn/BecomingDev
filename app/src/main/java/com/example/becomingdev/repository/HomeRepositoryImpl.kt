package com.example.becomingdev.repository

import com.example.becomingdev.data.api.HomeApi
import com.example.becomingdev.data.model.MembersItem
import com.example.becomingdev.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val homeApi: HomeApi): HomeRepository {

    override suspend fun getMembers(): Flow<MembersItem> = flow{
        emit(homeApi.getMembers())
    }
}