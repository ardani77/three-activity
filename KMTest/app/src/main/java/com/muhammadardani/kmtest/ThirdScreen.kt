package com.muhammadardani.kmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.muhammadardani.kmtest.data.ListAdapter
import com.muhammadardani.kmtest.data.api.ApiService
import com.muhammadardani.kmtest.data.api.RetroInstance
import com.muhammadardani.kmtest.data.response.Data
import com.muhammadardani.kmtest.data.response.SelectedName
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdScreen : AppCompatActivity() {
    lateinit var adapter: com.muhammadardani.kmtest.data.ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)
        val retro = RetroInstance().getInstance().create(ApiService::class.java)
        val listViewId = findViewById<ListView>(R.id.listViewId)
        retro.getSelectedName().enqueue(object : Callback<SelectedName> {
            override fun onResponse(call: Call<SelectedName>, response: Response<SelectedName>) {
                val responseBody = response.body()
                val data = responseBody!!.data
                println(data)
                adapter = ListAdapter(data, this@ThirdScreen)
                listViewId.adapter = adapter

                listViewId.isClickable = true
                listViewId.setOnItemClickListener{parent, view, position, id ->
                    val full_name = intent.getStringExtra("full_name").toString()
                    val choose_name = data[position].first_name + " " + data[position].last_name
                    val intent = Intent(this@ThirdScreen, SecondScreen::class.java)
                    intent.putExtra("choose_name", choose_name)
                    intent.putExtra("full_name", full_name)
                    startActivity(intent)
                }
            }
            override fun onFailure(call: Call<SelectedName>, t: Throwable) {
                println(t.toString())
            }
        })
    }
}