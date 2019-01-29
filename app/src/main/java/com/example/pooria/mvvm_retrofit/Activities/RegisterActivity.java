package com.example.pooria.mvvm_retrofit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pooria.mvvm_retrofit.R;
import com.example.pooria.mvvm_retrofit.Utils.Common;
import com.example.pooria.mvvm_retrofit.model.UserModel;
import com.example.pooria.mvvm_retrofit.remote.APIService;
import com.example.pooria.mvvm_retrofit.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {


    private EditText edt_username,edt_password;
    private Button btn_register;
    private APIService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        BindControls();
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterRequest();

            }
        });
    }

    private void RegisterRequest() {
        String _username = edt_username.getText().toString();
        String _password = edt_password.getText().toString();
        apiService = Common.getAPI();
        apiService.PerformRegister(_username,_password).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                UserModel body = response.body();
                Log.d("model", body.toString());
                Toast.makeText(RegisterActivity.this, "Register Compeleted :)", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d("model", "onFailure: " + t.getMessage().toString());
            }
        });
    }

    private void BindControls() {
        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_username);
        btn_register = findViewById(R.id.btn_register);
    }
}
