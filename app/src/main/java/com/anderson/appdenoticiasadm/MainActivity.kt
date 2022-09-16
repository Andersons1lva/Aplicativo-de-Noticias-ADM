package com.anderson.appdenoticiasadm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        // para ocultar a toolbar de ação
        supportActionBar!!.hide()
    }
}