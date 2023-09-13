package com.example.orgs2.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs2.R
import com.example.orgs2.dao.ProdutoDAO
import com.example.orgs2.databinding.ListaProdutosBinding

import com.example.orgs2.ui.recyclerview.adpter.ListaDeProdutoAdpter
import com.google.android.material.floatingactionbutton.FloatingActionButton



class ListaDeProdutosActivity: AppCompatActivity() {
    private  val dao = ProdutoDAO()
    private  val adapter = ListaDeProdutoAdpter(this, produto = dao.buscarProdutos())

    private  val binding by lazy {
        ListaProdutosBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        CarregarView()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualizar(dao.buscarProdutos())
        ConfigureFab()
    }

    fun ConfigureFab(){
        val btnAdd = binding.listaDeProdutoReclerviewFloatingActionButton

        btnAdd.setOnClickListener {
            val intent  = Intent(this, FrmDeProdutosActivity::class.java)
            startActivity(intent)
        }
    }
    fun CarregarView(){
        val recyclerView = findViewById<RecyclerView>(R.id.lista_de_produtos_reclerview)
        val dao = ProdutoDAO()
        Log.i("MainActivity", "onCreate :${dao.buscarProdutos()} ")
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this);
    }
}