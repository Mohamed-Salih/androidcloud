package com.example.androidcloud_salih.chuckNorris.repository

import androidx.lifecycle.LiveData
import com.example.androidcloud_salih.architecture.CustomApplication
import com.example.androidcloud_salih.architecture.RetrofitBuilder
import com.example.androidcloud_salih.chuckNorris.model.ChuckNorrisRetrofit
import com.example.androidcloud_salih.chuckNorris.model.ChuckNorrisRoom
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChuckNorrisQuoteRepository {

    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()

    fun selectAllChuckNorrisQuote(): LiveData<List<ChuckNorrisRoom>> {
        return chuckNorrisDao.selectAll()
    }

    private suspend fun insertChuckNorrisQuote(chuckNorrisQuote: ChuckNorrisRoom) =
        withContext(Dispatchers.IO) {
            chuckNorrisDao.insert(chuckNorrisQuote)
        }

    suspend fun deleteAllChuckNorrisQuote() = withContext(Dispatchers.IO) {
        chuckNorrisDao.deleteAll()
    }

    suspend fun fetchData() {
        insertChuckNorrisQuote(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }
}

private fun ChuckNorrisRetrofit.toRoom(): ChuckNorrisRoom {
    return ChuckNorrisRoom(
        quote = quote,
        iconUrl = iconUrl
    )
}
