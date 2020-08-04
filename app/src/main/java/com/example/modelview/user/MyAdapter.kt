package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.modelview.R
import com.example.modelview.model.Data
import com.example.modelview.model.Reqres
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_item.view.*
import com.example.modelview.user.MyHolder


class MyAdapter : RecyclerView.Adapter<MyHolder>() {
    private var dataList = ArrayList<Data>()
    private lateinit var context: Context
    private lateinit var listener: OnImgClicklListener

    fun setOnImgClickListener(listener: OnImgClicklListener) {
        this.listener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        context = parent.context;

        return MyHolder(LayoutInflater.from(context).inflate(R.layout.view_item, parent, false))
    }

    fun setItems(list: List<com.example.modelview.model.Data>) {
        dataList = ArrayList(list)
        notifyDataSetChanged()
    }

    fun addItems(list: List<com.example.modelview.model.Data>) {
        dataList.addAll(list)
        notifyDataSetChanged()
    }


    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data = dataList[position]

        val userFirstNameTextView = holder.itemView.first_name
        val userLastNameTextView = holder.itemView.last_name
        val avatarImgView = holder.itemView.avatar
        val emailTextView = holder.itemView.email

        val firstName = data.firstName
        userFirstNameTextView.text = firstName

        val lastName = data.lastName
        userLastNameTextView.text = lastName

        Picasso.get()
            .load(data.avatar)
            .into(avatarImgView)

        val Email = data.email
        emailTextView.text = Email

        holder.avatarImgView.setOnClickListener {
            listener.onClick( data)
        }
    }

    public interface OnImgClicklListener {
        fun onClick(item: Data)

    }
}









