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

import com.example.pooria.mvvm_retrofit.Activities.MainActivity;
import com.example.pooria.mvvm_retrofit.Activities.RecyclerItemClickActivity;
import com.example.pooria.mvvm_retrofit.R;
import com.example.pooria.mvvm_retrofit.databinding.PostsBinding;
import com.example.pooria.mvvm_retrofit.viewmodel.ProductViewModel;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomView> {

    private Context context;
    private ArrayList<ProductViewModel> arrayList;
    private LayoutInflater layoutInflater;


    public CustomAdapter() {
    }

    public CustomAdapter(Context context, ArrayList<ProductViewModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        PostsBinding binding = DataBindingUtil.inflate(layoutInflater,
                   R.layout.innerlayout, parent, false);

        return new CustomView(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull final CustomView customView, final int i) {
        ProductViewModel productViewModel = arrayList.get(i);
        customView.bind(productViewModel);
        String s = arrayList.get(i).name.toString()+arrayList.get(i).price.toString();
        //Toast.makeText(context, "ss:    " + s.toString(), Toast.LENGTH_SHORT).show();
        Log.d("loggg", s);

      customView.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String _id = customView.postsBinding.getPostmodel().id.toString();
              Log.d("name", "onClick: "+ _id);
              Intent intent = new Intent(context, RecyclerItemClickActivity.class);
              intent.putExtra("name", _id);
              context.startActivity(intent);
          }
      });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class CustomView extends RecyclerView.ViewHolder {

        public PostsBinding postsBinding;

        public CustomView(PostsBinding postsBinding) {
            super(postsBinding.getRoot());
            this.postsBinding = postsBinding;
        }

        public void bind(ProductViewModel productViewModel) {
            this.postsBinding.setPostmodel(productViewModel);
            postsBinding.executePendingBindings();
        }

        public PostsBinding getPostsBinding() {
            return postsBinding;
        }
    }
}

