package com.example.savefuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Objects;

public class SplashActivityTwo extends AppCompatActivity{
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_two);

        textView = findViewById(R.id.txtComecar);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        AnimationClass animationClass = new AnimationClass();


        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animationClass.btnAnimationTxtView(textView);
                getIntent(CalculatorActivity.class);
            }
        });
    }


    private void getIntent(Class name) {
        Intent intent = new Intent(getApplicationContext(), name);
        startActivity(intent);
    }
}