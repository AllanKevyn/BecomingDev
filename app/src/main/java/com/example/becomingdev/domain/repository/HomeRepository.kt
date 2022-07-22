package com.example.becomingdev.domain.repository

import com.example.becomingdev.data.model.MembersItem
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getMembers(): Flow<MembersItem>
}