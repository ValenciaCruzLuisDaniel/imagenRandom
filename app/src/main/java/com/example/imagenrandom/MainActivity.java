package com.example.imagenrandom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    /*declaramos las variables para el array que traera
    las imagenes, las que permitira interactuar con el
    ImagenView y del Boton
    */

    private TypedArray icons;
    private ImageView visor;
    private Button btnGenerate;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        obtenemos los archivos que declaramos en el documento array
//        y lo agregamos a la variable privada icons
        icons=getResources().obtainTypedArray(R.array.icons);

        /*declaramos el visor para que encuentre el que ya
                esta hecho en el activity_main*/
        visor=(ImageView)findViewById(R.id.visor);

        /*los mismo se hace con el botos lo declaramos para que lo encuentre
         del activity_main     */
        btnGenerate=(Button)findViewById(R.id.cambio);

        //agregamos una imagen al ImageView para que la app
        //ya tenga algo que mostrar
        visor.setBackgroundResource(icons.getResourceId(0,1));

    /*
    creamos una metodo que traiga la
    metodo cambiar imagen al pulsar el boton
    */
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarImagen();
            }
        });


    }

    private void cambiarImagen(){
    /*mandamos a trar la clase random y el mismo constructor
     y la variable sera numero */

        Random numero=new Random();
    //hacemos que este numero random no pase de 10 que es el numero maximo de las imagenes
        int randomNumero=numero.nextInt(10);

        /*ya por ultimo hacemos que cada que se genere un numero random se agrege al
        ImageView con la condicion que sea 1 o mayor que 1*/
        visor.setBackgroundResource(icons.getResourceId(randomNumero,1));



    }
}