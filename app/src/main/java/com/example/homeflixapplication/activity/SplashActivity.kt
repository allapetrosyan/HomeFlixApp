package com.example.homeflixapplication.activity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.SharedPreferences
import android.widget.Button
import com.example.homeflixapplication.R


class SplashActivity : AppCompatActivity() {
    lateinit var loginPreference: SharedPreferences
    lateinit var startMainBtn: Button
    private val MY_PREF = "my_pref"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startMainBtn = findViewById(R.id.startMainActivityBtn)

        loginPreference = getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)


            if (loginPreference.getString("tag", "notok").equals("notok")) {
                val edit: SharedPreferences.Editor = loginPreference.edit()
                edit.putString("tag", "ok")
                edit.commit()
            } else if (loginPreference.getString("tag", null).equals("ok")) {
                val i = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(i)
                finish()
            }

        startMainBtn.setOnClickListener{
            var i  = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(i)

        }
    }
    }