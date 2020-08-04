package com.example.modelview.user

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modelview.*
import com.example.modelview.model.Data
import com.example.modelview.model.Reqres
import com.example.recyclerview.MyAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.data_fragment.*

class DataFragment : Fragment() {

    private lateinit var viewModel: DataViewModel
    private lateinit var myAdapter: MyAdapter

    val userData = MutableLiveData<Reqres>()
    private val PREFS_NAME = "preferences"
    val sharedPreferencesData = LocalSharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("success", "true")
        return inflater.inflate(R.layout.data_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        myAdapter = MyAdapter()
        myAdapter.setOnImgClickListener (object : MyAdapter.OnImgClicklListener{
            override fun onClick(item: Data) {
                Log.d("TAG", ""+item.firstName)
                val req = viewModel.userData.value
                if (req != null) {
                   item.ad = req.ad
                }
                activity.let { (it as MainActivity).nextFragment(item) }
            }
        })
        recyclerView.apply{
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = myAdapter
        }
        viewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)
//        viewModel.getData()
        viewModel.fetchData()
        viewModel.getStatus().observe(viewLifecycleOwner, Observer {

        when { it.status == Resource.Status.SUCCESS -> {

            val data = it.data?.data
//            myAdapter.setItems(data.orEmpty())
//            Log.d("welcome", "welcome"+data.toString())
            val jsonDataList: String = Gson().toJson(it.data)
            val dataString = sharedPreferencesData.save("Datalist", jsonDataList)
            myAdapter.setItems(data.orEmpty())
            Log.d("welcome", "welcome"+jsonDataList)

        }
            it.status == Resource.Status.ERROR -> {

                it.exception!!.let{
                val json = sharedPreferencesData.getValueString("Datalist")
                val GsonDataList: Reqres = Gson().fromJson(json, Reqres::class.java)
                Log.d("dada", "dada"+GsonDataList)
//                Log.d("Gsonlist", "Gsonlist"+GsonDataList?.data.toString())
                    myAdapter.setItems(GsonDataList.data)

                }
            }
        }
        })
    }
}