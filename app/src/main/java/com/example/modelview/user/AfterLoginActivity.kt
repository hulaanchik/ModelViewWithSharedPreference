package com.example.modelview.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.modelview.R

class AfterLoginActivity : AppCompatActivity() {

    lateinit var mRV: Button
    lateinit var mVP: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_after_login)

        mRV = findViewById<Button>(R.id.btnToRv)
        mVP = findViewById<Button>(R.id.btnToVP)

        mRV.setOnClickListener {
            Log.d("success", "success")
            val intent= Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            return@setOnClickListener
        }

        mVP.setOnClickListener {
            Log.d("successful", "successful")
            val intent= Intent(applicationContext, ViewPagerActivity::class.java)
            startActivity(intent)
            return@setOnClickListener
        }
    }
}