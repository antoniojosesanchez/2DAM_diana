package com.ajsb.diana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajsb.diana.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    /**
     * @param savedInstanceState: Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // bindeamos
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ocultamos la appbar
        supportActionBar?.hide()

        // reaccionar a la pulsación de los botones
        with(binding)
        {
            btnJugar.setOnClickListener {
                val intencion = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intencion)
            }

            btnInfo.setOnClickListener {
                Snackbar.make(it,"Este juego ha sido desarrollado por Javier Jiménez Jaén para la asignatura de Programación Multimedia y de Dispositivos Móviles", Snackbar.LENGTH_LONG)
                        .show()
            }
        }
    }
}