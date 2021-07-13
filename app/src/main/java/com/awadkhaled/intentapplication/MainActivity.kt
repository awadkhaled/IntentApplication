package com.awadkhaled.intentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EMAIL_KEY = "com.awadkhaled.intentapplication.email"
const val PASSWORD_KEY = "com.awadkhaled.intentapplication.password"
const val REQUEST_CODE = 1

class MainActivity : AppCompatActivity() {

    private lateinit var email : EditText
    private lateinit var password : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)

        if (savedInstanceState != null){
            email.setText(savedInstanceState.getCharSequence(EMAIL_KEY))
            password.setText(savedInstanceState.getCharSequence(PASSWORD_KEY))
        }

        findViewById<Button>(R.id.button_login).setOnClickListener {
            val intent = Intent(this,Destination::class.java).apply {
                putExtra(EMAIL_KEY,email.text.toString())
                putExtra(PASSWORD_KEY,password.text.toString())
            }
            startActivity(intent)
        }
    }

    override fun onResume() {
        Toast.makeText(this,"You are Logged In",Toast.LENGTH_LONG).show()
        super.onResume()
    }
}