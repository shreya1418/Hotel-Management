package com.example.hotelmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyMainAdapter extends RecyclerView.Adapter<MyMainAdapter.MyViewHolder>{

    Context context ;
    ArrayList<User> list;

//Right click generate constructor dono lelo

    public MyMainAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vi = LayoutInflater.from(context).inflate(R.layout.main_item,parent,false);
        return new MyViewHolder(vi);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        User user = list.get(position);

        holder.mname.setText("Name: "+user.getName());
        holder.mphone.setText("Phone Number: "+user.getPhone());
        holder.mtv_inTime.setText("Check in time: "+user.getInTime());
        holder.mtv_inDate.setText("Check in date: "+user.getInDate());
        holder.mtv_outTime.setText("Check out time: "+user.getOutTime());
        holder.mtv_Outdate.setText("Check out date: "+user.getOutDate());
        holder.mtv_roomType.setText("Room: "+user.getRoomType());
        holder.mperson.setText("Person: "+user.getPerson());
        holder.madhar.setText("Adhar 1: "+user.getAdharcard());
        holder.m2adhar.setText("Adhar 2: "+user.getAdharcard1());
        holder.child.setText("Child: "+ user.getChild());
        holder.mtv_amount.setText(user.getAmount());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView mname,mphone,mtv_inTime,mtv_inDate,mtv_outTime
                ,mtv_Outdate,mtv_roomType,mperson,madhar,m2adhar,child,mtv_amount;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mname= itemView.findViewById(R.id.mtv_name);
            mphone=itemView.findViewById(R.id.mtv_phone);
            mtv_inTime=itemView.findViewById(R.id.mtv_inTime);
            mtv_inDate=itemView.findViewById(R.id.mtv_inDate);
            mtv_outTime=itemView.findViewById(R.id.mtv_outTime);
            mtv_Outdate=itemView.findViewById(R.id.mtv_Outdate);
            mtv_roomType=itemView.findViewById(R.id.mtv_roomType);
            mperson = itemView.findViewById(R.id.mtv_person);
            madhar = itemView.findViewById(R.id.mtv_adhar);
            m2adhar = itemView.findViewById(R.id.m2adhar);
            child = itemView.findViewById(R.id.child);
            mtv_amount = itemView.findViewById(R.id.mtv_amount);
        }


    }

}
