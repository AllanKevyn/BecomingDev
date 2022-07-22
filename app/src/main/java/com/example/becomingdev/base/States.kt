package com.example.becomingdev.base

import com.example.becomingdev.data.model.MembersItem

abstract class States {

    sealed class GetMembersState{
        object Loading: GetMembersState()
        data class Success(val members : MembersItem): GetMembersState()
        data class Failure(val error: String): GetMembersState()
    }

}
