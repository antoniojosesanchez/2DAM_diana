/**
 * Antonio J. Sánchez
 * Programación Multimedia y de Dispositivos Móviles
 * Programación de Servicios y Procesos
 * curso 2022|23
 */
package com.ajsb.diana

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.content.Intent
import com.ajsb.diana.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // vinculación de vistas
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // eliminamos la APPBAR
        //supportActionBar?.hide()



        with(binding) {

            btnJugar.setOnClickListener {
                val i = Intent(this@MainActivity,GameActivity::class.java)
                startActivity(i)
            }

            btnInfo.setOnClickListener {

                Snackbar.make( it,R.string.etq_info, Snackbar.LENGTH_LONG)
                    .show()

                //Toast.makeText(this@MainActivity,"Mostramos Información",Toast.LENGTH_LONG)
                //     .show()
            }
        }
    }
}