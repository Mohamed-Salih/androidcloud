package com.example.androidcloud_salih.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidcloud_salih.databinding.ActivityRecyclerViewBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var adapter: AndroidVersionAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the xml layout to attach to this activity
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter=AndroidVersionAdapter()

        val valueFromIntent = intent?.extras?.getString("MY_KEY")
        binding.recyclerView.adapter = adapter
    }
}