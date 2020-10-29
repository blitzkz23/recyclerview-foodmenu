package com.example.recycler_foodmenu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuHolder> {

    String data1[],data2[],data3[];
    int img[];
    Context ctx;

    public MenuAdapter(Context ct, String s1[], String s2[], String s3[], int i1[]){
        ctx = ct;
        data1 = s1;
        data2 = s2;
        data3 = s3;
        img=i1;
    }

    @NonNull
    @Override
    public MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater myInflater = LayoutInflater.from(ctx);
        View myView = myInflater.inflate(R.layout.my_row,parent,false);

        return new MenuHolder(myView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuHolder holder, final int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);
        holder.t3.setText(data3[position]);
        holder.myImage.setImageResource(img[position]);

        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, Activity2.class);
                intent.putExtra("data1",data1[position]);
                intent.putExtra("data2",data2[position]);
                intent.putExtra("data3",data3[position]);
                intent.putExtra("myImage",img[position]);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MenuHolder extends RecyclerView.ViewHolder{
        TextView t1,t2,t3;
        ImageView myImage;
        ConstraintLayout mainlayout;

        public MenuHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.foodname);
            t2 = itemView.findViewById(R.id.harga);
            t3 = itemView.findViewById(R.id.deskripsi);
            myImage = itemView.findViewById(R.id.myImage);
            mainlayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
