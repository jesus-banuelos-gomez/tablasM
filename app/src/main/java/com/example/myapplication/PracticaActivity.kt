package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class PracticaActivity : AppCompatActivity() {
    lateinit var tvFactor1:TextView
    lateinit var tvFactor2:TextView
    lateinit var etRespuesta:EditText
    lateinit var btnVerificar:Button

    var factor1:Int = 0
    var factor2:Int = 0
    var producto:Int = 0

    var respuestaCorrecta = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practica)

        initUI()

        btnVerificar.setOnClickListener{
            var strRespuesta = etRespuesta.text.toString()
            if (strRespuesta.equals("")){
                Toast.makeText(this,"Dejaste el campo vacio",Toast.LENGTH_LONG).show()
            }else{
                respuestaCorrecta = producto == strRespuesta.toInt()
                val mostrarResultados =  Intent(this,ResultadoActivity::class.java)
                mostrarResultados.putExtra("respuesta",respuestaCorrecta)
                startActivity(mostrarResultados)

                generaMultiplicacion()
            }

        }
    }
    fun initUI(){

        tvFactor1 = findViewById(R.id.tvFactor1)
        tvFactor2 = findViewById(R.id.tvFactor2)
        etRespuesta = findViewById(R.id.etRespuesta)
        btnVerificar = findViewById(R.id.btnVerificar)
        generaMultiplicacion()



    }

    fun generaMultiplicacion(){
        factor1 = Random.nextInt(0,10)
        factor2 = Random.nextInt(0,10)
        producto = factor1 * factor2
        tvFactor1.text = "$factor1"
        tvFactor2.text = "$factor2"
        etRespuesta.text.clear()

    }
}