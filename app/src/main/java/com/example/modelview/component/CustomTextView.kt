package com.example.modelview.component

import android.view.View
import android.widget.TextView
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class CustomTextView  (
    private val txtView: TextView,
    private val hideWhenEmpty: Boolean = true
)  : ReadWriteProperty<View, String?>{

    private var value: String? = null

    override fun getValue(thisRef: View, property: KProperty<*>): String? {
        return value
    }

    override fun setValue(thisRef: View, property: KProperty<*>, value: String?) {
        this.value = value
        txtView.text = value
//        txtView.isGone = hideWhenEmpty && value.isNullOrEmpty()
    }
}