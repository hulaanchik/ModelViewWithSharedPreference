package com.example.modelview.model

import android.widget.ExpandableListView
import com.google.gson.annotations.SerializedName
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import java.io.Serializable

class Data: Serializable  {
    @SerializedName("avatar")
    val avatar: String = ""
    @SerializedName("email")
    val email: String = ""
    @SerializedName("first_name")
    val firstName: String = ""
    @SerializedName("id")
    val id: Int = 0
    @SerializedName("last_name")
    val lastName: String = ""

    var ad: Ad? = null
}