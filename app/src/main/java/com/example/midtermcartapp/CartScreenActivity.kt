package com.example.midtermcartapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.ImageView

class CartScreenActivity : AppCompatActivity() {

    private var itemCountVar = 1              // რაოდენობა (default 1)
    private var itemUnitPrice = 0             // ერთეულის ფასი
    private var totalAmountVal = 0            // სრული ღირებულება

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_screen)

        // UI ელემენტები
        val backArrowIcon: ImageView = findViewById(R.id.backArrowIcon)
        val plusButton: TextView = findViewById(R.id.plusBtn)
        val minusButton: TextView = findViewById(R.id.minusBtn)
        val quantityDisplay: TextView = findViewById(R.id.quantityTxt)
        val priceLabel: TextView = findViewById(R.id.productPriceText)
        val totalDisplay: TextView = findViewById(R.id.totalLabel)
        val subtotalText: TextView = findViewById(R.id.subtotalLabel)
        val orderButton: Button = findViewById(R.id.placeOrderBtn)

        // Intent-დან ფასის მიღება
        itemUnitPrice = intent.getIntExtra(ProductScreenActivity.PRICE_TRANSFER_KEY, 0)

        // საწყისი მნიშვნელობების დაყენება
        priceLabel.text = "${itemUnitPrice}$"
        quantityDisplay.text = itemCountVar.toString()
        calculateTotalAmount()
        totalDisplay.text = "$totalAmountVal $"

        // სწორი ფორმა: "1 item" ან "2 items"
        val itemText = if (itemCountVar == 1) "item" else "items"
        subtotalText.text = "Subtotal ($itemCountVar $itemText)"

        // Plus ღილაკი - რაოდენობის გაზრდა
        plusButton.setOnClickListener {
            itemCountVar += 1
            updateDisplay(quantityDisplay, totalDisplay, subtotalText)
        }

        // Minus ღილაკი - რაოდენობის შემცირება
        minusButton.setOnClickListener {
            if (itemCountVar > 1) {
                itemCountVar -= 1
                updateDisplay(quantityDisplay, totalDisplay, subtotalText)
            }
        }

        // უკან ისარი
        backArrowIcon.setOnClickListener {
            finish()
        }

        // Place Order ღილაკი
        orderButton.setOnClickListener {
            val navigationIntent = Intent(this, SuccessScreenActivity::class.java)
            navigationIntent.putExtra("ORDER_TOTAL_KEY", totalAmountVal)
            startActivity(navigationIntent)
            finish()
        }
    }

    // სრული ღირებულების გამოთვლა
    private fun calculateTotalAmount() {
        totalAmountVal = itemUnitPrice * itemCountVar
    }

    // Display-ების განახლება
    private fun updateDisplay(quantityView: TextView, totalView: TextView, subtotalView: TextView) {
        quantityView.text = itemCountVar.toString()
        calculateTotalAmount()
        totalView.text = "$totalAmountVal $"

        // სწორი ფორმა: "1 item" ან "2 items"
        val itemText = if (itemCountVar == 1) "item" else "items"
        subtotalView.text = "Subtotal ($itemCountVar $itemText)"
    }
}