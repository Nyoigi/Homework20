package com.example.homework20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.homework20.presentation.MainFragment
import com.example.homework20.utils.navigateToFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigateToFragment(fragment = MainFragment())
    }
}