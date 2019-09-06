package OceaniaCountryList

import com.example.networking2.CountriesAPI
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//constructor arg is just a placeholder due to Kotlin requirements for data class

// t data class OceaniaCountryList(val country:  List<OceaniaCountry>)


    //} val country = List<OceaniaCountry()>
data class OceaniaCountry(   val countryName: String,
                             val alpha2code: String,
                             val capital: String,
                             val subregion: String)

class OceaniaCountriesRetriever {

    fun getOceaniaCountries(): Call<List<OceaniaCountry>> {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest/v2/") //was BASE_URL
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        val countriesAPI = retrofit.create(CountriesAPI::class.java)

        return countriesAPI.getCountries()
    }

}