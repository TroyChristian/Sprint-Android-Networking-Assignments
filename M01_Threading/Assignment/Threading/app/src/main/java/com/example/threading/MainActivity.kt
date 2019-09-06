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
 fun add(arg: Int, arg2: Int): Int{
    return arg + arg2
}
class MainActivity : AppCompatActivity() {
lateinit var process : MyAsyncTask
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //MyAsyncTask().execute
        process = MyAsyncTask()
        process.execute()
        add(2,2)

    }

    override fun onStop() {
        super.onStop()
        process.cancel(true)
    }

    fun primes(): Sequence<Long> {
        var i = 0L
        return sequence {
            generateSequence { i++ }
                .filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0L }) }
                .forEach { yield(it) }
        }


    }

    fun isVisible(arg: Boolean) {
        if (arg) {
            progressBar.visibility = View.VISIBLE
        } else {
            progressBar.visibility = INVISIBLE
        }
    }


   inner  class MyAsyncTask : AsyncTask<Unit, Int, String>() {
        override fun onPreExecute() {
            super.onPreExecute()

            isVisible(true)

        }


        override fun doInBackground(vararg p0: Unit?): String {
          return  primes().take(1000).joinToString(", ")


        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            isVisible(false)
             text.text = result


        }

    }
}















