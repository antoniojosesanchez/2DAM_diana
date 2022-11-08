package com.pmdm.juego

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import com.pmdm.juego.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityGameBinding

    // variables de juego
    private var puntuacion: Int = 0
    private var tiradas: Int = 5
    private var numero: Int = 0

    /**
     * @param savedInstanceState: Bundle?
     */
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.etqPuntos.text = resources.getString(R.string.etq_puntos) + puntuacion
        //binding.etqPuntos.text = "Puntuación: ${puntuacion}"

        // elegimos un valor al azar
        numero = Random.nextInt(0, 100)

        // actualizamos el panel
        panel()

        // reaccionamos a la pulsación de botón de disparo
        // - Decrementar el número de dardos
        // - Comprobar si he acertado:
        //      - SI - cambiamos número y rellenamos dardos
        //      - NO - comprobar si quedan dardos
        //           - SI - continuar
        //           - NO - finalizar juego
        binding.btnDispara.setOnClickListener {

            // recuperamos valor del slider
            val valor = binding.barBusqueda.value.toInt()

            // decrementamos el número de dardos
            tiradas--

            // comprobamos si hemos acertado
            if (valor == numero)  {

                val madb = MaterialAlertDialogBuilder(this@GameActivity)
                            .setTitle(R.string.app_name)
                            .setMessage(R.string.etq_exito)
                            .setPositiveButton(R.string.btn_si) { i, w ->

                                // reiniciamos el número
                                numero = Random.nextInt(0, 100)

                                // reseteamos las tiradas
                                tiradas = 5

                                // incrementamos los puntos
                                puntuacion += 1000
                            }
                            .setNegativeButton(R.string.btn_no) { i, w ->
                               finish()
                                return@setNegativeButton
                            }
                            .create()

                madb.show()



            } else {

                Snackbar.make(it,resources.getString(R.string.etq_fallo, valor), Snackbar.LENGTH_LONG)
                        .show()

                if (tiradas == 0) Log.i("XXXX", "El juego ha terminado")
            }

            // actualizamos el panel
            panel()

        }

    }

    /**
     * Actualiza el marcador de puntos y de tiradas
     */
    fun panel() {
        with(binding) {
            etqTexto.text = resources.getString(R.string.etq_mensaje, numero)
            etqPuntos.text = resources.getString(R.string.etq_puntos, puntuacion)
            etqTiradas.text = resources.getQuantityString(R.plurals.etq_tiradas, tiradas, tiradas)
        }
    }

    /**
     * Bloqueamos el botón de vuelta atrás
     */
    override fun onBackPressed() {
        //super.onBackPressed()
    }

}