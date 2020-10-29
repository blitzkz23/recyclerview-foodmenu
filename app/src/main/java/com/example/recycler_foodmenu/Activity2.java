package com.example.recycler_foodmenu;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    ImageView gambar;
    TextView judul,harga,deskripsi;

    String data1,data2,data3;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        gambar = findViewById(R.id.myImages);
        judul = findViewById(R.id.foodname);
        harga = findViewById(R.id.price);
        deskripsi = findViewById(R.id.description);

        getData();
        setData();
    }


    private void getData()
    {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3"))
        {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            images = getIntent().getIntExtra("myImage",1);
        }
        else
        {
            Toast.makeText(this,"tidak ada data",Toast.LENGTH_SHORT).show();
        }

    }

    private void setData()
    {
        judul.setText(data1);
        harga.setText(data2);
        deskripsi.setText(data3);
        gambar.setImageResource(images);
    }
}
