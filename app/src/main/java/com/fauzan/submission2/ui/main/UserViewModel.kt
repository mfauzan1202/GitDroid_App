package com.fauzan.submission2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fauzan.submission2.api.ApiConfig
import com.fauzan.submission2.response.ItemsItem
import com.fauzan.submission2.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel : ViewModel() {

    val listUsers = MutableLiveData<ArrayList<ItemsItem>>()

    fun setUser(query: String) {
        ApiConfig.apiInstance
            .getUser(query)
            .enqueue(object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful) {
                        listUsers.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                }

            })
    }

    fun getUser(): LiveData<ArrayList<ItemsItem>> {
        return listUsers
    }
}