package com.example.pooria.mvvm_retrofit.remote;

import com.example.pooria.mvvm_retrofit.model.FilmList;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Call;
import retrofit2.http.GET;


public interface APIService {
    

    @GET("api/json/get/ckXwVMgONu?indent=2")
    Call<FilmList> getFilmList();


    //get film list RX
    @GET("api/json/get/bUbTYnlScy?indent=2")
    Observable<FilmList> getFilmsListByRx();
}
