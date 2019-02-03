package com.example.pooria.mvvm_retrofit.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.pooria.mvvm_retrofit.model.Products;
import com.example.pooria.mvvm_retrofit.remote.UsersRepository;

import java.util.ArrayList;

public class ProductViewModel extends ViewModel {

    public UsersRepository usersRepository;

    public String name = "",
            location = "", price = "", description = "", image_url = "";
    public Integer id;


    public String getImageurl() {
        return image_url;
    }


    public MutableLiveData<ArrayList<ProductViewModel>> arrayListMutableLiveData = new MutableLiveData<>();

    public ArrayList<ProductViewModel> arrayList;

    public ProductViewModel() {
        usersRepository = new UsersRepository();
        arrayListMutableLiveData = usersRepository.getArrayListMutableLiveData();
    }

    public ProductViewModel(Products products) {
        this.id = products.id;
        this.name = products.name;
        this.location = products.location;
        this.price = products.price;
        this.description = products.description;
        this.image_url = products.image_url;
    }


    public MutableLiveData<ArrayList<ProductViewModel>> getArrayListMutableLiveData(){
        return arrayListMutableLiveData;
    }


    @BindingAdapter({"bind:imageurl"})
    public static void getimageurl(ImageView view, String imageurl) {
        Glide.with(view.getContext()).load(imageurl).into(view);
    }

}




