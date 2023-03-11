package com.fauzan.submission2.ui.detail.followSection

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fauzan.submission2.api.ApiConfig
import com.fauzan.submission2.response.ItemsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowingViewModel : ViewModel() {
    val listFollowings = MutableLiveData<ArrayList<ItemsItem>>()

    fun setListFollowing(username: String) {
        ApiConfig.apiInstance
            .getFollowingUser(username)
            .enqueue(object : Callback<ArrayList<ItemsItem>> {
                override fun onResponse(
                    call: Call<ArrayList<ItemsItem>>,
                    response: Response<ArrayList<ItemsItem>>
                ) {
                    if (response.isSuccessful) {
                        listFollowings.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<ItemsItem>>, t: Throwable) {
                }

            })
    }

    fun getListFollowingUser(): LiveData<ArrayList<ItemsItem>> {
        return listFollowings
    }
}