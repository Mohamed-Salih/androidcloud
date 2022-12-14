package com.example.androidcloud_salih.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidcloud_salih.dao.AndroidVersionDao
import com.example.androidcloud_salih.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao
}
