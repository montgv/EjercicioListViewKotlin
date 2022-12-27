package com.example.ejerciciolistviewkotlin

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import com.example.ejerciciolistviewkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //Creamos el binding que nos sirve para la vinculacion de vista
    private lateinit var binding: ActivityMainBinding
    //Creamos una lista de la clase Personas
    private var miLista: List<Personas>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        //Estas lineas hace que se nos vincule las vistas con el activity
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //EStamos asignandole a miLista que sea un arrayList y le estamos añadiendo diferentes
        //objetos de tipo Personas
        miLista = ArrayList()
        (miLista as ArrayList<Personas>).add(Personas("Miguel", "López Sánchez", "Hombre", "ASIR"))
        (miLista as ArrayList<Personas>).add(Personas("Juan", "Pérez Pérez", "Hombre", "DAW"))
        (miLista as ArrayList<Personas>).add(Personas("Maria", "Martínez Fernández", "Mujer", "DAM"))
        (miLista as ArrayList<Personas>).add(Personas("Antonio", "González García", "Hombre", "DAM"))
        (miLista as ArrayList<Personas>).add(Personas("Ana", "Díaz Torres", "Mujer", "ASIR"))

        //Estamos creando un adaptador que lo que hace es devolver una vista para cada objeto
        //de una coleccion de objetos de datos, es decir, para los diferentes objetos que tiene
        //el arrayList, y despues, asociamos al binding a la listView para que use ese adaptador
        val miAdaptador = MiAdaptador(this, R.layout.opciones_item, miLista as ArrayList<Personas>)
        binding.listView.adapter = miAdaptador

        //Definimos un escuchador para cuando pulsemos en un item del listView haga lo que se le indica
        binding.listView.onItemClickListener = OnItemClickListener {
                adapterView, view, i, l -> pasarPantalla(i)
        }
    }

    //Definimos la funcion que crea un intent para que se vaya a la ActivityModulos, y que realice el
    //envio de informacion de una actividad a otra, que realice el salta a la nueva actividad y que
    //cuando la actividad haya terminado que se cierre
    private fun pasarPantalla(i: Int) {
        val intent = Intent(this, ActivityModulos::class.java)
        val ciclo = miLista?.get(i)?.ciclo
        intent.putExtra("ciclo", ciclo)
        startActivity(intent)
        finish()
    }
}