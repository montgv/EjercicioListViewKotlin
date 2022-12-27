package com.example.ejerciciolistviewkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

//Declaramos la clase MiAdaptador que extiende de ArrayAdapter y declaramos los diferentes atributos que tiene esta clase
class MiAdaptador (private val ctx: Context, private val layoutTemplate: Int, private  val listaPersonas: List<Personas>)
    : ArrayAdapter<Any?>(ctx, layoutTemplate, listaPersonas) {

    //Implementamos el metodo getView que obtiene una vista que muestra los datos de la posicion actual del conjunto de datos
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val v = LayoutInflater.from(ctx).inflate(layoutTemplate, parent, false)

        //Obtiene la persona de la posicion actual
        val personaActual = listaPersonas[position]

        //Enlazamos los determinados componentes del adaptador con la vinculacion de datos
        val imageViewPersona = v.findViewById<View>(R.id.imageView) as ImageView
        val textViewNombre = v.findViewById<View>(R.id.textViewNombre) as TextView
        val textViewApellidos = v.findViewById<View>(R.id.textViewApellidos) as TextView
        val textViewCiclo = v.findViewById<View>(R.id.textViewCiclo) as TextView

        //Cambiamos el texto de los diferentes componentes por los obtenidos de la persona actual
        textViewNombre.text = personaActual.nombre
        textViewApellidos.text = personaActual.apellidos
        textViewCiclo.text = personaActual.ciclo

        //Si el dato de la persona actual es igual al introducido la cambia la imagen por una concreta
        //sino le cambia la imagen por otra
        if (personaActual.sexo == "Hombre") {
            imageViewPersona.setImageResource(R.drawable.boy_avatar_icon_148454)
        } else {
            imageViewPersona.setImageResource(R.drawable.girl_avatar_icon_148461)
        }
        //Devuelve la vista
        return v
    }
    }