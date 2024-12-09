package com.example.agroclinic.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class PrastavikResponse(
	val code: Int? = null,
	val allInfo: List<AllInfoItem?>? = arrayListOf(),
	val message: String? = null,
	val status: String? = null
) : Parcelable

@Parcelize
data class AllInfoItem(
	val pName: String? = null,
	val pInfo: String? = null,
	val pId: Int? = null
) : Parcelable
