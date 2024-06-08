package com.example.recuperacion_gonzalo_campos

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.recuperacion_gonzalo_campos.databinding.ActivityContadorBinding

class ContadorActivity : AppCompatActivity() {
    private lateinit var binding : ActivityContadorBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var cont = 8;
        binding.Texto.text = "Haz click $cont veces más"

        binding.imagePescador.setOnClickListener{
            cont--
            binding.Texto.text = "Haz click $cont veces más"
            updateTextColor(cont)
            if (cont == 0){
                binding.imagePescador.visibility = android.view.View.INVISIBLE
                binding.imgPez.visibility = android.view.View.VISIBLE
                Toast.makeText(this, getString(R.string.han_picado), Toast.LENGTH_LONG).show()
                binding.Texto.text = ""
            }
        }

        binding.btnContadorAtras.setOnClickListener{
            startActivity(Intent(this,SecondActivity::class.java))
        }

    }

    private fun updateTextColor(count: Int) {
        val color = when (count) {
            in 1..3 -> ContextCompat.getColor(this, android.R.color.holo_red_dark)
            in 4..6 -> ContextCompat.getColor(this, android.R.color.holo_blue_dark)
            else -> ContextCompat.getColor(this, android.R.color.black)
        }
        binding.Texto.setTextColor(color)
    }
}