package com.example.pooria.mvvm_retrofit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pooria.mvvm_retrofit.R;
import com.orhanobut.hawk.Hawk;

public class RecyclerItemClickActivity extends AppCompatActivity {


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_item_click);
        intent = getIntent();
        String name = intent.getStringExtra("name");
        Toast.makeText(this, name.toString(), Toast.LENGTH_SHORT).show();

    }
}
