package com.example.sayac

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import android.animation.ObjectAnimator
import android.view.View


class MainActivity : ComponentActivity() {
    private lateinit var txtCounter: TextView
    private lateinit var editTextAmount: EditText
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCounter = findViewById(R.id.txtCounter)
        editTextAmount = findViewById(R.id.editTextAmount)
        val btnIncrease: Button = findViewById(R.id.btnIncrease)
        val btnReset: Button = findViewById(R.id.btnReset)

        btnIncrease.setOnClickListener {

            // Buton boyut animasyonu uygula
            animateButton(btnIncrease)

            val amountString = editTextAmount.text.toString()
            if (amountString.isNotEmpty()) {
                val amount = amountString.toInt()
                counter += amount
                txtCounter.text = counter.toString()
            } else {
                counter++
                txtCounter.text = counter.toString()
            }
        }

        btnReset.setOnClickListener {
            animateButton(btnReset)
            counter = 0
            txtCounter.text = counter.toString()
            editTextAmount.text.clear() // Giriş alanını temizle
        }
    }

    private fun animateButton(view: View) {
        // X ekseninde ölçeklendirme animasyonu
        val scaleX = ObjectAnimator.ofFloat(view, "scaleX", 1f, 1.2f, 1f)
        // Y ekseninde ölçeklendirme animasyonu
        val scaleY = ObjectAnimator.ofFloat(view, "scaleY", 1f, 1.2f, 1f)

        // Animasyon süresi
        scaleX.duration = 200
        scaleY.duration = 200

        // Animasyonları başlat
        scaleX.start()
        scaleY.start()
    }
}
