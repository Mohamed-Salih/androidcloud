package com.example.androidcloud_salih.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidcloud_salih.boredActivity.dao.BoredActivityDao
import com.example.androidcloud_salih.boredActivity.model.BoredActivityRoom


@Database(
    entities = [
        BoredActivityRoom::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun boredActivityDao() : BoredActivityDao
}

