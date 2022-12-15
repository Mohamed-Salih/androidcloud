package com.example.androidcloud_salih.yourFeature.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcloud_salih.R
import com.example.androidcloud_salih.databinding.ActivityValuesBinding

class ValuesLandActivity: AppCompatActivity() {

    private lateinit var binding : ActivityValuesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityValuesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.switchValuesLand.text = getString(R.string.random_string)
        binding.switchValuesLand.isEnabled = resources.getBoolean(R.bool.flag)
    }
}