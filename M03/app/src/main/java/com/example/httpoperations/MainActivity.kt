package com.example.httpoperations
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    fun isNetworkConnected(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo?.isConnected == true}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_get.setOnClickListener{
            if (!isNetworkConnected()) {
                Snackbar.make(it, "Please check your internet connection and try again", Snackbar.LENGTH_LONG).show()
            } else {

            }

            startActivity(Intent(this@MainActivity, GetActivity::class.java))
        }
        btn_put.setOnClickListener{
            if (!isNetworkConnected()) {
                Snackbar.make(it, "Please check your internet connection and try again", Snackbar.LENGTH_LONG).show()
            } else {

            }

            startActivity(Intent(this@MainActivity, PutActivity::class.java))
        }

        btn_post.setOnClickListener{
            if (!isNetworkConnected()) {
                Snackbar.make(it, "Please check your internet connection and try again", Snackbar.LENGTH_LONG).show()
            } else {

            }

            startActivity(Intent(this@MainActivity, PostActivity::class.java))
        }
        btn_delete.setOnClickListener{
            if (!isNetworkConnected()) {
                Snackbar.make(it, "Please check your internet connection and try again", Snackbar.LENGTH_LONG).show()
            } else {

            }

            startActivity(Intent(this@MainActivity, GetActivity::class.java))
    }


}}
