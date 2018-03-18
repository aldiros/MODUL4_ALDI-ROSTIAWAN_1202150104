package com.example.aldiros.modul4_aldirostiawan_1202150104;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listmahasiswa extends AppCompatActivity {
    private String[] names = {
                                "Ari", "Tika", "Aulia", "Pratiwi", "Utami",
                                "Anggi", "Tri", "Dwi", "Agus", "Lestari",
                                "Maria", "Novita", "Tyas", "Nur", "Wahyu",
                                "Ade", "Riza", "Arya", "Hadi", "Bayu",
                                "Ria", "Dian", "Eka", "Indah", "Angga",
                                "Rizal", "Mila", "Lia", "Yani", "Rina",
                                "Adit", "Astuti", "Indra", "Yudi", "Asep"
                            };
    ListView listview;
    Button btnAsync;
    ProgressDialog progress;



        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_listmahasiswa);
            setTitle("List Mahasiswa"); //set title pada tampilan

            listview = (ListView) findViewById(R.id.listviewnama);
            listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, new ArrayList<String>()));


            btnAsync = (Button) findViewById(R.id.async);

            btnAsync.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View view) {
                    new MyTask().execute();     //MENGEKSEKUSI METHOD MyTask
                }
            });
        }

        class MyTask extends AsyncTask<Void, String, String> {
            ArrayAdapter<String> adapter;
            int count;      //MEMBUAT VARIABLE BARU COUNT

            @Override
            protected void onPreExecute() {

                //ARRAY ADAPTER
                adapter = (ArrayAdapter<String>) listview.getAdapter();

                //PROGRESS DIALOG WITH NEGATIVE BUTTON
                progress = new ProgressDialog(listmahasiswa.this);
                progress.setMax(35);        //MAKSIMAL DATA UNTUK MENCAPAI 100PERSEN
                progress.setTitle("Loading Data..");
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setCancelable(false);

                //MEMBUAT BUTTON CANCEL PADA PROGRESS DIALOG
                progress.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        MyTask.this.cancel(true);
                    }
                });
//                progress.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // your code
//                    }
//                });


                //MENAMPILKAN PROGRESS DIALOG
                progress.show();

                //MENGINISIASI NILAI COUNT
                count = 0;
            }

            @Override
            protected String doInBackground(Void... params) {
                for (String Name : names) {
                    publishProgress(Name);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                return "Semua Sata Sudah Siap";
            }

            @Override
            protected void onProgressUpdate(String... values) {
                adapter.add(values[0]);     //MEMASUKAN DATA DARI ARRAY, MULAI DARI INDEKS 0
                count++;        //INCREMENT
                progress.setProgress(count);        //UPDATE JUMLAH DATA PADA PROGRESS DIALOG
            }

            @Override
            protected void onPostExecute(String result) {
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();      //MENAMPILKAN TOAST
//                Toast.makeText(listmahasiswa.this, "Toast Success", Toast.LENGTH_SHORT).show();
                progress.hide();        //MENYEMBUNYIKAN PROGRESS DIALOG JIKA ASYNC TASK SELESAI
            }
        }
    }

