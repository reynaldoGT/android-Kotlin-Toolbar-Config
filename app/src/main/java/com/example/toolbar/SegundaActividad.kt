package com.example.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar

class SegundaActividad : AppCompatActivity() {
    var toolBar : Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda_actividad)

        toolBar = findViewById(R.id.toolbar)
        toolBar?.setTitle(R.string.app_name)
        //para decirle que esta es la toolbar oficial
        setSupportActionBar(toolBar)

        // codigo para habilitar el boton hacia atras

        val actionbar = supportActionBar
        actionbar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_segunda_pantalla,menu)

        return super.onCreateOptionsMenu(menu)
    }
}