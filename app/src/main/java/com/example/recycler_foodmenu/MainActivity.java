package com.example.recycler_foodmenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView r1;
    String s1[], s2[], s3[];
    int imageResource[] = {R.drawable.octo_ball, R.drawable.burito, R.drawable.gyozza, R.drawable.spaghetti_capjay, R.drawable.yakinikucola, R.drawable.maple_pancake, R.drawable.choco_maccaroni };
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1 = (RecyclerView)findViewById(R.id.myRecycler);
        s1 =getResources().getStringArray(R.array.haachama_cooking);
        s2 =getResources().getStringArray(R.array.price);
        s3 =getResources().getStringArray(R.array.description);
        adapter = new MenuAdapter(this, s1, s2, s3, imageResource);

        r1.setAdapter(adapter);
        r1.setLayoutManager(new LinearLayoutManager(this));

    }
}