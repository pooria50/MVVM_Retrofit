package com.example.pooria.mvvm_retrofit;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.pooria.mvvm_retrofit.adapter.CustomAdapter;
import com.example.pooria.mvvm_retrofit.viewmodel.FilmViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private FilmViewModel filmViewModel;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler = findViewById(R.id.recycler);
        filmViewModel = ViewModelProviders.of(this)
                .get(FilmViewModel.class);
        filmViewModel.getArrayListMutableLiveData().observe(this,
                new Observer<ArrayList<FilmViewModel>>() {
                    @Override
                    public void onChanged(@Nullable ArrayList<FilmViewModel> filmViewModels) {
                        customAdapter = new CustomAdapter(
                                MainActivity.this, filmViewModels
                        );
                        recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        recycler.setAdapter(customAdapter);
                    }
                });
    }
}
