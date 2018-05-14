package com.adrian.app.imc;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.adrian.app.imc.Listener.MostrarListaListener;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText altura = findViewById(R.id.altura);
        final EditText peso = findViewById(R.id.peso);
        final Button calcula = findViewById(R.id.calcula);
        Button mostrarLista = findViewById(R.id.mostrar_lista);
        final TextView resultado = findViewById(R.id.resultado);
        final Button reiniciar = findViewById(R.id.reiniciar);
        final ImageView resultadoImagen = findViewById(R.id.resultado_imagen);
        final TextView resultadoTexto = findViewById(R.id.resultado_texto);

        calcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String alturaDada = altura.getText().toString();
                String pesoDado = peso.getText().toString();
                if(!alturaDada.isEmpty() && !pesoDado.isEmpty()){
                    try {
                        double alturaNum = Double.parseDouble(alturaDada);
                        double pesoNum = Double.parseDouble(pesoDado);
                        alturaNum /= 100;

                        double imc = pesoNum / (alturaNum * alturaNum);
                        int imc2 = (int)imc;

                        resultado.setText(String.valueOf("Tu IMC es de " + imc2));

                        if (imc < 16){
                            resultadoImagen.setBackgroundResource(R.mipmap.ic_imc_desnutrido);
                            resultadoTexto.setText("Estas desnutrido tio, deja de comer piedras!!!");
                        }else if (imc > 16 && imc < 18.5){
                            resultadoImagen.setBackgroundResource(R.mipmap.ic_imc_bajopeso);
                            resultadoTexto.setText("Estas bajo peso, ay que comer mas!");
                        }else if (imc > 18.5 && imc < 25){
                            resultadoImagen.setBackgroundResource(R.mipmap.ic_imc_normal);
                            resultadoTexto.setText("Estas de puta madre, sigue asi!");
                        }else if (imc > 25 && imc < 30){
                            resultadoImagen.setBackgroundResource(R.mipmap.ic_imc_sobrepeso);
                            resultadoTexto.setText("Te estas pasando con los postres!");
                        }else{
                            resultadoImagen.setBackgroundResource(R.mipmap.ic_imc_obeso);
                            resultadoTexto.setText("Te has lucido chaval!!!");
                        }

                        /**
                         * Un metodo para ocultar el teclado una vez presionamos el boton calcular IMC
                         */
                        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputMethodManager.hideSoftInputFromWindow(calcula.getWindowToken(), 0);

                    }catch (Throwable ex){
                        Toast.makeText(MainActivity.this, "Los datos introducidos no son correctos", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "No has introducido los dos campos", Toast.LENGTH_LONG).show();
                }
            }
        });

        MostrarListaListener mostrarListaListener = new MostrarListaListener(this);
        mostrarLista.setOnClickListener(mostrarListaListener);

        /**
         * Metodo para resetear todos los campos
         */
        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altura.setText(null);
                peso.setText(null);
                resultado.setText(null);
                resultadoImagen.setBackgroundResource(0);
                resultadoTexto.setText(null);
            }
        });


    }
}

//            btn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//
//        String valorAltura = altura.getText().toString();
//        String valorPeso = peso.getText().toString();
//        int alt = Integer.parseInt(valorAltura);
//        int pes = Integer.parseInt(valorPeso);
//
//        int imc = pes/alt*alt;
//
//        String res = String.valueOf(imc);
//        masa.setText(res);
//
//        }
//        });
