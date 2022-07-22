package com.example.becomingdev.data.api

import com.example.becomingdev.data.model.MembersItem
import javax.inject.Inject

class HomeApi @Inject constructor(private val homeEndPoint: HomeEndPoint) {

    suspend fun getMembers(): MembersItem = homeEndPoint.getMembers()

}