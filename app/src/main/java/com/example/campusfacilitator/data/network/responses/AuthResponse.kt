package com.example.campusfacilitator.data.network.responses

import com.example.campusfacilitator.data.db.entities.User

data class AuthResponse (
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
){
}