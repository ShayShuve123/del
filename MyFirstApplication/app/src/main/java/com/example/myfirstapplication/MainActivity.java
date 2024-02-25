package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText num1;
    EditText num2;
    TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         num1= (EditText) findViewById(R.id.editTextTextOne);
         num2=(EditText)findViewById(R.id.editTextTextTwo);
         res=(TextView) findViewById(R.id.resultTextView);
       //Button addBtn=(Button) findViewById(R.id.addBtn);//to active the btn
    }

    public void funcBtn(View view) {
        int num11=Integer.parseInt(num1.getText().toString());
        int num22=Integer.parseInt(num2.getText().toString());

        Button btn=(Button) view;
        String clickBtn=btn.getText().toString();
        switch (clickBtn) {
            case "ADD":
                int ResultADD=num11+num22;
                res.setText(ResultADD+" ");
                break;
            case "MULT":
                int ResultMult=num11*num22;
                res.setText(ResultMult+ " ");
                break;
        }

    }
}


