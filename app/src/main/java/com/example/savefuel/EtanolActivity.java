package com.example.savefuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;

public class EtanolActivity extends AppCompatActivity {

    private ImageView maisInformacoes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etanol);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        maisInformacoes = findViewById(R.id.maisInformacoes);
        AnimationClass animationClass = new AnimationClass();

        maisInformacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(EtanolActivity.this, "O Etanol vale a pena até 60% do preço da gasolina", Toast.LENGTH_SHORT).show();
            }
        });
    }
}