package com.example.coroutinepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var responseDTO: ResponseDTO
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiReeta=Network.getinstance().create(apiClient::class.java)
       btnClick.setOnClickListener {
           val job:Job=CoroutineScope(Dispatchers.Main).launch {
               val show=apiReeta
               txtFirstName.text=show.getUserDetails(1).body()!!.data!!.firstName.toString()
               txtLastName.text=show.getUserDetails(1).body()!!.data!!.lastName.toString()
           }
       }
        btnasync.setOnClickListener {
            val job:Job=CoroutineScope(Dispatchers.IO).async {
                val show1=apiReeta
                txtFirstName.text=show1.getUserDetails(2).body()!!.data!!.firstName.toString()
                txtLastName.text=show1.getUserDetails(2).body()!!.data!!.lastName.toString()
            }
        }
    }
}


