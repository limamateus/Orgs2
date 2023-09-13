package com.example.orgs2.dao

import com.example.orgs2.model.Produto

class ProdutoDAO {

    fun add(produto: Produto){
        produtos.add(produto)
    }

   fun buscarProdutos(): List<Produto> {
       return produtos.toList()
   }

    companion object{
        private  val produtos = mutableSetOf<Produto>()
    }
}