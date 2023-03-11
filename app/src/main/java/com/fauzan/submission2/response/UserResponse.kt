package com.fauzan.submission2.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
	@field:SerializedName("items")
	val items: ArrayList<ItemsItem>
)