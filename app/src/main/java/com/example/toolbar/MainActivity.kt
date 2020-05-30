package com.example.toolbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.SearchView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    var toolBar :Toolbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        toolBar = findViewById(R.id.toolbar)
        toolBar?.setTitle(R.string.app_name)
        //para decirle que esta es la toolbar oficial
        setSupportActionBar(toolBar)

        val buttonIr = findViewById<Button>(R.id.ButtonIr)
        buttonIr.setOnClickListener{
            val intent = Intent(this,SegundaActividad::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)

        val itemBusqueda = menu?.findItem(R.id.busqueda)
        val vistaBusqueda = itemBusqueda?.actionView as SearchView

        vistaBusqueda.queryHint = "write your name  ..."
        vistaBusqueda.setOnQueryTextFocusChangeListener { v, hasFocus ->
            Log.d ("Listener focus",hasFocus.toString())
        }
        vistaBusqueda.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("OnqueryTextChange",newText)
                return true
            }
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("onqueryTextSubmit",query)
                return true
            }



        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.Bfab ->{
                val buttonIr = findViewById<Button>(R.id.ButtonIr)
                buttonIr.setOnClickListener{
                    val intent = Intent(this,SegundaActividad::class.java)
                    startActivity(intent)
                }

                Toast.makeText(this,"Elemento añadido como favorito",Toast.LENGTH_LONG).show()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }
}