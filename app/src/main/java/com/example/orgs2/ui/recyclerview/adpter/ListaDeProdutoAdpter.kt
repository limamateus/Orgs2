package com.example.orgs2.ui.recyclerview.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs2.R
import com.example.orgs2.model.Produto

class ListaDeProdutoAdpter(
    private val context: Context,
    produto: List<Produto>
) : RecyclerView.Adapter<ListaDeProdutoAdpter.ViewHolder>(){
    val produtos = produto.toMutableList()

    class ViewHolder(view:View) : RecyclerView.ViewHolder(view) {
        fun vincular(produto: Produto){
            val nome = itemView.findViewById<TextView>(R.id.produto_item_nome)
            val descricao = itemView.findViewById<TextView>(R.id.produto_item_descricao)
            val medida = itemView.findViewById<TextView>(R.id.produto_item_categoria)
            val valor = itemView.findViewById<TextView>(R.id.produto_item_preco)

            nome.text = produto.nome
            descricao.text = produto.descricao
            medida.text = produto.medida
            valor.text = produto.valorVenda.toPlainString()


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater = LayoutInflater.from(context)
       val view = inflater.inflate(R.layout.produto_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val produto = produtos[position]
        holder.vincular(produto)
    }

    override fun getItemCount(): Int = produtos.size


    fun atualizar(produtos:List<Produto>){
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }
}