package com.example.modelview.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.RelativeLayout
import com.example.modelview.R
import kotlinx.android.synthetic.main.edit_text.view.*


class CustomEditText constructor(
    context: Context,
    attrs: AttributeSet? = null
) : RelativeLayout(context, attrs) {

//    public enum class Type(val text: String) {
//        MONEY("mone"),
//        PERCENT("perce")
//    }

//    var icon: Drawable? by IconView(login_user)
    fun getText() : String {
        return editText.text.toString()
    }

    init {

        LayoutInflater.from(context).inflate(R.layout.edit_text, this, true)

        attrs?.let {
            val a = getContext().obtainStyledAttributes(attrs, R.styleable.CustomEditText)
            val isUser = a.getBoolean(R.styleable.CustomEditText_user, false)
            val imgIcon: ImageView = findViewById(R.id.login_icon)

            imgIcon.setImageDrawable(a.getDrawable(R.styleable.CustomEditText_icon))
//            val myENum = a.getString(R.styleable.CustomEditText_type)
//
//            if (myENum == Type.PERCENT.text) {
//
//            }

            if (isUser) {

                val isTitle = a.getString(R.styleable.CustomEditText_title).apply {  }

                login_title.text = "Welcome"
                editText.hint = resources.getString(R.string.user_hint)
//                val myEdit = findViewById(R.id.login_user) as EditText
//                myEdit.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.login, 0)
//                icon = a.getDrawable(R.drawable.login)
            }
//                    setBackgroundColor(ContextCompat.getColor(context, android.R.color.black))
            else
            { editText.hint = resources.getString(R.string.pass_hint) }

            setHorizontalGravity(CENTER_HORIZONTAL)
//            setBackgroundResource(R.color.colorAccent)
            a.recycle()
        }

//        val rootview = inflate(context, R.layout.edit_text, this)
//        val attributeArray: TypedArray =
//            context.obtainStyledAttributes(attrs, R.styleable.CustomEditText)
//        val isUser = attributeArray.getBoolean(R.styleable.CustomEditText_user)
//
//        if (isUser) {
//            setBackgroundColor(ContextCompat.getColor(context, android.R.color.black))
//            hint = "Username"
//            Log.d("hint", hint as String)
//        } else {
//            //setBackgroundColor(ContextCompat.getColor(context, android.R.color.holo_green_light))
//            hint = "Password"
//        }
//        attributeArray.recycle()
//
//        setTextColor(ContextCompat.getColor(context, android.R.color.black))
//        val margin = resources.getDimensionPixelSize(R.dimen.margin_30)

//       layoutParams = LinearLayout.LayoutParams(
//        LinearLayout.LayoutParams.MATCH_PARENT,
//        LinearLayout.LayoutParams.WRAP_CONTENT
//        ).apply {
//        val margin = resources.getDimensionPixelSize(R.dimen.margin_30)
//        setMargins(margin, 20, margin, 10) }
    }

}

