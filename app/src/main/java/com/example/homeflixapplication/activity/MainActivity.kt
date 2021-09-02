package com.example.homeflixapplication.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.homeflixapplication.BottomNavigationViewWithIndicator
import com.example.homeflixapplication.R


class MainActivity : AppCompatActivity(){
    private lateinit var bottomNavigationView: BottomNavigationViewWithIndicator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         bottomNavigationView = findViewById<BottomNavigationViewWithIndicator>(R.id.bottom_bar)
        val navController = findNavController(R.id.nav_fragment)
        bottomNavigationView.setupWithNavController(navController)

        }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("dwd","result=")
        val view: View = bottomNavigationView.findViewById(R.id.savedFragment)
        view.performClick()
        val view2: View = bottomNavigationView.findViewById(R.id.homeFragment)
        view2.performClick()

    }

    }

