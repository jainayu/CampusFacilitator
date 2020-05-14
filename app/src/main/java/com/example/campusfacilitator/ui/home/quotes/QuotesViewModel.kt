package com.example.campusfacilitator.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.example.campusfacilitator.data.repositories.QuotesRepository
import com.example.campusfacilitator.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

    val quotes by lazyDeferred {
        repository.getQuotes()
    }
}
