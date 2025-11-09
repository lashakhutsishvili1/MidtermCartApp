package com.example.midtermcartapp

import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ProductScreenActivity : AppCompatActivity() {
    companion object {
        const val PRICE_TRANSFER_KEY = "PRICE_TRANSFER_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_screen)

        // ფასი
        val unitCostVal = 120

        // ძველი ფასის strikethrough
        val oldPriceTextView: TextView = findViewById(R.id.oldPriceText)
        oldPriceTextView.paintFlags = oldPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG

        // Add to Cart ღილაკი
        val addBtn: Button = findViewById(R.id.addToCartBtn)
        addBtn.setOnClickListener {
            val i = Intent(this, CartScreenActivity::class.java)
            i.putExtra(PRICE_TRANSFER_KEY, unitCostVal)
            startActivity(i)
        }
    }
}