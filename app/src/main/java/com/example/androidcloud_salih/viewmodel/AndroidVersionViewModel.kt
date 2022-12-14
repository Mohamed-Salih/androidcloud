package com.example.androidcloud_salih.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidcloud_salih.model.MyObjectForRecyclerView
import com.example.androidcloud_salih.repository.AndroidVersionRepository
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.androidcloud_salih.model.ObjectDataHeaderSample
import com.example.androidcloud_salih.model.ObjectDataSample
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AndroidVersionViewModel : ViewModel() {

    private val androidVersionRepository: AndroidVersionRepository by lazy { AndroidVersionRepository() }
    val androidVersionList: LiveData<List<MyObjectForRecyclerView>> = androidVersionRepository.selectAllAndroidVersion().map { list ->
        list.toMyObjectForRecyclerView()
    }

    fun insertAndroidVersion(androidName: String, androidCode: Int, url: String) {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.insertAndroidVersion(
                ObjectDataSample(androidName, androidCode, url)
            )
        }
    }

    fun deleteAllAndroidVersion() {
        viewModelScope.launch(Dispatchers.IO) {
            androidVersionRepository.deleteAllAndroidVersion()
        }
    }
}

private fun List<ObjectDataSample>.toMyObjectForRecyclerView(): List<MyObjectForRecyclerView> {
    val result = mutableListOf<MyObjectForRecyclerView>()

    groupBy {
        // Split in 2 list, modulo and not
        it.versionCode % 2 == 0
    }.forEach { (isModulo, items) ->
        // For each mean for each list split
        // Here we have a map (key = isModulo) and each key have a list of it's items
        result.add(ObjectDataHeaderSample("Is modulo : $isModulo"))
        result.addAll(items)
}
    return result
}