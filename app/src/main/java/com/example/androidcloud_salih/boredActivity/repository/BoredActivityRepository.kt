package com.example.androidcloud_salih.boredActivity.repository

import androidx.lifecycle.LiveData
import com.example.androidcloud_salih.architecture.CustomApplication
import com.example.androidcloud_salih.architecture.RetrofitBuilder
import com.example.androidcloud_salih.boredActivity.model.BoredActivityRetrofit
import com.example.androidcloud_salih.boredActivity.model.BoredActivityRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BoredActivityRepository {

    private val boredActivityDao = CustomApplication.instance.mApplicationDatabase.boredActivityDao()

    fun selectAllBoredActivity(): LiveData<List<BoredActivityRoom>> {
        return boredActivityDao.selectAll()
    }

    private suspend fun insertBoredActivity(boredActivityQuote: BoredActivityRoom) =
        withContext(Dispatchers.IO) {
            boredActivityDao.insert(boredActivityQuote)
        }

    suspend fun deleteAllBoredActivity() = withContext(Dispatchers.IO) {
        boredActivityDao.deleteAll()
    }

    suspend fun fetchData() {
        insertBoredActivity(RetrofitBuilder.getBoredActivity().getRandomQuote().toRoom())
    }
}

private fun BoredActivityRetrofit.toRoom(): BoredActivityRoom {
    return BoredActivityRoom(
        activity = activity,
        type = type,
        participants = participants,
        price = price,
        link = link,
        key = key,
        accessibility = accessibility
    )
}
