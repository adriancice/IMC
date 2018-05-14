package com.adrian.app.imc.Listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.adrian.app.imc.ListaActivity;

public class MostrarListaListener implements View.OnClickListener {

    private Context context;

    public MostrarListaListener(Context context){
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, ListaActivity.class);
        context.startActivity(intent);


    }
}
