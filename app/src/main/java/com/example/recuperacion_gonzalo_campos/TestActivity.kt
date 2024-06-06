package com.example.recuperacion_gonzalo_campos

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

        binding.radioGroup1.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.r1 -> Toast.makeText(this, "Has acertado", Toast.LENGTH_SHORT).show()
                R.id.r2 -> Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                R.id.r3 -> Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
            }
        }

        binding.RadioGroup2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.r4 -> Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                R.id.r5 -> Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                R.id.r6 -> Toast.makeText(this, "Has acertado", Toast.LENGTH_SHORT).show()
            }
        }

        binding.RadioGroup3.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.r7 -> Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                R.id.r8 -> Toast.makeText(this, "Has fallado", Toast.LENGTH_SHORT).show()
                R.id.r9 -> {Toast.makeText(this, "Has acertado", Toast.LENGTH_SHORT).show()}
            }
        }
    }
}