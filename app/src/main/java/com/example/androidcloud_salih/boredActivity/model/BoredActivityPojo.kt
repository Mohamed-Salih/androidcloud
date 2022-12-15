package com.example.androidcloud_salih.boredActivity.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/** Object use for Ui */
data class BoredActivityUi(
    val activity: String,
    val type: String,
    val participants: Int,
    val price: Int,
    val link: String,
    val key: String,
    val accessibility: String
)

/** Object use for room */
@Entity(tableName = "bored_activities")
data class BoredActivityRoom(
    @ColumnInfo(name = "activity_text")
    val activity: String,
    @ColumnInfo(name = "type_text")
    val type: String,
    @ColumnInfo(name = "participants")
    val participants: Int,
    @ColumnInfo(name = "price")
    val price: Int,
    @ColumnInfo(name = "link")
    val link: String,
    @ColumnInfo(name = "key")
    val key: String,
    @ColumnInfo(name = "accessibility")
    val accessibility: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

/** Object use for retrofit */
data class BoredActivityRetrofit(
    @Expose
    @SerializedName("activity_text")
    val activity: String,

    @Expose
    @SerializedName("type_text")
    val type: String,

    @Expose
    @SerializedName("participants")
    val participants: Int,

    @Expose
    @SerializedName("price")
    val price: Int,

    @Expose
    @SerializedName("link")
    val link: String,

    @Expose
    @SerializedName("key")
    val key: String,

    @Expose
    @SerializedName("accessibility")
    val accessibility: String
)