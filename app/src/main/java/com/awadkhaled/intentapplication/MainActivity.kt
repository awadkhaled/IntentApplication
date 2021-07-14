package com.awadkhaled.intentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EMAIL_KEY = "com.awadkhaled.intentapplication.email"
const val PASSWORD_KEY = "com.awadkhaled.intentapplication.password"
const val REQUEST_CODE = 1

class MainActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        email = findViewById(R.id.editTextTextEmailAddress)
        password = findViewById(R.id.editTextTextPassword)

        findViewById<Button>(R.id.button_login).setOnClickListener {
            val intent = Intent(this, Destination::class.java).apply {
                putExtra(EMAIL_KEY, email.text.toString())
                putExtra(PASSWORD_KEY, password.text.toString())
            }
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            REQUEST_CODE -> {
                if (resultCode == RESULT_OK) Toast.makeText(this,"Every Thing is OK",Toast
                    .LENGTH_LONG).show()
            }
        }
    }
}