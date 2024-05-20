package com.example.adptest.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.adptest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentCont.id, MainFragment())
            .commit()

    }
}