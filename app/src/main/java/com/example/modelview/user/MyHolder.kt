package com.example.modelview.user

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.view_item.view.*

class MyHolder (v: View) : RecyclerView.ViewHolder(v) {
    val userFirstNameTextView = v.first_name
    val userLastNameTextView = v.last_name
    val avatarImgView = v.avatar
    val emailTextView = v.email
}

