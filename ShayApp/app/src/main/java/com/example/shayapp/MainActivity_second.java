package com.example.shayapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity_second extends AppCompatActivity {

    final String KEY1="MainActivity";

    TextView result2;

    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);

     setContentView(R.layout.activity_main_second);

      Intent intent=getIntent();

      result2=(TextView) findViewById(R.id.textView2);

      double res1 = Double.parseDouble(Objects.requireNonNull(intent.getStringExtra(KEY1)));

      result2.setText(String.valueOf(res1));

    }


}
