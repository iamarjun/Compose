package com.example.jetpackcompose

import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.actvity_main) {

    companion object {
        private const val TAG = "MainActivity"
    }
}