package com.example.aldiros.modul4_aldirostiawan_1202150104;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button btnList;
    private Button btnCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setTitle("Home"); //set title pada tampilan

        btnList = (Button) findViewById(R.id.list);
        btnCari = (Button) findViewById(R.id.cari);


        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, listmahasiswa.class);
                startActivity(i);
            }
        });

        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home.this, carigambar.class);
                startActivity(i);
            }
        });
    }
}
