package com.example.threading
//initial commit
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.app.TaskStackBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        }



    fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                .forEach { yield(it) }
        }


    }

    fun isVisible(arg:Boolean){
        if(arg){progressBar.visibility = View.VISIBLE
        }
        else{progressBar.visibility = INVISIBLE}


        class MyAsyncTask : AsyncTask<Unit, Int, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            val progressBar: ProgressBar = progressBar
            isVisible(true)

        }



        override fun doInBackground(vararg p0: Unit?): String {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            val primeNumbers = primes().take(16000).joinToString(", ")
            text.text = "Primes: $primeNumbers"


        }

            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)
                isVisible(true)



            }

    }
}}
















