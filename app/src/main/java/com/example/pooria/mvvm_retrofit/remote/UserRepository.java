package com.example.pooria.mvvm_retrofit.remote;

import android.arch.lifecycle.MutableLiveData;
import android.telecom.Call;
import android.util.Log;

import com.example.pooria.mvvm_retrofit.model.FilmList;
import com.example.pooria.mvvm_retrofit.model.Record;
import com.example.pooria.mvvm_retrofit.viewmodel.FilmViewModel;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;


public class UserRepository {

    public MutableLiveData<ArrayList<FilmViewModel>>
            arrayListMutableLiveData = new MutableLiveData<>();
    private ArrayList<FilmViewModel> arrayList;

    private ArrayList<Record> items;

    public UserRepository() {

    }

    public MutableLiveData<ArrayList<FilmViewModel>> getArrayListMutableLiveData() {

        APIService apiService = RetroClass.getApiService();
        retrofit2.Call<FilmList> filmList = apiService.getFilmList();
        filmList.enqueue(new Callback<FilmList>() {
            @Override
            public void onResponse(retrofit2.Call<FilmList> call, Response<FilmList> response) {
                items = response.body().getRecords();
                Record record;
                FilmViewModel filmViewModel;
                arrayList = new ArrayList<>();
                for (int i = 0; i < items.size(); i++) {
                    record = new Record(
                            items.get(i).publisher,
                            items.get(i).name,
                            items.get(i).bio,
                            items.get(i).imageurl,
                            items.get(i).createdby,
                            items.get(i).team,
                            items.get(i).firstappearance,
                            items.get(i).realname
                    );
                    filmViewModel = new FilmViewModel(record);
                    arrayList.add(filmViewModel);

                }
                arrayListMutableLiveData.setValue(arrayList);
            }

            @Override
            public void onFailure(retrofit2.Call<FilmList> call, Throwable t) {
                Log.d("Error", t.getMessage().toString());

            }
        });
        return arrayListMutableLiveData;


    }
}
