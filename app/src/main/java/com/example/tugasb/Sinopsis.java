package com.example.tugasb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;

public class Sinopsis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinopsis);

        WebView webView = (WebView) findViewById(R.id.wv_buku1);
        String text ="  PADA 22 Desember 1990, Dilan mendeklarasikan hubungannya dengan Milea . Milea bahagia karena dia dan Dilan akhirnya berpacaran. Masa indah pun dilalui dua insan yang sedang dimabuk cinta ini. Saat ditanya, apa cita-cita Dilan, dia ingin menikahi Milea. Begitu pun Milea yang tak mungkin menolak Dilan.\n" +
                "Akan tetapi, hubungan Dilan dan Milea tak selamanya manis. Suatu hari Dilan dikeroyok sekelompok orang tak dikenal. Milea cemas, dia tahu ini ada hubungannya dengan posisi Dilan sebagai panglima perang salah satu geng motor di Bandung. Untuk itulah Milea ingin agar Dilan tak ikut-ikutan geng motor lagi.\n" +
                "Ketakutan Milea terbukti saat tahu kalau Dilan akan balas dendam kepada yang memukulinya. Belakangan, Dilan tahu siapa yang mengeroyok dia tempo hari. Untuk itulah, Dilan ingin balas dendam dengan menyerang kelompok yang memukulinya.\n" +
                "  Ditemani sepupu jauh Milea, Yugo, Milea mendatangi Dilan yang sedang menyusun strategi penyerangan. Sayangnya, kehadiran Yugo malah memperkeruh suasana. Akibat terlalu emosi, Milea juga sampai memberi ultimatum kepada Dilan, jika tetap menyerang, mereka putus.\n" +
                "Malam itu, Milea menyesal telah mengatakan kata \"putus\" kepada Dilan. Penyesalan Milea bertambah besar saat tahu kalau Dilan ditahan polisi karena melakukan penyerangan. Namun, masalah Milea dan Dilan bisa diatasi saat Milea bertemu Bunda Hara , ibunya Dilan.";

                webView.loadData("<p style=\"text-align: justify\">"+ text +"</p>", "text/html", "UTF-8");

    }
    public void back_sinopsis(View view) {
        Intent intent = new Intent(Sinopsis.this, Baca.class);
        startActivity(intent);
    }


}
