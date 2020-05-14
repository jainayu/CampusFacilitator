package com.example.campusfacilitator.ui.auth

import com.example.campusfacilitator.data.db.entities.User

interface AuthListener  {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}