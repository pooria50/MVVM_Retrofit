package com.example.pooria.mvvm_retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductList {

    @SerializedName("records")
    @Expose
    public ArrayList<Products> records = new ArrayList<>();

    public ArrayList<Products> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Products> records) {
        this.records = records;
    }
}

