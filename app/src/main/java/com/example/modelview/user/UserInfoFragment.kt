package com.example.modelview.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.modelview.R
import com.example.modelview.model.Ad
import com.example.modelview.model.Data
import com.example.modelview.model.Reqres
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_user_info.*
import kotlinx.android.synthetic.main.view_item.view.*
import java.io.Serializable


class UserInfoFragment : Fragment() {
    lateinit var avatarImgView: ImageView
    lateinit var firstNameTextView: TextView
    lateinit var lastNameTextView: TextView
    lateinit var emailTextView: TextView
    lateinit var companyTextView: TextView
    lateinit var textTextView: TextView
    lateinit var urlTextView: TextView
    var passedData: Data? = null
//    var passedAd: Ad? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let { passedData = it?.getSerializable("ARG") as Data }
//        arguments.also { passedAd = it?.getSerializable("AD") as Ad }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_user_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        avatarImgView = view.findViewById(R.id.avatar)
        firstNameTextView = view.findViewById(R.id.first_name)
        lastNameTextView = view.findViewById(R.id.last_name)
        emailTextView = view.findViewById(R.id.email)
        companyTextView = view.findViewById(R.id.company)
        textTextView = view.findViewById(R.id.text)
        urlTextView = view.findViewById(R.id.url)

        val dataUser = passedData
        Picasso.get()
            .load(dataUser?.avatar)
            .into(avatarImgView)
        val mFirstName = dataUser?.firstName
        firstNameTextView.text = mFirstName
        val mLastname = dataUser?.lastName
        lastNameTextView.text = mLastname
        val mEmail = dataUser?.email
        emailTextView.text = mEmail



        val dataInfo = passedData?.ad
        val mCompany = dataInfo?.company
        companyTextView.text = mCompany
        val mText = dataInfo?.text
        textTextView.text = mText
        val mUrl = dataInfo?.url
        urlTextView.text = mUrl
    }



    companion object {
        @JvmStatic
        fun newInstance(item: Data): UserInfoFragment {
            val bundle = Bundle()
            bundle.putSerializable("ARG", item)

            val data = UserInfoFragment()
            data.arguments = bundle
            return data
        }

    }

}
