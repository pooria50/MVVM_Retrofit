package com.example.pooria.mvvm_retrofit.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.pooria.mvvm_retrofit.R;
import com.example.pooria.mvvm_retrofit.Utils.Common;
import com.example.pooria.mvvm_retrofit.model.Products;
import com.example.pooria.mvvm_retrofit.remote.APIService;
import com.example.pooria.mvvm_retrofit.remote.RetrofitClient;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendPostActivity extends AppCompatActivity {

    private ImageView img_url;
    private EditText edt_location, edt_price, edt_description, edt_name;
    private Button btn_send;
    private APIService apiService;
    private Bitmap bitmap;
    private static final int IMG_REQUEST = 777;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_post);
        BindContols();
        img_url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendPost();
            }
        });
    }

    private void SendPost() {
        String _location = edt_location.getText().toString();
        String _price = edt_price.getText().toString();
        String _description = edt_description.getText().toString();
        String _name = edt_name.getText().toString();
        String _image_url = imageToString();
        apiService = RetrofitClient.getClient().create(APIService.class);
        apiService.PerformSendPost(_name, _location, _price, _description,_image_url).enqueue(new Callback<Products>() {
            @Override
            public void onResponse(Call<Products> call, Response<Products> response) {
                Products body = response.body();
                Log.d("retro", "Send Ook " + body.toString());
            }

            @Override
            public void onFailure(Call<Products> call, Throwable t) {
                Log.d("retro", " Error : " + t.toString());
            }
        });
    }

    private void BindContols() {
        edt_description = findViewById(R.id.edt_description);
        edt_price = findViewById(R.id.edt_price);
        edt_location = findViewById(R.id.edt_location);
        img_url = findViewById(R.id.img_url);
        btn_send = findViewById(R.id.btn_send);
        edt_name = findViewById(R.id.edt_name);
    }

    private String imageToString() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        byte[] imgByte = outputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }

    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                img_url.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
