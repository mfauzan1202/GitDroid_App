package com.fauzan.submission2.api

import com.fauzan.submission2.response.DetailResponse
import com.fauzan.submission2.response.ItemsItem
import com.fauzan.submission2.response.UserResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getUser(
        @Query("q") query: String
    ): Call<UserResponse>

    @GET("users/{username}")
    @Headers("Authorization: token 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")
    fun getDetailUser(
        @Path("username") username: String
    ): Call<DetailResponse>

    @GET("users/{username}/followers")
    @Headers("Authorization: token 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")
    fun getFollowerUser(
        @Path("username") username: String
    ): Call<ArrayList<ItemsItem>>

    @GET("users/{username}/following")
    @Headers("Authorization: token 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")
    fun getFollowingUser(
        @Path("username") username: String
    ): Call<ArrayList<ItemsItem>>
}