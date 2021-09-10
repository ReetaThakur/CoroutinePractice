package com.example.coroutinepractice


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface apiClient {

    @GET(" /api/users/{ID}")
    suspend fun getUserDetails(@Path("ID")id:Int): Response<ResponseDTO>
}