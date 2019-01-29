package com.example.pooria.mvvm_retrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.pooria.mvvm_retrofit.Activities.RecyclerItemClickActivity;
import com.example.pooria.mvvm_retrofit.R;
import com.example.pooria.mvvm_retrofit.databinding.FilmBinding;
import com.example.pooria.mvvm_retrofit.viewmodel.FilmViewModel;
import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {

    private Context context;
    private ArrayList<FilmViewModel> arrayList;
    private LayoutInflater layoutInflater;


    public CustomAdapter() {
    }

    public CustomAdapter(Context context, ArrayList<FilmViewModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }



    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        FilmBinding binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.innerlayout, parent, false);
        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomView customView, final int i) {
        FilmViewModel filmViewModel = arrayList.get(i);
        customView.bind(filmViewModel);
        String s = arrayList.get(i).name.toString()+arrayList.get(i).firstappearance.toString();
        //Toast.makeText(context, "ss:    " + s.toString(), Toast.LENGTH_SHORT).show();
        Log.d("loggg", s);
        customView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = customView.filmBinding.getFilmmodel().realname.toString();
                Log.d("onclick", "onClick: "+s1.toString());
                Toast.makeText(context, "" + customView.filmBinding.getFilmmodel().realname, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, RecyclerItemClickActivity.class);
                intent.putExtra("name", s1);
                context.startActivity(intent);
                //Hawk.put("name", s1.toString());
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        public FilmBinding filmBinding;

        public CustomView(FilmBinding filmBinding) {
            super(filmBinding.getRoot());
            this.filmBinding = filmBinding;
        }

        public void bind(FilmViewModel filmViewModel) {
            this.filmBinding.setFilmmodel(filmViewModel);
            filmBinding.executePendingBindings();
        }

        public FilmBinding getFilmBinding() {
            return filmBinding;
        }
    }
}

