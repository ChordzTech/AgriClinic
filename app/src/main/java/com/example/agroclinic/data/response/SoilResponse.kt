package com.example.agroclinic.data.response

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class SoilResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("all_info")
	val allInfo: List<SoilInfo?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class SoilInfo(

	@field:SerializedName("m_name")
	val mName: String? = null,

	@field:SerializedName("m_info")
	val mInfo: String? = null,

	@field:SerializedName("m_id")
	val mId: Int? = null
) : Parcelable
