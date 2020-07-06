package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tugasb.fragment.UploadFragment;

public class Upload extends FragmentActivity implements View.OnClickListener {
Database db;
Button logout;
Button upload;

UploadFragment fragmentUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        db = new Database(this);

        logout = (Button)findViewById(R.id.btn_logout);
        upload = (Button)findViewById(R.id.btn_upload);

        upload.setOnClickListener(this);

        Boolean checkSession = db.checkSession("ada");
        if (checkSession == false) {
            Intent loginIntent = new Intent(Upload.this, Login.class);
            startActivity(loginIntent);
            finish();
        }

        //logout tmbl
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong", 1);
                if (updtSession == true){
                    Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT). show();
                    Intent loginIntent = new Intent(Upload.this, Login.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });
    }

    void menuUpload(){
        fragmentUpload = new UploadFragment();
        FragmentTransaction ft = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragmentUpload);
        ft.commit();


    }

    @Override
    public void onClick(View v) {
        if (v == upload){
            menuUpload();
        }

    }
}
