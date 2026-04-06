package com.example.projetointegradomemo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela04 extends AppCompatActivity {
    private TextView textoDoNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela04);

        textoDoNome = findViewById(R.id.textView5);
        Intent i = getIntent();
        if(i != null){
            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if(caixa != null){
                textoDoNome.setText(caixa.getString("nome"));
            }
        }
    }
}