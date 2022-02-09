package com.christopher.calculator

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var amountDue: EditText
    private lateinit var amountTipTextView: TextView
    private lateinit var grandTotalTextView: TextView
    private lateinit var tipPercentageRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        amountDue = findViewById(R.id.num_attend_edit_text)
        amountTipTextView = findViewById(R.id.num_pizzas_text_view)
        grandTotalTextView = findViewById(R.id.grandTotal)
        tipPercentageRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    fun calculateClick(view: View) {

        // Get the text that was typed into the EditText
        val  amountDueStr = amountDue.text.toString()

        // Convert the text into an integer
        val  amountDueInt =  amountDueStr.toIntOrNull() ?: 0

        // Determine how many slices on average each person will eat
        val percentageSelected = when (tipPercentageRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 0.10
            R.id.medium_radio_button -> 0.15
            else -> 0.20
        }
        if(amountDueInt > 0) {
            // Calculate and show the number of pizzas needed
            val totalTip = amountDueInt.toDouble() * percentageSelected.toDouble()
            amountTipTextView.text = "Tip: $totalTip"

            val grandTotal = amountDueInt.toDouble() + totalTip.toDouble()
            grandTotalTextView.text = "Grand Total: $grandTotal"
        }
        else{
            Toast.makeText(this, "Please enter a number greater than 0", Toast.LENGTH_SHORT ).show()
        }
    }
}