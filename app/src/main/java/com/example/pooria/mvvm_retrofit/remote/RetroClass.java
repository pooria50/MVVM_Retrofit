package com.example.pooria.mvvm_retrofit.remote;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClass {

    private static final String BASE_URL = "http://www.json-generator.com/";
    //private static final String BASE_URL = "http://www.json-generator.com/";
    private static Retrofit getRetroInstance () {
        Gson gson = new GsonBuilder().setLenient().create();

        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).addCallAdapterFactory(
                RxJavaCallAdapterFactory.create()
        ).build();
    }

    public static APIService  getApiService() {


        return getRetroInstance().create(APIService.class);
    }

}
