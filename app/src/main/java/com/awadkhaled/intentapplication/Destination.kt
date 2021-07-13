package com.awadkhaled.intentapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Destination : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        findViewById<TextView>(R.id.textView_email).apply {
            text = intent.getStringExtra(EMAIL_KEY)
        }
        findViewById<TextView>(R.id.textView_paasword).apply {
            text = intent.getStringExtra(
                PASSWORD_KEY
            )
        }

        findViewById<Button>(R.id.finish).setOnClickListener {
            finish()
        }
    }
}