package com.example.agroclinic.data

import com.example.agroclinic.data.remote.NetworkState
import com.example.agroclinic.data.remote.RetroFitService
import com.example.agroclinic.data.response.SugarCaneResponse
import com.example.agroclinic.data.response.PrastavikResponse
import com.example.agroclinic.data.response.SoilResponse


class MainRepository constructor(private val retroFitService: RetroFitService) {


    suspend fun getPrastavik(): NetworkState<PrastavikResponse> {
        val response = retroFitService.getPrastavik()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }

    suspend fun getSoil(): NetworkState<SoilResponse> {
        val response = retroFitService.getSoil()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }

    suspend fun getSugarCane(): NetworkState<SugarCaneResponse> {
        val response = retroFitService.getSugarCane()
        return if (response.isSuccessful) {
            val responseBody = response.body()
            if (responseBody != null) {
                NetworkState.Success(responseBody)
            } else {
                NetworkState.Error(response)
            }
        } else {
            NetworkState.Error(response)
        }
    }

}