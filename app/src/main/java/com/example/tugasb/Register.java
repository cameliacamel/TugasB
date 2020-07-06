package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    Database db;
    Button register;
    EditText username, password, passwordkonfirm;
    ImageButton backregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new Database(this);
        username = (EditText)findViewById(R.id.et_register_username);
        password = (EditText)findViewById(R.id.et_register_password);
        passwordkonfirm =(EditText)findViewById(R.id.et_password_konfirm);
        register = (Button)findViewById(R.id.btn_register);
        backregister = findViewById(R.id.back_register);

        //back register
        backregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backregisterIntent = new Intent(Register.this, MainActivity.class);
                startActivity(backregisterIntent);
                finish();
            }
        });


        //register
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername = username.getText().toString();
                String strPassword = password.getText().toString();
                String strPasswordkonfirm = passwordkonfirm.getText().toString();
                if (strPassword.equals(strPasswordkonfirm)){
                    Boolean daftar = db.insertUser(strUsername, strPassword);
                    if (daftar == true){
                        Toast.makeText(getApplicationContext(), "Daftar Berhasil", Toast.LENGTH_SHORT).show();
                        Intent loginIntent = new Intent(Register.this, Login.class);
                        finish();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "Daftar Gagal", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Password Tidak Cocok", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
