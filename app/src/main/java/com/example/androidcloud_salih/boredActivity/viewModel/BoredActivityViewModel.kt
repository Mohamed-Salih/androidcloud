package com.example.androidcloud_salih.boredActivity.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.androidcloud_salih.boredActivity.model.BoredActivityRoom
import com.example.androidcloud_salih.boredActivity.model.BoredActivityUi
import com.example.androidcloud_salih.boredActivity.repository.BoredActivityRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BoredActivityViewModel : ViewModel() {

    private val boredActivityQuoteRepository: BoredActivityRepository by lazy { BoredActivityRepository() }
    var boredActivityQuoteLiveData: LiveData<List<BoredActivityUi>> = boredActivityQuoteRepository.selectAllBoredActivity().map {
            it.toUi()
        }

    fun fetchNewQuote() {
        viewModelScope.launch(Dispatchers.IO) {
            boredActivityQuoteRepository.fetchData()
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            boredActivityQuoteRepository.deleteAllBoredActivity()
        }
    }
}

private fun List<BoredActivityRoom>.toUi(): List<BoredActivityUi> {
    return asSequence().map {
        BoredActivityUi(
            activity = it.activity,
            type = it.type,
            participants = it.participants,
            price = it.price,
            link = it.link,
            key = it.key,
            accessibility = it.accessibility
        )
    }.toList()
}