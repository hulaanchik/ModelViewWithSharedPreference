package com.example.modelview.user

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.modelview.R
import com.example.modelview.model.Data
import com.smartbank.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    private val fragmentManager = supportFragmentManager
    private val secondFragment = UserInfoFragment()
    private val firstFragment = DataFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame, DataFragment()).commit()
//    }
//    fun fragmentMethod() {
        replaceFragment(DataFragment())

    }


    fun nextFragment(item: Data) {
        addFragment(UserInfoFragment.newInstance(item))
    }


}
