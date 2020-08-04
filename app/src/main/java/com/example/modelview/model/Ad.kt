package com.example.modelview.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable


class Ad: Serializable {
    @SerializedName("company")
    val company: String = ""

    @SerializedName("text")
    val text: String = ""

    @SerializedName("url")
    val url: String = ""
}