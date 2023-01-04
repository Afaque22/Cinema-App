package com.example.cinemaapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RAdapter extends RecyclerView.Adapter<RAdapter.ViewHolder> {
    Context context;
    ArrayList<constructors> arrModel;

    public RAdapter(Context context, ArrayList<constructors> arrModel) {
        this.context = context;
        this.arrModel = arrModel;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardviewlist,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        constructors model = (constructors) arrModel.get(position);
        holder.img.setImageResource(model.img);
        holder.txtName.setText(model.movieName);
        holder.txtTime.setText(model.movieTiming);
        holder.txtDay.setText(model.movieDay);

        holder.llrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.booking_dialog);
                EditText edtName = dialog.findViewById(R.id.dName);
                EditText edtNumber = dialog.findViewById(R.id.dNumber);
                EditText edtQuantity = dialog.findViewById(R.id.dQuantity);
                Button btnD = dialog.findViewById(R.id.dBtn);

                btnD.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = "", number = "", quantity = "";
                        if (!edtName.getText().toString().equals("")) {
                            name = edtName.getText().toString();
                        } else {
                            Toast.makeText(context, "Please Enter Your Name", Toast.LENGTH_SHORT).show();
                        }if (!edtNumber.getText().toString().equals("")) {
                            number = edtNumber.getText().toString();
                        } else {
                            Toast.makeText(context, "Please Enter Your Number", Toast.LENGTH_SHORT).show();
                        } if (!edtQuantity.getText().toString().equals("")){
                            quantity = edtQuantity.getText().toString();
                        }else {
                            Toast.makeText(context, "Please Enter The Quantity", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(context, "Your Seat are Booked Successfully", Toast.LENGTH_LONG).show();

                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        holder.llrow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Cancel Booking")
                        .setMessage("Are you sure you want to Cancel?")
                        .setIcon(R.drawable.ic_baseline_cancel_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(context, "Cancellation Successful", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                builder.show();
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtName, txtTime, txtDay;
        LinearLayout llrow;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.mImg);
            txtName = itemView.findViewById(R.id.txtName);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtDay = itemView.findViewById(R.id.txtDay);
            llrow = itemView.findViewById(R.id.llrow);

        }
    }
}
