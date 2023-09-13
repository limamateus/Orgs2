package com.example.orgs2.ui.dialog

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import com.example.orgs2.databinding.DialogFrmImagemBinding
import com.example.orgs2.extensions.tentarCarregarImagem


class FrmDialogImagem(private val context: Context) {


    fun mostrarDialog(url : String? = null, quandoImagemCarregado:(imagem: String?)->Unit){

            DialogFrmImagemBinding.inflate(LayoutInflater.from(context)).apply {

                url?.let {
                    fmrDialogImagem.tentarCarregarImagem(it)
                    fmrDialogUrl.setText(it)
                }


                fmrDialogCarregar.setOnClickListener {
                    val xUrl = fmrDialogUrl.text.toString()
                    fmrDialogImagem.tentarCarregarImagem(xUrl)
                }

                AlertDialog.Builder(context)
                    .setView(root)
                    .setPositiveButton("Salvar",DialogInterface.OnClickListener { _,_ ->
                        val url = fmrDialogUrl.text.toString()

                        quandoImagemCarregado(url)
                    })
                    .setNegativeButton("Cancelar",DialogInterface.OnClickListener { _,_ ->

                    }).show()
            }
    }
}