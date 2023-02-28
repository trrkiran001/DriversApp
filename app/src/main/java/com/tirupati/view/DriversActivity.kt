package com.tirupati.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tirupati.DriversApp
import com.tirupati.R
import com.tirupati.databinding.ActivityMainBinding
import com.tirupati.view.adapters.DriversAdapter
import com.tirupati.viewmodels.DriversViewModel
import javax.inject.Inject

class DriversActivity : AppCompatActivity(), DriversClickListener {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: DriversViewModel by viewModels { viewModelFactory }

    @Inject
    lateinit var adapter: DriversAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        DriversApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.listener = this
        binding.lifecycleOwner = this
        adapter = DriversAdapter()

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@DriversActivity.adapter
        }


        viewModel.data.observe(this) { drivers ->
            adapter.setItems(drivers)
        }

    }

    override fun fetchDriverData() {
        viewModel.fetchDrivers()
    }

    override fun sortDriverData() {
        //TODO("Not yet implemented")
    }
}