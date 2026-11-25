package com.venanciob.dam.pmdm

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import kotlin.jvm.java

open class BaseActivity: AppCompatActivity() {
    companion object {
        const val PANTALLA_INICIO = 0
        const val PANTALLA_FORMULARIO = 1
        var pantallaActual: Int = PANTALLA_INICIO
    }
    protected fun configurarBarra(toolbar: MaterialToolbar, mostrarBotonArriba: Boolean) {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(mostrarBotonArriba)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        menu.findItem(R.id.item_inicio)?.isVisible = (pantallaActual != PANTALLA_INICIO)
        menu.findItem(R.id.item_anadir_parque)?.isVisible = (pantallaActual != PANTALLA_FORMULARIO)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                irAInicio()
                true
            }
            R.id.item_inicio -> {
                irAInicio()
                true
            }
            R.id.item_anadir_parque -> {
                if (pantallaActual != PANTALLA_FORMULARIO) {
                    val intent = Intent(this, EditParkActivity::class.java).apply {
                        addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
                    }
                    startActivity(intent)
                }
                true
            }
            R.id.item_acerca_de -> {
                mostrarDialogoAcercaDe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun irAInicio(){
        if (pantallaActual != PANTALLA_INICIO){
            val intent = Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            }
            startActivity(intent)
        }
    }
    private fun mostrarDialogoAcercaDe(){
        AlertDialog.Builder(this)
            .setTitle(R.string.acerca_de_titulo)
            .setMessage(R.string.acerca_de_mensaje)
            .setPositiveButton(R.string.aceptar, null)
            .show()
    }
}























