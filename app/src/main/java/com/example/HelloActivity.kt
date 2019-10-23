package com.example

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class HelloActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello)
        val imageView : ImageView= findViewById<ImageView>(R.id.helloImg)
        val btnAnime : Button = findViewById<Button>(R.id.btnAnime)

        btnAnime.setOnClickListener { imageView.animate()
            .translationXBy(-1000f)
            .duration = 2000 }


    }
}