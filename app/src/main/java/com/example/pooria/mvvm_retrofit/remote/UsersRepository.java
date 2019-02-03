package com.example.pooria.mvvm_retrofit.remote;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.pooria.mvvm_retrofit.Utils.Common;
import com.example.pooria.mvvm_retrofit.model.ProductList;
import com.example.pooria.mvvm_retrofit.model.Products;
import com.example.pooria.mvvm_retrofit.viewmodel.ProductViewModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UsersRepository {

    public MutableLiveData<ArrayList<ProductViewModel>> arrayListMutableLiveData = new MutableLiveData<>();
    public ArrayList<ProductViewModel> arrayList;
    public ArrayList<Products> items;
    public APIService apiService;

    public UsersRepository() {

    }


    public MutableLiveData<ArrayList<ProductViewModel>> getArrayListMutableLiveData(){
        apiService = RetrofitClient.getClient().create(APIService.class);
        Call<ProductList> list =  apiService.PerformGetProductlist();
        list.enqueue(new Callback<ProductList>() {
            @Override
            public void onResponse(Call<ProductList> call, Response<ProductList> response) {
                items = response.body().getRecords();
                Products products;
                ProductViewModel productViewModel;
                arrayList = new ArrayList<>();
                for (int i = 0; i < items.size(); i++) {
                    products = new Products(
                            items.get(i).id,
                            items.get(i).name,
                            items.get(i).location,
                            items.get(i).price,
                            items.get(i).description,
                            "Products/"+items.get(i).image_url
                    );
                    Log.d("err", products.toString());
                    productViewModel = new ProductViewModel(products);
                    arrayList.add(productViewModel);

                }
                arrayListMutableLiveData.setValue(arrayList);
            }

            @Override
            public void onFailure(Call<ProductList> call, Throwable t) {
                Log.d("Error", t.toString().toString());
            }

        });
        return arrayListMutableLiveData;
    }
}
