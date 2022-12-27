package com.example.ejerciciolistviewkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciolistviewkotlin.databinding.ActivityModulosBinding

@Suppress("DEPRECATION")
class ActivityModulos : AppCompatActivity() {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: ActivityModulosBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        //Estas lineas hace que se nos vincule las vistas con el activity
        super.onCreate(savedInstanceState)
        binding = ActivityModulosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Creamos una variable inmutable en el que recogemos los datos que hemos mandado anteriormente,
        //capturando el Intent con el método extras
        val datos = intent.extras
        //Creación de variable inmutable que guarda el dato anterior con el método getString y
        //pasándole el nombre del dato, donde la variable datos le indicamos que puede ser nula ?
        val ciclo = datos?.getString("ciclo")

        //Comparamos si es igual el dato extraido con lo indicado y si es asi que le ponga a la pantalla
        //un color determinado, que le ponga una imagen determinada, que escriba un texto determinado
        //y que el boton realice una accion cuando se le pulsa, la funcion volver
        if (ciclo == "ASIR") {
            binding.pantalla.setBackgroundColor(resources.getColor(R.color.asir))
            binding.imageViewCiclos.setImageResource(R.drawable.asir_icon)
            binding.textViewCiclos.text = "Estás en el ciclo ASIR"
            binding.btCiclos.setOnClickListener{
                volver()
            }
        } else if (ciclo == "DAW") {
            binding.pantalla.setBackgroundColor(resources.getColor(R.color.daw))
            binding.imageViewCiclos.setImageResource(R.drawable.daw_icon)
            binding.textViewCiclos.text = "Estás en el ciclo DAW"
            binding.btCiclos.setOnClickListener{
                volver()
            }
        } else if (ciclo == "DAM") {
            binding.pantalla.setBackgroundColor(resources.getColor(R.color.dam))
            binding.imageViewCiclos.setImageResource(R.drawable.dam_icon)
            binding.textViewCiclos.text = "Estás en el ciclo DAM"
            binding.btCiclos.setOnClickListener {
                volver()
            }
        }
    }

    //Definimos la funcion que crea un intent para que se vaya al MainActivity, que realice el salto
    //a la nueva actividad y que cuando la actividad haya terminado que se cierre
    private fun volver() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}