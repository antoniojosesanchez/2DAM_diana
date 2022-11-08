package com.pmdm.juego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import java.io.Serializable
import com.google.android.material.snackbar.Snackbar
import com.pmdm.juego.databinding.ActivityMainBinding

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

                Snackbar.make( it,"Mostramos Información", Snackbar.LENGTH_LONG)
                        .show()

                //Toast.makeText(this@MainActivity,"Mostramos Información",Toast.LENGTH_LONG)
                //     .show()
            }
        }
    }
}