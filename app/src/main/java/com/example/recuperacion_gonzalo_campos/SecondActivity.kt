package com.example.recuperacion_gonzalo_campos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recuperacion_gonzalo_campos.databinding.ActivityRegistroBinding
import com.example.recuperacion_gonzalo_campos.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnListado.setOnClickListener { startActivity(Intent(this, ListadoActivity::class.java)) }
        binding.btnTest.setOnClickListener { startActivity(Intent(this, TestActivity::class.java)) }

    }


}