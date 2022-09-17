package com.anderson.appdenoticiasadm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.anderson.appdenoticiasadm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // para ocultar a toolbar de ação
        supportActionBar!!.hide()

        //evento de click
        binding.btnPublica.setOnClickListener {
            val titulo = binding.editTitleNoticia.text.toString()
            val noticia = binding.editNoticia.text.toString()
            val data = binding.editData.text.toString()
            val autor = binding.editAutor.text.toString()

            if (titulo.isEmpty() || noticia.isEmpty() || data.isEmpty() || autor.isEmpty()){
                Toast.makeText(this,"Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}