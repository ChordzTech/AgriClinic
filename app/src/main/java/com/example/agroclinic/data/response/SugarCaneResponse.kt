package com.example.agroclinic.data.response

import com.google.gson.annotations.SerializedName

data class SugarCaneResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("all_info")
	val allInfo: List<SugarCane?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class SugarCane(

	@field:SerializedName("u_name")
	val uName: String? = null,

	@field:SerializedName("u_id")
	val uId: Int? = null,

	@field:SerializedName("u_info")
	val uInfo: String? = null
)
