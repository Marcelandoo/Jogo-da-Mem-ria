package com.example.projetointegradomemo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class Tela03 extends AppCompatActivity implements View.OnClickListener, Runnable {
    private TextView textoDoNome, textoDoContador;
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8;
    private ImageView imgTocado1, imgTocado2;
    private int imagemImgTocado1, imagemImgTocado2, contaToque;
    private Handler handler;
    private Button fim, renicia;
    private int contador;

    private ArrayList<Integer> lista;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela03);
        fim = findViewById(R.id.button3);
        fim.setOnClickListener(this);

        contador = 1;

        textoDoNome = findViewById(R.id.textView3);
        Intent i = getIntent();
        if(i != null){
            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if(caixa != null){
                textoDoNome.setText(caixa.getString("nome"));
            }
        }
        img1 = findViewById(R.id.imageView2);
        img2 = findViewById(R.id.imageView3);
        img3 = findViewById(R.id.imageView4);
        img4 = findViewById(R.id.imageView5);
        img5 = findViewById(R.id.imageView6);
        img6 = findViewById(R.id.imageView7);
        img7 = findViewById(R.id.imageView8);
        img8 = findViewById(R.id.imageView9);

        lista = new ArrayList<Integer>();
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name);
        lista.add(R.drawable.ic_action_name);
        lista.add(R.drawable.ic_action_name_2);
        lista.add(R.drawable.ic_action_name_2);

        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);

        handler = new Handler();

        imgTocado1 = new ImageView(this);
        imgTocado2 = new ImageView(this);

        renicia = findViewById(R.id.button4);
        renicia.setOnClickListener(this);
        inicio();
    }

    public void inicio (){
        Collections.shuffle(lista);
        img1.setImageResource(lista.get(0));
        img2.setImageResource(lista.get(1));
        img3.setImageResource(lista.get(2));
        img4.setImageResource(lista.get(3));
        img5.setImageResource(lista.get(4));
        img6.setImageResource(lista.get(5));
        img7.setImageResource(lista.get(6));
        img8.setImageResource(lista.get(7));

        img1.setEnabled(true);
        img2.setEnabled(true);
        img3.setEnabled(true);
        img4.setEnabled(true);
        img5.setEnabled(true);
        img6.setEnabled(true);
        img7.setEnabled(true);
        img8.setEnabled(true);

        img1.setBackgroundColor(Color.parseColor("#202D57"));
        img2.setBackgroundColor(Color.parseColor("#202D57"));
        img3.setBackgroundColor(Color.parseColor("#202D57"));
        img4.setBackgroundColor(Color.parseColor("#202D57"));
        img5.setBackgroundColor(Color.parseColor("#202D57"));
        img6.setBackgroundColor(Color.parseColor("#202D57"));
        img7.setBackgroundColor(Color.parseColor("#202D57"));
        img8.setBackgroundColor(Color.parseColor("#202D57"));

        handler.postDelayed(this, 3000);
        contaToque = 0;
    }

    public void compara(int imagem1, int imagem2) {
        contaToque = 0;
        if (imagem1 == imagem2) {
            imgTocado1.setBackgroundColor(Color.GREEN);
            imgTocado2.setBackgroundColor(Color.GREEN);
            imgTocado1.setEnabled(false);
            imgTocado2.setEnabled(false);
            //deu match
        } else {
            //deu errado
            imgTocado1.setBackgroundColor(Color.RED);
            imgTocado2.setBackgroundColor(Color.RED);
            Handler h1 = new Handler();
            h1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgTocado1.setBackgroundColor(Color.parseColor("#202D57"));
                    imgTocado2.setBackgroundColor(Color.parseColor("#202D57"));
                    imgTocado1.setImageResource(R.drawable.ic_action_name_6);
                    imgTocado2.setImageResource(R.drawable.ic_action_name_6);
                }
            }, 2000);
        }
    }

    @Override
    public void onClick(View view) {
        contaToque++;
        if(view == img1){
            img1.setImageResource(lista.get(0));
            if(contaToque == 1)
            {
               imgTocado1 = img1;
               imagemImgTocado1 = lista.get(0);
            }else {
                imgTocado2 = img1;
                imagemImgTocado2 = lista.get(0);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img2){
            img2.setImageResource(lista.get(1));
            if(contaToque == 1)
            {
                imgTocado1 = img2;
                imagemImgTocado1 = lista.get(1);
            }else {
                imgTocado2 = img2;
                imagemImgTocado2 = lista.get(1);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img3){
            img3.setImageResource(lista.get(2));
            if(contaToque == 1)
            {
                imgTocado1 = img3;
                imagemImgTocado1 = lista.get(2);
            }else {
                imgTocado2 = img3;
                imagemImgTocado2 = lista.get(2);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img4){
            img4.setImageResource(lista.get(3));
            if(contaToque == 1)
            {
                imgTocado1 = img4;
                imagemImgTocado1 = lista.get(3);
            }else {
                imgTocado2 = img4;
                imagemImgTocado2 = lista.get(3);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img5){
            img5.setImageResource(lista.get(4));
            if(contaToque == 1)
            {
                imgTocado1 = img5;
                imagemImgTocado1 = lista.get(4);
            }else {
                imgTocado2 = img5;
                imagemImgTocado2 = lista.get(4);
                compara(imagemImgTocado1,imagemImgTocado2);

            }
        }
        if(view == img6){
            img6.setImageResource(lista.get(5));
            if(contaToque == 1)
            {
                imgTocado1 = img6;
                imagemImgTocado1 = lista.get(5);
            }else {
                imgTocado2 = img6;
                imagemImgTocado2 = lista.get(5);
                compara(imagemImgTocado1,imagemImgTocado2);
            }
        }
        if(view == img7){
            img7.setImageResource(lista.get(6));
            if(contaToque == 1)
            {
                imgTocado1 = img7;
                imagemImgTocado1 = lista.get(6);
            }else {
                imgTocado2 = img7;
                imagemImgTocado2 = lista.get(6);
                compara(imagemImgTocado1,imagemImgTocado2);

            }
        }
        if(view == img8){
            img8.setImageResource(lista.get(7));
            if(contaToque == 1)
            {
                imgTocado1 = img8;
                imagemImgTocado1 = lista.get(7);
            }else {
                imgTocado2 = img8;
                imagemImgTocado2 = lista.get(7);
                compara(imagemImgTocado1,imagemImgTocado2);
            }

        }
        if(view == fim){
            Intent i = new Intent(this, tela04.class);
            Bundle caixa = new Bundle();
            caixa.putString("nome", textoDoNome.getText().toString());
            caixa.putInt("conte", contador);
            i.putExtras(caixa);
            startActivity(i);
        }

        if(view == renicia){
            contador++;
            inicio();
        }
    }

    @Override
    public void run() {
        img1.setImageResource(R.drawable.ic_action_name_6);
        img2.setImageResource(R.drawable.ic_action_name_6);
        img3.setImageResource(R.drawable.ic_action_name_6);
        img4.setImageResource(R.drawable.ic_action_name_6);
        img5.setImageResource(R.drawable.ic_action_name_6);
        img6.setImageResource(R.drawable.ic_action_name_6);
        img7.setImageResource(R.drawable.ic_action_name_6);
        img8.setImageResource(R.drawable.ic_action_name_6);
    }
}