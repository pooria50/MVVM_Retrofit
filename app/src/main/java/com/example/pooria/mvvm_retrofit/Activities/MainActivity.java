package com.example.pooria.mvvm_retrofit.Activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import com.example.pooria.mvvm_retrofit.R;
import com.example.pooria.mvvm_retrofit.adapter.CustomAdapter;
import com.example.pooria.mvvm_retrofit.viewmodel.ProductViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recycler;
    private CustomAdapter customAdapter;
    private ProductViewModel productViewModel;

    private DrawerLayout mdrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bottom Navigation
        mdrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mdrawerLayout, R.string.Open, R.string.Close);
        mdrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recycler = findViewById(R.id.recycler);

        //Mvvm Bind Datas

        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        productViewModel = ViewModelProviders.of(this).get(ProductViewModel.class);
        productViewModel.getArrayListMutableLiveData().observe(this, new Observer<ArrayList<ProductViewModel>>() {
            @Override
            public void onChanged(@Nullable ArrayList<ProductViewModel> productViewModels) {
                customAdapter = new CustomAdapter(MainActivity.this, productViewModels);
                recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recycler.setAdapter(customAdapter);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.da:
                Toast.makeText(this, "daaaaaaa", Toast.LENGTH_SHORT).show();
        }

      /*  if (mToggle.onOptionsItemSelected(item)) {
            if (item.getItemId() == R.id.da) {
                Toast.makeText(this, "Da", Toast.LENGTH_SHORT).show();
            }
            if (item.getItemId() == R.id.db) {
                Toast.makeText(this, "Db", Toast.LENGTH_SHORT).show();
            }
            if (item.getItemId() == R.id.dc) {
                Toast.makeText(this, "Dc", Toast.LENGTH_SHORT).show();
            }
            if (item.getItemId() == R.id.dd) {
                Toast.makeText(this, "DD", Toast.LENGTH_SHORT).show();
            }
        }*/
        return super.onOptionsItemSelected(item);
    }
}
