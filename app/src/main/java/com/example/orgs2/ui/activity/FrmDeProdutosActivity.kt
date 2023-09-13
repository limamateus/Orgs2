package com.example.orgs2.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.orgs2.R
import com.example.orgs2.dao.ProdutoDAO
import com.example.orgs2.databinding.FrmDeProdutoBinding
import com.example.orgs2.extensions.tentarCarregarImagem
import com.example.orgs2.model.Produto
import com.example.orgs2.ui.dialog.FrmDialogImagem
import java.math.BigDecimal

class FrmDeProdutosActivity: AppCompatActivity(R.layout.frm_de_produto) {
    private val dao = ProdutoDAO()
    private var url: String? = null

    private val binding by lazy {
        FrmDeProdutoBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // ---------- Abrir o Dialog -----------------

        binding.activityFrmProdutoImagem.setOnClickListener {
            FrmDialogImagem(this)
                .mostrarDialog(url) { imagem->
                    url = imagem
                    binding.activityFrmProdutoImagem.tentarCarregarImagem(url)
                }
        }

        val btnSalvar = binding.frmProdutoBtnSalvarActivity

        btnSalvar.setOnClickListener {
            val novoProduto = PegarDados()
            Log.i("FmrDeProdutos", "onCreate :${novoProduto} ")
            dao.add(novoProduto)
            finish()
        }


    }

    fun PegarDados():Produto {
        val campoNome = binding.fmrProdutoNome
        val campoDescrica = binding.fmrProdutoDescricao
        val campoMedida = binding.fmrProdutoCategoria
        val campoValor = binding.fmrProdutoValor

        val nome = campoNome.text.toString()
        val descrica = campoDescrica.text.toString()
        val medida = campoMedida.text.toString()
        val valor = campoValor.text.toString()

        val valorFinal = if(valor.isBlank()){
            BigDecimal.ZERO
        }else{
            BigDecimal(valor)
        }


        return Produto(nome,descrica,medida,valorFinal)

    }


    }

