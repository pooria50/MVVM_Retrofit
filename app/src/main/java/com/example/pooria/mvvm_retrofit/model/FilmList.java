
package com.example.pooria.mvvm_retrofit.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilmList {

    @SerializedName("records")
    @Expose
    public ArrayList<Record> records = new ArrayList<>();

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<Record> records) {
        this.records = records;
    }
}
