package com.example.recuperacion_gonzalo_campos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recuperacion_gonzalo_campos.databinding.ActivityListadoBinding
import com.example.recuperacion_gonzalo_campos.databinding.ActivityRegistroBinding
import com.example.recuperacion_gonzalo_campos.databinding.ActivitySecondBinding

class ListadoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListadoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var url = "";
        val intent = Intent(Intent.ACTION_VIEW)

        binding.b1.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.p2)
            binding.txtURL.text = getString(R.string.mas_info);
            url = "https://es.wikipedia.org/wiki/Betta_splendens"
        }
        binding.b2.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.p1)
            binding.txtURL.text = getString(R.string.mas_info);
            url = "https://es.wikipedia.org/wiki/Periophthalmus"
        }
        binding.b3.setOnClickListener{
            binding.imageView.setImageResource(R.drawable.p3)
            binding.txtURL.text = getString(R.string.mas_info);
            url = "https://es.wikipedia.org/wiki/Delphinidae"
        }

         binding.txtURL.setOnClickListener {
            intent.data = Uri.parse(url)
            startActivity(intent)
        }


    }
}