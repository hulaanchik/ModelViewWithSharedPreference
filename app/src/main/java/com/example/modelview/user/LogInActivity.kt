package com.example.modelview.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import androidx.core.view.isNotEmpty
import com.example.modelview.R
import com.example.modelview.component.CustomEditText
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.fragment_user_info.view.*

class LogInActivity : AppCompatActivity() {

    lateinit var mLogin : Button
    lateinit var mUsername : CustomEditText
    lateinit var mPassword: CustomEditText
    lateinit var mRemember: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        mLogin = findViewById(R.id.loginBtn)
        mUsername = findViewById(R.id.etUser)
        mPassword = findViewById(R.id.etPass)
        mRemember = findViewById(R.id.checkBox)

        mLogin.setOnClickListener{

            Log.d("hoho", etUser.toString())
            if (etUser.getText() == "k"
                && etPass.getText() == "1"
            )
            {
                Log.d("HERE", "THERE")
                val intent= Intent(applicationContext, AfterLoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else { print("Incorrect username or password")}
        }

//        mRemember.setOnClickListener(View.OnClickListener {
//            if (mRemember.isChecked){
//            if (SharedPref.login){
//            SharedPref.login = false
//            SharedPref.username = ""
//            SharedPref.pass = ""
//        } else {
//            val username = mUsername.text.toString()
//            val password = mPassword.text.toString()
//            if (username.isNotBlank()&& password.isNotBlank()){
//                SharedPref.login = true
//                SharedPref.username = username
//                SharedPref.pass = password
//            } else {}
//        }}} )
    }
}