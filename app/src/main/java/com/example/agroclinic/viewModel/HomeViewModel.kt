package com.example.agroclinic.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.agroclinic.data.MainRepository
import com.example.agroclinic.data.remote.NetworkState
import com.example.agroclinic.data.response.SugarCaneResponse
import com.example.agroclinic.data.response.PrastavikResponse
import com.example.agroclinic.data.response.SoilResponse
import kotlinx.coroutines.launch

class HomeViewModel(val repository: MainRepository) : BaseViewModel() {

    var prastavikLiveData = MutableLiveData<PrastavikResponse>()
        get() = field

    var soilInfoLiveData=MutableLiveData<SoilResponse>()
        get() = field
    var sugarCaneInfo=MutableLiveData<SugarCaneResponse>()
        get()=field

    fun getPrastavikMsg() {

        viewModelScope.launch {
            when (val response = repository.getPrastavik()) {
                is NetworkState.Success -> {
                    prastavikLiveData.postValue(response.data!!)
                }

                is NetworkState.Error -> {
                    if (response.response.code() == 401) {
//                        estimateList.postValue(NetworkState.Error())
                    } else {
//                        estimateList.postValue(NetworkState.Error)
                    }
                }

            }
        }
    }

    fun getSoil() {
        viewModelScope.launch {
            when (val response = repository.getSoil()) {
                is NetworkState.Success -> {
                    soilInfoLiveData.postValue(response.data!!)
                }

                is NetworkState.Error -> {
                    if (response.response.code() == 401) {
//                        estimateList.postValue(NetworkState.Error())
                    } else {
//                        estimateList.postValue(NetworkState.Error)
                    }
                }

            }
        }
    }
    fun getSugarCane() {
        viewModelScope.launch {
            when (val response = repository.getSugarCane()) {
                is NetworkState.Success -> {
                    sugarCaneInfo.postValue(response.data!!)
                }

                is NetworkState.Error -> {
                    if (response.response.code() == 401) {
//                        estimateList.postValue(NetworkState.Error())
                    } else {
//                        estimateList.postValue(NetworkState.Error)
                    }
                }

            }
        }
    }
}