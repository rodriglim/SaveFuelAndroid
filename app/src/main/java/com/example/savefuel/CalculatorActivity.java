package com.example.savefuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Objects;

public class CalculatorActivity extends AppCompatActivity {

    private ImageButton btnCalcular, btnLimpar;
    private EditText inputGasolina, inputEtanol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);
        inputGasolina = findViewById(R.id.inputGasolina);
        inputEtanol = findViewById(R.id.inputEtanol);

        AnimationClass animationClass = new AnimationClass();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationClass.btnAnimationImageButton(btnCalcular);
                if((inputGasolina.getText().toString().isEmpty()) || (inputEtanol.getText().toString().isEmpty())){
                    Toast.makeText(CalculatorActivity.this, "Campo(s) Vazio(s)", Toast.LENGTH_SHORT).show();
                }else{

                    try {
                        char valorGasolina = inputGasolina.getText().charAt(0);
                        char valorEtanol = inputEtanol.getText().charAt(0);
                        if ((valorGasolina == '.') || (valorEtanol == '.')){
                            Toast.makeText(CalculatorActivity.this, "Valor Inválido", Toast.LENGTH_SHORT).show();
                        }else {
                            double precoGasolina = Double.parseDouble(inputGasolina.getText().toString());
                            double precoEtanol = Double.parseDouble(inputEtanol.getText().toString());
                            double maisEconomico = (precoEtanol / precoGasolina) * 100;

                            if (maisEconomico > 60) {
                                getIntent(GasolinaActivity.class);
                            } else {
                                getIntent(EtanolActivity.class);
                            }
                        }
                    }catch (Exception ignored){
                        Toast.makeText(CalculatorActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationClass.btnAnimationImageButton(btnLimpar);
                inputGasolina.setText("");
                inputEtanol.setText("");
            }
        });
    }

    private void getIntent(Class name){
        Intent intent = new Intent(getApplicationContext(), name);
        startActivity(intent);
    }
}