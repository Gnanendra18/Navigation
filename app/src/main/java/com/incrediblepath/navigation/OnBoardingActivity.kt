package com.incrediblepath.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class OnBoardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        supportActionBar?.hide()
        //Handler().postDelayed({},1000)
    }
}