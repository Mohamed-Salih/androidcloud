package com.example.androidcloud_salih.model

sealed class MyObjectForRecyclerView(label : String)

data class ObjectDataHeaderSample(
    val header: String
) : MyObjectForRecyclerView(label = header)

data class ObjectDataSample(
    val versionName: String,
    val versionCode: Int,
    val versionImage : String
) : MyObjectForRecyclerView(label = versionName)