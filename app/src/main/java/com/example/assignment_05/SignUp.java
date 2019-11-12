package com.example.assignment_05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    private  DatabaseHelper db;
    private EditText username;
    private EditText password;
    private EditText re_password;
    private Button ok;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        db = new DatabaseHelper(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        re_password = findViewById(R.id.re_pass);
        ok = findViewById(R.id.button_ok);
        cancel = findViewById(R.id.button_cancel);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(username.getText().toString(),password.getText().toString(),re_password.getText().toString());

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void validate(String username, String password, String re_pass){
        if (username.equals("")||password.equals("")||re_pass.equals("")){
            displayError("Fields cannot be blank!","Error");
            return;
        }
        if(!password.equals(re_pass)){
            displayError("Please make sure your passwords match!","Error");
            return;
        }else{
            boolean chekuser = db.checkuer(username);
            if(chekuser != true){
                displayError("User Name already exists. Please change user another User Name!","Error");
                return;
            }else {
                boolean insert = db.insert(username,password);
                if ( insert == true){
                    displayError("New User ID created. Please login...","Success!!!");
                }else {
                    displayError("Something went wrong. Please try again!","Error");
                    return;
                }
            }
        }
    }

    private  void  displayError(String msg, final String title){
        AlertDialog.Builder alert = new AlertDialog.Builder(SignUp.this);
        alert.setTitle(title);
        alert.setMessage(msg);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                if (title.equals("Success!!!")){
                    finish();
                }
            }
        });
        alert.show();
    }
}
