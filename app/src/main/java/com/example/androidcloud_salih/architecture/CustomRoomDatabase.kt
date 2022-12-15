package com.example.androidcloud_salih.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidcloud_salih.chuckNorris.dao.ChuckNorrisDao
import com.example.androidcloud_salih.chuckNorris.model.ChuckNorrisRoom
import com.example.androidcloud_salih.yourFeature.dao.AndroidVersionDao
import com.example.androidcloud_salih.yourFeature.model.LocalDataSourceSample

@Database(
    entities = [
        LocalDataSourceSample::class,
        ChuckNorrisRoom::class
    ],
    version = 2,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun androidVersionDao(): AndroidVersionDao

    abstract fun chuckNorrisDao() : ChuckNorrisDao
}

