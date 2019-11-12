package com.example.assignment_05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;
    private Button signup;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        login = findViewById(R.id.button_login);
        signup = findViewById(R.id.button_reg);
        db = new DatabaseHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),password.getText().toString());
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);

            }
        });

    }

    private void validate(String uName, String pass){
        if(uName.equals("")||pass.equals("")){
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Error");
            alert.setMessage("User Name or Password cannot be blank!");
            alert.setPositiveButton("OK", null);
            alert.show();
            return;
        }
        boolean cheklogin = db.checlogin(username.getText().toString(),password.getText().toString());
        if (cheklogin == true){
            Intent intent = new Intent(MainActivity.this, login_success.class);
            startActivity(intent);
        } else {
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
            alert.setTitle("Error");
            alert.setMessage("User Name or Password incorrect!");
            alert.setPositiveButton("OK", null);
            alert.show();
        }

    }
}
