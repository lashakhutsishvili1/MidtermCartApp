package com.example.midtermcartapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class StartScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_screen)

        val goBtn: Button = findViewById(R.id.goToProductBtn)
        goBtn.setOnClickListener {
            val i: Intent = Intent(this, ProductScreenActivity::class.java)
            startActivity(i)
        }
    }
}
