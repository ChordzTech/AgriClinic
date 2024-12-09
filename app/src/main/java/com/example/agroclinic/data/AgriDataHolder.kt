package com.chordz.eprachar.data

import android.graphics.Bitmap
import android.net.Uri

object AgriDataHolder {
    var bmpUri: Uri? = null
    lateinit var ImageUrl: String
    var DailyCountUpdateTime: Long? = null
    var hourlyMessageUpdateTime: Long? = null
    var messageBitmap: Bitmap? = null
    var adminContactNumber = "0";
    var pracharContactsMap = HashMap<String, Int>()
    const val BASE_URL = "http://electionapi.beatsacademy.in"
    val PROVIDER_AUTHORITY: String = "com.chordz.eprachar.provider"



}