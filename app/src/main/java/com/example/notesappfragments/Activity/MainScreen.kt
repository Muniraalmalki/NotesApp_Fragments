package com.example.notesappfragments.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.notesappfragments.R

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        Handler().postDelayed(Runnable {
            startActivity(Intent(this,MainActivity::class.java))
        },2000)
    }
}