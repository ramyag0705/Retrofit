package com.example.retrofit.Common

import com.example.retrofit.Network.APIService
import com.example.retrofit.Network.Retrofit


object Common {
    private const val BASE_URL = "https://www.simplifiedcoding.net/demos/"
    val getAPIService: APIService
    get() = Retrofit.getRetrofitClient(BASE_URL).create(APIService::class.java)
}