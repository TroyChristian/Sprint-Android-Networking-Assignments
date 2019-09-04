package com.example.networking2

import OceaniaCountryList.OceaniaCountryList
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountriesAPI {
    @GET("/rest/v2/region/Oceania") //last portion of API URL
    fun getCountries(): Call<OceaniaCountryList>


}

class OceaniaCountriesRetriever {

    fun getOceaniaCountries(): Call<OceaniaCountryList> {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest/v2/all/") //was BASE_URL
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val countriesAPI = retrofit.create(CountriesAPI::class.java)

        return countriesAPI.getCountries()
    }

}