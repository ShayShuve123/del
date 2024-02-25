package com.example.shayapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    int num1;
    int num2;
    String ch;

    String KEY1="MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result=(TextView) findViewById(R.id.textViewResult);//to Active the txt on the screen

    }


    public void funcNumbers(View view) {
        Button btn=(Button) view;
        String clickBtn=btn.getText().toString();//the string of the press btn
        result.append(clickBtn);
        String txt=result.getText().toString();
        result.setText(txt);

    }

    public void funcOperations(View view) {

        Button btn=(Button) view;
        String clickBtn=btn.getText().toString();//the string of the press btn
        ch=clickBtn;
        num1=Integer.parseInt(result.getText().toString());
        result.setText("");// Clears the text content
        result.setText(ch);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                result.setText("");
            }

        }, 1000); // 1000 milliseconds = 5 seconds

    }

    public void funcEqual(View view) {

        num2=Integer.parseInt(result.getText().toString());
        switch (ch) {
            case "+":
                result.setText("");
                result.setText(String.valueOf(num1+num2));
                break;
            case "-":
                result.setText("");
                result.setText(String.valueOf(num1-num2));
                break;

            case "X":
                result.setText("");
                result.setText(String.valueOf(num1*num2) );
                break;

            case "/"://to add try & catch div 0
                result.setText("");
                if (num2 != 0) {
                    result.setText(String.valueOf(num1 / num2));
                } else {
                    result.setText("Error");
                }
                break;

            case "AC":
                result.setText("");
                break;
        }


        Intent intent = new Intent(this, MainActivity_second.class);
        intent.putExtra(KEY1, result.getText().toString());
        startActivity(intent);
    }


}




