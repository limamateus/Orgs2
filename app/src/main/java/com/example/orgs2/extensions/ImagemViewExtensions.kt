package com.example.orgs2.extensions

import android.widget.ImageView
import  coil.load
import com.example.orgs2.R

fun ImageView.tentarCarregarImagem(url:String? = null) {

    if(url!= null || url != null){
        load(url){
            fallback(R.drawable.erro)
            error(R.drawable.erro)

        }
    }



}