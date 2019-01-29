package com.example.pooria.mvvm_retrofit.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.Toast;

import com.example.pooria.mvvm_retrofit.R;
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
        //Bottom Navigation


        recycler = findViewById(R.id.recycler);

        //Mvvm Bind Datas
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
