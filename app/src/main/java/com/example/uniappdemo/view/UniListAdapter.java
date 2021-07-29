package com.example.uniappdemo.view;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.uniappdemo.R;
import com.example.uniappdemo.model.UniPojo;
import com.example.uniappdemo.network.ApiClient;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.media.CamcorderProfile.get;

public class UniListAdapter extends RecyclerView.Adapter<UniListAdapter.MyViewHolder> {

    private List<UniPojo> uniList;
    private Context context;

    public UniListAdapter(List<UniPojo> uniList, Context context) {
        this.uniList = uniList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_uni_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //holder.uniimage
        holder.Uniname.setText(uniList.get(position).getName());
        holder.Uniwebsite.setText(uniList.get(position).getWebPages().toString());
        Glide.with(context).load(ApiClient.IMAGE_BASE_URL+uniList.get(position).getImageUrl()).into(holder.uniimage);
    }

    @Override
    public int getItemCount() {
        return uniList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView uniimage;
        TextView Uniname, Uniwebsite;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            uniimage=itemView.findViewById(R.id.Uniimage);
            Uniname=itemView.findViewById(R.id.uniname);
            Uniwebsite=itemView.findViewById(R.id.uniwebsite);

        }
    }
}
