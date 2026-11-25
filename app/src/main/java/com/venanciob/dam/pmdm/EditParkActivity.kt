package com.venanciob.dam.pmdm

import android.os.Bundle
import android.widget.Toast
import com.venanciob.dam.pmdm.databinding.ActivityEditParkBinding

class EditParkActivity : BaseActivity() {

    private lateinit var binding: ActivityEditParkBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditParkBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pantallaActual = PANTALLA_FORMULARIO
        configurarBarra(binding.toolbar, mostrarBotonArriba = true)

        binding.btnGuardar.setOnClickListener {
            Toast.makeText(
                this,
                R.string.msg_guardado_simulado,
                Toast.LENGTH_SHORT,
            ).show()
        }
    }

    override fun onResume() {
        super.onResume()
        pantallaActual = PANTALLA_FORMULARIO
        invalidateOptionsMenu()
    }
}