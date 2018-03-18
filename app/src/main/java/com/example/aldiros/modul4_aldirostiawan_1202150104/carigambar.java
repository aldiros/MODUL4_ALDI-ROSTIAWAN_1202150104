package com.example.aldiros.modul4_aldirostiawan_1202150104;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class carigambar extends AppCompatActivity {
    ImageView imgGambar;
    EditText linkweb;
    Button btnCari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carigambar);
        setTitle("Cari Gambar"); //set title pada tampilan

        //MEMANGGIL ID PADA LAYOUT
        imgGambar = (ImageView) findViewById(R.id.gambar);
        linkweb = (EditText) findViewById(R.id.link);
        btnCari = (Button)findViewById(R.id.cari);

        //OnClickListener UNTUK BUTTON CARI GAMBAR
        btnCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Picasso.with(carigambar.this).load(linkweb.getText().toString())
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(imgGambar);
            }
        });
    }
}

