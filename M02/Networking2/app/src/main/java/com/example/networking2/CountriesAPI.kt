package com.example.networking2

import OceaniaCountryList.OceaniaCountryList
import retrofit2.Call
import retrofit2.http.GET

interface CountriesAPI {
    @GET("/rest/v2/region/Oceania") //last portion of API URL
    fun getCountries(): Call<OceaniaCountryList>


}