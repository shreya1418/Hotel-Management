package com.example.hotelmanagement;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{


    Context context ;
    ArrayList<User> list;
    DatabaseReference databaseReference;
    //Right click generate constructor dono lelo

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
        databaseReference = FirebaseDatabase.getInstance().getReference();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {



        User user = list.get(position);
        holder.name.setText(user.getName());

        holder.phone.setText("Phone Number: "+user.getPhone());
        holder.tv_inTime.setText("Check in time: "+user.getInTime());
        holder.tv_inDate.setText("Check in date: "+user.getInDate());
        holder.tv_outTime.setText("Check out time: "+user.getOutTime());
        holder.tv_Outdate.setText("Check out date: "+user.getOutDate());
        holder.tv_roomType.setText("Room: "+user.getRoomType());
        holder.tv_Token.setText("Token: "+user.getToken());
        holder.tv_adhar.setText("Adhar 1: "+user.getAdharcard());
        holder.tv_person.setText("Person: "+user.getPerson());
        holder.tv_m2adhar.setText("Adhar 2: "+user.getAdharcard1());
        holder.tv_child.setText("Child: "+ user.getChild());
        holder.tv_amount.setText(user.getAmount());
        String phone = user.getPhone();

        holder.delbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child("Users").child(phone).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(context, ""+phone, Toast.LENGTH_SHORT).show();
                        Toast.makeText(context, "Room is free now", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(context, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,phone,tv_inTime,tv_inDate,tv_outTime
                ,tv_Outdate,tv_roomType,tv_Token,tv_adhar,tv_person
                ,tv_m2adhar,tv_child,tv_amount;
        Button delbtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name= itemView.findViewById(R.id.tv_name);
            phone=itemView.findViewById(R.id.tv_phone);
            tv_inTime=itemView.findViewById(R.id.tv_inTime);
            tv_inDate=itemView.findViewById(R.id.tv_inDate);
            tv_outTime=itemView.findViewById(R.id.tv_outTime);
            tv_Outdate=itemView.findViewById(R.id.tv_Outdate);
            tv_roomType=itemView.findViewById(R.id.tv_roomType);
            tv_Token=itemView.findViewById(R.id.tv_Token);
            tv_adhar = itemView.findViewById(R.id.tv_adhar);
            tv_person = itemView.findViewById(R.id.tv_person);
            tv_m2adhar = itemView.findViewById(R.id.tv_m2adhar);
            tv_child = itemView.findViewById(R.id.tv_child);
            tv_amount = itemView.findViewById(R.id.tv_amount);
            delbtn = itemView.findViewById(R.id.delbtn);

        }


    }



}
