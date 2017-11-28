package com.example.moro.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Moro on 2017/11/27.
 */

public class DataFragment extends Fragment {



    private EnvData[] envDatas={new EnvData("温度",R.drawable.ic_pets_black_48dp),
            new EnvData("适度",R.drawable.ic_pets_black_48dp)};
    private List<EnvData> envDataList= new ArrayList<>();
    private EnvDataAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.data_fragment,container,false);
        initEnvDatas();
        RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.data_recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new EnvDataAdapter(envDataList);
        recyclerView.setAdapter(adapter);
        return view;


    }


    private void initEnvDatas(){
        envDataList.clear();
        for(int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(envDatas.length);
            envDataList.add(envDatas[index]);
        }
    }
}
