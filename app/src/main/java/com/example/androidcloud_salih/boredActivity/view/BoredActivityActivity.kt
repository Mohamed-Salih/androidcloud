package com.example.androidcloud_salih.boredActivity.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcloud_salih.boredActivity.model.BoredActivityUi
import com.example.androidcloud_salih.boredActivity.viewModel.BoredActivityViewModel
import com.example.androidcloud_salih.databinding.ActivityBoredActivityBinding

class BoredActivityActivity : AppCompatActivity() {

    private lateinit var viewModel: BoredActivityViewModel
    private lateinit var binding : ActivityBoredActivityBinding
    private val adapter : BoredActivityAdapter = BoredActivityAdapter()

    private val observer = Observer<List<BoredActivityUi>> {
        adapter.submitList(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoredActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[BoredActivityViewModel::class.java]

        binding.boredActivityActivityRv.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.boredActivityActivityRv.adapter = adapter

        binding.boredActivityActivityAdd.setOnClickListener {
            viewModel.fetchNewQuote()
        }

        binding.boredActivityActivityDelete.setOnClickListener {
            viewModel.deleteAll()
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.boredActivityQuoteLiveData.observe(this, observer)
    }

    override fun onStop() {
        viewModel.boredActivityQuoteLiveData.removeObserver(observer)
        super.onStop()
    }
}