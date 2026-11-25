package com.venanciob.dam.pmdm

import android.os.Bundle
import com.venanciob.dam.pmdm.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pantallaActual = PANTALLA_INICIO
        configurarBarra(binding.toolbar, mostrarBotonArriba = false)
    }

    override fun onResume() {
        super.onResume()
        pantallaActual = PANTALLA_INICIO
        invalidateOptionsMenu()
    }

}
