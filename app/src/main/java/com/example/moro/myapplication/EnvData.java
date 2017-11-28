package com.example.moro.myapplication;

/**
 * Created by Moro on 2017/11/28.
 */

public class EnvData {
    private String name;
    private int imageId;

    public EnvData(String name,int imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
}
