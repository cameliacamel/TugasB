package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    Database db;
    Button login;
    EditText username,password;
    TextView register;
    ImageButton backlogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = new Database(this);

        username = (EditText)findViewById(R.id.et_login_username);
        password = (EditText)findViewById(R.id.et_login_password);
        login = (Button)findViewById(R.id.btn_login);
        register = (TextView)findViewById(R.id.tv_register);
        backlogin = findViewById(R.id.back_login);

        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(Login.this, Register.class);
                startActivity(registerIntent);
                finish();
            }
        });

        //back login
        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backloginIntent = new Intent(Login.this, MainActivity.class);
                startActivity(backloginIntent);
                finish();
            }
        });

        //login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                Boolean masuk = db.checkLogin(strUsername, strPassword);
                if (masuk == true) {
                    Boolean updateSession = db.upgradeSession("ada", 1);
                    if (updateSession == true){
                        Toast.makeText(getApplicationContext(), "Berhasil Masuk", Toast.LENGTH_SHORT).show();
                        Intent uploadIntent = new Intent(Login.this, Upload.class);
                        startActivity(uploadIntent);
                        finish();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Masuk Gagal", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
