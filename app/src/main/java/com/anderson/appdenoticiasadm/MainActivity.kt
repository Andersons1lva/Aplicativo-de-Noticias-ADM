package com.anderson.appdenoticiasadm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.anderson.appdenoticiasadm.databinding.ActivityMainBinding
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val db = FirebaseFirestore.getInstance()

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

            //validação dos campos, se estão preenchidos ou não.
            if (titulo.isEmpty() || noticia.isEmpty() || data.isEmpty() || autor.isEmpty()){
                Toast.makeText(this,"Preencha todos os campos.", Toast.LENGTH_SHORT).show()
            }else{
                salvarNoticia(titulo,noticia,data,autor)
            }

        }
    }
    // salvar as informação no banco de dados.
    private fun salvarNoticia(titulo: String, noticia: String, data: String, autor: String){
        // criação de chaves para cada campo.
        val mapNoticias = hashMapOf(
            "titulo" to titulo,
            "noticia" to noticia,
            "data" to data,
            "autor" to autor,
        )

        // interação junto ao banco de dados.
        db.collection("noticias").document("noticia")
            .set(mapNoticias).addOnCompleteListener { tarefa ->
                if (tarefa.isSuccessful){
                    Toast.makeText(this,"Notícia publicada com sucesso!", Toast.LENGTH_SHORT).show()
                    limparCampos()
                }
            }.addOnFailureListener {

            }
    }
    private fun limparCampos(){
        // reset nos campos
        binding.editTitleNoticia.setText("")
        binding.editNoticia.setText("")
        binding.editData.setText("")
        binding.editAutor.setText("")
    }
}