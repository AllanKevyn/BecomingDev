package com.example.becomingdev.domain.usecase

import com.example.becomingdev.data.model.MembersItem
import com.example.becomingdev.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//interface IHomeUseCase{
//    suspend fun getMembers(): Flow<MembersItem>
//}

class HomeUseCase @Inject constructor(private val homeRepository: HomeRepository) {

     suspend fun getMembers(): Flow<MembersItem> {
        return homeRepository.getMembers()
    }
}