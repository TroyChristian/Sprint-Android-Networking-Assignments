package OceaniaCountryList
//constructor arg is just a placeholder due to Kotlin requirements for data class

data class OceaniaCountryList(val country:  List<OceaniaCountry>)


    //} val country = List<OceaniaCountry()>
data class OceaniaCountry(   val countryName: String,
                             val alpha2code: String,
                             val capital: String,
                             val subregion: String)
