package com.example.androidcloud_salih.boredActivity.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidcloud_salih.boredActivity.model.BoredActivityRoom

@Dao
interface BoredActivityDao {

    @Query("SELECT * FROM bored_activities")
    fun selectAll() : LiveData<List<BoredActivityRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(boredActivityRoom: BoredActivityRoom)

    @Query("DELETE FROM bored_activities")
    fun deleteAll()
}