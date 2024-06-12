package com.example.recuperacion_gonzalo_campos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recuperacion_gonzalo_campos.databinding.ActivitySecondBinding
import com.example.recuperacion_gonzalo_campos.databinding.ActivityTestBinding

class TestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getStringExtra("NOMBRE").toString()
        intent.putExtra("NOMBRE",user)
        var cont1 = 0
        var cont2= 0
        var cont3= 0

        // _ Es para indicar que no necesitamos el parametro de grupo
        binding.radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.r1 -> cont1++
                R.id.r2 -> cont1 = comprobarContador(cont1)
                R.id.r3 -> cont1 = comprobarContador(cont1)
            }
        }

        binding.RadioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.r4 -> cont2 = comprobarContador(cont2)
                R.id.r5 -> cont2 = comprobarContador(cont2)
                R.id.r6 -> cont2++
            }
        }

        binding.RadioGroup3.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.r7 -> cont3 = comprobarContador(cont3)
                R.id.r8 -> cont3 = comprobarContador(cont3)
                R.id.r9 -> cont3++
            }
        }
        binding.btnTestAtras.setOnClickListener {
            val intentContadorAtras = Intent(this,SecondActivity::class.java)
            intentContadorAtras.putExtra("NOMBRE",user)
            startActivity(Intent(intentContadorAtras)) }

        binding.btnEnviarTest.setOnClickListener{
            var contTotal = cont1+cont2+cont3
            Toast.makeText(this,"Has acertado $contTotal",Toast.LENGTH_SHORT).show()
        }
    }
}

fun comprobarContador(cont:Int):Int{
    var nuevoCont = 0
    if (cont > 0){
        nuevoCont = 0;
    }
    return nuevoCont;
}