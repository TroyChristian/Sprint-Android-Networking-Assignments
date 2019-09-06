package com.example.networking2

import OceaniaCountryList.OceaniaCountryList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response


class MainActivity : AppCompatActivity(), Callback<OceaniaCountryList> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchCountriesButton.setOnClickListener {
            OceaniaCountriesRetriever().getOceaniaCountries().enqueue(this)
        }
    }

    override fun onFailure(call: Call<OceaniaCountryList>, t: Throwable) {
        t.printStackTrace()
        val response = "faliure; ${t.printStackTrace()}"
        Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(
        call: Call<OceaniaCountryList>,
        response: Response<OceaniaCountryList> // added logic to onResponse from assignment
    ) {  if (response.isSuccessful) {
        val oceaniaCountryList = response.body()
        countriesTextView.text = "" // use "oceaniaCountryList" to populate this TextView
    } else {
        val response = "response not successful; ${response.errorBody().toString()}"
        Toast.makeText(this@MainActivity, response, Toast.LENGTH_SHORT).show()
    }
    }
    }


