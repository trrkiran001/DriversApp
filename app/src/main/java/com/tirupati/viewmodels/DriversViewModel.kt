package com.tirupati.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tirupati.repo.DriversApiResult
import com.tirupati.repo.DriversRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class DriversViewModel @Inject constructor(private val driverRepo: DriversRepository): ViewModel() {
    private val _data = MutableLiveData<List<String>>(emptyList())
    val data: LiveData<List<String>> = _data

    fun fetchDrivers() {
        viewModelScope.launch {
            Log.i("Kiran ", "printing from ViewModel : calling api")
            val result = driverRepo.getDriversData()

            if (result is DriversApiResult.DriversResult) {
                val namesList = result.response?.drivers?.map { driver ->
                    driver.driverName
                }
                _data.value = namesList?: emptyList()
            } else {
                //Api failed, retry??
                _data.value = emptyList()
            }
        }
    }
}