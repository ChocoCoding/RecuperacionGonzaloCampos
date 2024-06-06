package com.example.recuperacion_gonzalo_campos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recuperacion_gonzalo_campos.databinding.ActivityRegistroBinding

class RegistroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener{
            if(binding.txtUsuario.text.isNotEmpty() && validarPass()){
                Toast.makeText(this, getString(R.string.registro_realizado), Toast.LENGTH_SHORT).show()
            }else if (binding.txtUsuario.text.isEmpty()){
                Toast.makeText(this, getString(R.string.debes_introducir_un_nombre_de_usuario), Toast.LENGTH_SHORT).show()
            }else if(binding.txtContra.text.isEmpty()){
                Toast.makeText(this, getString(R.string.debes_introducir_una_contrase_a), Toast.LENGTH_LONG).show()
            }else if(binding.txtContra.text.length<6){
                Toast.makeText(this, getString(R.string.la_contrase_a_debe_ser_superior_a_7_caracteres), Toast.LENGTH_LONG).show()
            }else if(binding.txtContra.text.toString() != binding.txtRepetirContra.text.toString()){
                Toast.makeText(this, getString(R.string.las_contrase_as_no_coinciden), Toast.LENGTH_LONG).show()
            }
        }
        binding.txtVerPassword.setOnClickListener {
            if (binding.txtVerPassword.text == getString(R.string.ver_contrase_a)){
                binding.txtVerPassword.text = getString(R.string.ocultar_contrase_a)
                binding.txtContra.inputType = 1
            }else{
                binding.txtVerPassword.text = getString(R.string.ver_contrase_a)
                binding.txtContra.inputType = 65665
            }
        }
    }

    fun validarPass(): Boolean{
        var valida = true
        if(binding.txtContra.text.isEmpty() || binding.txtContra.text.length<7 || binding.txtRepetirContra.text.toString() != binding.txtContra.text.toString()){
            valida = false
        }
        return valida
    }
}