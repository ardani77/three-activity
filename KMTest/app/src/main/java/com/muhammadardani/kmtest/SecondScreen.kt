package com.muhammadardani.kmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class SecondScreen : AppCompatActivity() {
    private lateinit var full_name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
//        val bundle : Bundle? = intent.extras
        full_name = intent.getStringExtra("full_name").toString()

        findViewById<TextView>(R.id.fullNameSecond).text = full_name
        var choose_name = intent.getStringExtra("choose_name").toString()
        if (choose_name == "null"){
            choose_name = "Selected User Name"
        }
        findViewById<TextView>(R.id.selectedUserName).text = choose_name
    }

    fun chooseName(view: android.view.View) {
        val intent = Intent(this, ThirdScreen::class.java)
        intent.putExtra("full_name", full_name)
        startActivity(intent)
    }
}