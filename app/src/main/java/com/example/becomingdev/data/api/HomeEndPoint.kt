package com.example.becomingdev.data.api

import com.example.becomingdev.data.model.MembersItem
import retrofit2.http.GET

interface HomeEndPoint {

    @GET("developers")
    suspend fun getMembers(): MembersItem

}