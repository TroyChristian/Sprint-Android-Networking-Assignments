package Retrofit

import Model.Employee
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApi {




    @GET("employee/{id}")
    fun getEmployees(): Call<List<Employee>>

    @GET("employee/{id}")
    fun getEmployeesById(@Path("id")employeeId:String)

    @GET("employee")
    fun getEmployeeByAge(employeeId: String)}