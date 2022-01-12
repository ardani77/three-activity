package com.muhammadardani.kmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var full_name: TextInputEditText
    private lateinit var input_palindrome: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        full_name = findViewById(R.id.fullName)
        input_palindrome = findViewById(R.id.palindromeCheck)
    }

    fun checkPalindrome(view: android.view.View) {
        val originalString = input_palindrome.text.toString()

        var reverseString = ""
        var length = originalString.length

        for (i in (length - 1) downTo 0) {
            reverseString = reverseString + originalString[i]
        }
        if (originalString.equals(reverseString, ignoreCase = true)) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Palindrome Result")
            builder.setMessage("isPalindrome")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }
            builder.show()
        } else {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Palindrome Result")
            builder.setMessage("not Palindrome")

            builder.setPositiveButton(android.R.string.yes) { dialog, which ->
                Toast.makeText(applicationContext,
                    android.R.string.yes, Toast.LENGTH_SHORT).show()
            }
            builder.show()
        }
    }

    fun nextActivity(view: android.view.View) {
        val intent = Intent(this@MainActivity, SecondScreen::class.java)
        intent.putExtra("full_name", full_name.text.toString())
        startActivity(intent)
        println(full_name.text.toString())
    }
}