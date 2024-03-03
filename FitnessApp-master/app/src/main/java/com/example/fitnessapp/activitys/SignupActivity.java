package com.example.fitnessapp.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitnessapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private EditText editTextFirstName, editTextLastName, editTextUserName, editTextPassword,
            editTextPhone, editTextHeight, editTextWeight, editTextAge;
    private RadioGroup radioGroupGender;
    private Button buttonSignup;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sign_up);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        buttonSignup = findViewById(R.id.btnSignUp);

        mAuth = FirebaseAuth.getInstance();

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editTextFirstName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                String userName = editTextUserName.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();
                String phone = editTextPhone.getText().toString().trim();
                String height = editTextHeight.getText().toString().trim();
                String weight = editTextWeight.getText().toString().trim();
                String age = editTextAge.getText().toString().trim();

                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                RadioButton selectedGenderButton = findViewById(selectedGenderId);
                String gender = selectedGenderButton.getText().toString();

                signupUser(firstName, lastName, userName, password, phone, height, weight, age, gender);
            }
        });
    }

    private void signupUser(String firstName, String lastName, String userName, String password,
                            String phone, String height, String weight, String age, String gender) {
        mAuth.createUserWithEmailAndPassword(userName, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign up success
                            Toast.makeText(SignupActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                            // You can start the next activity here
                        } else {
                            // If sign up fails, display a message to the user.
                            Toast.makeText(SignupActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
