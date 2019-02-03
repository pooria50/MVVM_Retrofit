package com.example.pooria.mvvm_retrofit.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String BASE_URL = "http://192.168.43.58/Mvvm_Retrofit/";
    //public static final String BASE_URL = "http://192.168.1.109/Mvvm_Retrofit/";

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(
                RxJavaCallAdapterFactory.create()
        ).build();

    }

    public static APIService  getApiService() {
        return getClient().create(APIService.class);
    }
}
