package com.example.campusfacilitator.ui.home.profile

import androidx.lifecycle.ViewModel
import com.example.campusfacilitator.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}
