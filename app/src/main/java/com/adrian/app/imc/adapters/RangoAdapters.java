package com.adrian.app.imc.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.adrian.app.imc.R;

public class RangoAdapters extends BaseAdapter {

    private Context context;
    private String[] rangos = {
        "IMC < 16", "IMC < 18.5",
        "IMC < 25", "IMC < 30",
        "IMC > 30"
    };
    private String[] definiciones = {
            "DESNUTRIDO", "BAJO PESO",
            "NORMAL", "SOBREPESO",
            "OBESO"
    };

    private int[] imagenesId = {R.mipmap.ic_imc_desnutrido, R.mipmap.ic_imc_bajopeso,
            R.mipmap.ic_imc_normal,R.mipmap.ic_imc_sobrepeso,R.mipmap.ic_imc_obeso
    };

    public RangoAdapters(Context context){
        this.context = context;
    }



    @Override
    public int getCount() {
        return definiciones.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            Activity actividad = (Activity) context;
            LayoutInflater layoutInflater = actividad.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.fila_completa, parent, false);
        }else {
            view = convertView;
        }

        TextView texto1 = (TextView) view.findViewById(R.id.texto1);
        TextView texto2 = (TextView) view.findViewById(R.id.texto2);
        ImageView imageView = (ImageView) view.findViewById(R.id.imagen);

        texto1.setText(definiciones[position]);
        texto2.setText(rangos[position]);
        imageView.setImageResource(imagenesId[position]);

        return view;
    }
}
