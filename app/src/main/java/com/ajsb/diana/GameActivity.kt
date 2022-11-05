package com.ajsb.diana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajsb.diana.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityGameBinding

    /**
     * @param savedInstanceState: Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // bindeamos
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide() ;
    }

    /**
     * Bloqueamos el botón ATRÁS
     */
    override fun onBackPressed() {
        //super.onBackPressed()
    }
}