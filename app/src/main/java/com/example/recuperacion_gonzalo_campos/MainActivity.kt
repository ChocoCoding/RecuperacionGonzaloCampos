package com.example.recuperacion_gonzalo_campos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.recuperacion_gonzalo_campos.databinding.ActivityMainBinding
import com.example.recuperacion_gonzalo_campos.Usuario
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        var users = users
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogIn.setOnClickListener{
            if (binding.textUsuario.text.isNotEmpty() && validarPassword() && validCredentials(users,binding.textUsuario.text.toString(),binding.textPassword.text.toString())){
                val intent = Intent(this,SecondActivity::class.java)
                intent.putExtra("NOMBRE",binding.textUsuario.text.toString())
                startActivity(intent)
            }else if(binding.textUsuario.text.isEmpty()){
                Toast.makeText(this,getString(R.string.debes_introducir_un_nombre_de_usuario), Toast.LENGTH_SHORT).show()
            }else if(binding.textPassword.text.isEmpty()){
                Toast.makeText(this,
                    getString(R.string.debes_introducir_una_contrase_a), Toast.LENGTH_LONG).show()
            }else if(binding.textPassword.text.length<6){ Toast.makeText(this,
                getString(R.string.la_contrase_a_debe_ser_superior_a_7_caracteres), Toast.LENGTH_LONG).show()
            }else if(!validCredentials(users,binding.textUsuario.text.toString(),binding.textPassword.text.toString())){
                Toast.makeText(this,"El usuario no esta registrado",Toast.LENGTH_LONG).show()
            }
        }

        binding.txtVerCon.setOnClickListener{
            if (binding.txtVerCon.text == getString(R.string.ver_contrase_a)){
                binding.txtVerCon.text = getString(R.string.ocultar_contrase_a)
                binding.textPassword.inputType = 1
            }else{
                binding.txtVerCon.text = getString(R.string.ver_contrase_a)
                binding.textPassword.inputType = 65665
            }
        }
        binding.modRegistrar.setOnClickListener {
            startActivity(Intent(this,RegistroActivity::class.java))
        }

    }


    fun validarPassword(): Boolean{
        var valida = true
        if (binding.textPassword.text.isEmpty() || binding.textPassword.text.length < 7){
            valida = false
        }
        return valida
    }

    fun validCredentials(users: MutableList<Usuario>,username: String,password: String): Boolean{
        return users.any{it.username == username && it.password == password}
    }
}

