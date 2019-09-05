package com.example.httpoperations
//initial commit
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_get.setOnClickListener{
            intent = Intent(this, GetActivity::class.java)
            startActivity(intent)
        }
        btn_put.setOnClickListener{
            intent = Intent(this, PutActivity::class.java)
            startActivity(intent)
        }

        btn_post.setOnClickListener{
            intent = Intent(this, PostActivity::class.java)
            startActivity(intent)

        }
        btn_delete.setOnClickListener{
            intent = Intent(this, DeleteActivity::class.java)
            startActivity(intent)
        }
    }
}
