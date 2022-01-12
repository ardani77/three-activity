package com.muhammadardani.kmtest.data.api

import com.muhammadardani.kmtest.data.response.Data
import com.muhammadardani.kmtest.data.response.SelectedName
import com.muhammadardani.kmtest.data.response.Support
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("users?page=1&per_page=10")
    fun getSelectedName() :Call<SelectedName>
}