package com.example.homeflixapplication.activity

import android.R.id
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.homeflixapplication.HomeFragment
import com.example.homeflixapplication.R
import com.example.homeflixapplication.SavedFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction


class FilmItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_item)

        val savedBtn: ImageButton = findViewById(R.id.saveDataInSavedFragment)
        val playYoutubeBtn:ImageButton = findViewById(R.id.youtubePlay)
        val backHomePageBtn:ImageButton = findViewById(R.id.backHomePage)
        val savedFragment = SavedFragment()


        backHomePageBtn.setOnClickListener{
            val fragment: Fragment = HomeFragment.newInstance()
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.conteinerFilms, fragment).commit()
            finish()
        }
        playYoutubeBtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=eOqtBtWGl1Q"))
            startActivity(intent)
        }
        savedBtn.setOnClickListener{
            finish()
        }
    }
}