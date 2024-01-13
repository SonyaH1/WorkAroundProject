package com.example.workaroundproject.somestuff

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workaroundproject.databinding.SecondActivityBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: SecondActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val name = intent.getStringExtra(MainActivity.EXTRA_NAME)
        binding.name.text = name
    }

}