package com.example.moro.myapplication;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Moro on 2017/11/28.
 */

public class EnvDataAdapter extends RecyclerView.Adapter<EnvDataAdapter.ViewHolder> {
    private Context mContext;
    private List<EnvData> myEnvDataList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView envdataimage;
        TextView envdatatext;

        public ViewHolder(View view){
            super(view);
            cardView=(CardView)view;
            envdataimage=(ImageView)view.findViewById(R.id.envdata_image);
            envdatatext=(TextView)view.findViewById(R.id.envdata_name);
        }
    }

    public EnvDataAdapter(List<EnvData> envdatalist){
        myEnvDataList=envdatalist;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        if (mContext == null) {
            mContext=parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.data_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int position){
        EnvData envData=myEnvDataList.get(position);
        holder.envdatatext.setText(envData.getName());
        Glide.with(mContext).load(envData.getImageId()).into(holder.envdataimage);
    }
    @Override
    public int getItemCount(){
        return myEnvDataList.size();
    }
}
