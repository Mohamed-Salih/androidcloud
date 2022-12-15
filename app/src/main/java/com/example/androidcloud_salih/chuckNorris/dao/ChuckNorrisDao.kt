package com.example.androidcloud_salih.chuckNorris.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidcloud_salih.chuckNorris.model.ChuckNorrisRoom

@Dao
interface ChuckNorrisDao {

    @Query("SELECT * FROM chuck_norris_quote")
    fun selectAll() : LiveData<List<ChuckNorrisRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(chuckNorrisRoom: ChuckNorrisRoom)

    @Query("DELETE FROM chuck_norris_quote")
    fun deleteAll()
}