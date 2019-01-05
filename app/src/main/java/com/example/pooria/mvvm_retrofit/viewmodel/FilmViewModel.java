package com.example.pooria.mvvm_retrofit.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.pooria.mvvm_retrofit.model.Record;
import com.example.pooria.mvvm_retrofit.remote.UserRepository;

import java.util.ArrayList;

public class FilmViewModel extends ViewModel {

    private UserRepository userRepasitory;

    public String publisher = "";
    public String name = "";
    public String bio = "";
    public String imageurl = "";
    public String createdby = "";
    public String team = "";
    public String firstappearance = "";
    public String realname = "";


    public String getImageurl() {
        return imageurl;
    }

    public MutableLiveData<ArrayList<FilmViewModel>>
            arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<FilmViewModel> arrayList;

    public FilmViewModel(){
        userRepasitory = new UserRepository();
        arrayListMutableLiveData = userRepasitory.getArrayListMutableLiveData();
    }

    public FilmViewModel(Record record) {
        this.publisher = record.publisher;
        this.name = record.name;
        this.bio = record.bio;
        this.imageurl = record.imageurl;
        this.createdby = record.createdby;
        this.team = record.team;
        this.firstappearance = String.valueOf(record.firstappearance);
        this.realname = record.realname;

    }


    public MutableLiveData<ArrayList<FilmViewModel>>getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }

    @BindingAdapter({"bind:imageurl"})
    public static void getimageurl(ImageView view, String imageurl){
        Glide.with(view.getContext()).load(imageurl).into(view);
    }
}
