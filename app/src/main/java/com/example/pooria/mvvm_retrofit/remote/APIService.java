package com.example.pooria.mvvm_retrofit.remote;

import com.example.pooria.mvvm_retrofit.model.FilmList;
import com.example.pooria.mvvm_retrofit.model.ProductList;
import com.example.pooria.mvvm_retrofit.model.Products;
import com.example.pooria.mvvm_retrofit.model.UserModel;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIService {



    //GetPostsArraylist
    @GET("api/json/get/ckXwVMgONu?indent=2")
    Call<FilmList> getFilmList();


    //GetPostsArraylist
    @GET("ReadProducts.php")
    Call<ProductList> PerformGetPosts();



 /*   //get film list RX
    @GET("api/json/get/bUbTYnlScy?indent=2")
    Observable<FilmList> getFilmsListByRx();*/

    //Registering User
    @FormUrlEncoded
    @POST("RegisterForm.php")
    Call<UserModel> PerformRegister(@Field("username") String Username,
                                    @Field("password") String Password);
    //Login USer
    @GET("LoginForm.php")
    Call<UserModel> PerformLogin(@Query("username") String Username,
                                 @Query("password") String Password);

    //Send Products for Posts
    @FormUrlEncoded
    @POST("GetProducts.php")
    Call<Products> PerformSendPost(@Field("name") String name,
                                   @Field("location") String location,
                                   @Field("price") String price,
                                   @Field("description") String description,
                                   @Field("image_url") String image_url);


}
