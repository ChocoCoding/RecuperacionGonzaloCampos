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

        val user = intent.getStringExtra("NOMBRE").toString()

        binding.textUsuarioLogeado.text = user

        val intentListado = Intent(this,ListadoActivity::class.java)
        intentListado.putExtra("NOMBRE",user)
        val intentTest = Intent(this,TestActivity::class.java)
        intentTest.putExtra("NOMBRE",user)
        val intentContadorArticulos = Intent(this,ContadorActivity::class.java)
        intentContadorArticulos.putExtra("NOMBRE",user)
        val intentSecondScreenAtras = Intent(this,MainActivity::class.java)
        intentSecondScreenAtras.putExtra("NOMBRE",user)

        binding.btnListado.setOnClickListener { startActivity(Intent(intentListado)) }
        binding.btnTest.setOnClickListener { startActivity(Intent(intentTest)) }
        binding.btnContadorArticulos.setOnClickListener { startActivity(Intent(intentContadorArticulos)) }
        binding.btnSecondScreenAtras.setOnClickListener { startActivity(Intent(intentSecondScreenAtras)) }

    }


}