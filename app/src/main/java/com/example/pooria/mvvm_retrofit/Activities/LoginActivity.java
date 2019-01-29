package com.example.pooria.mvvm_retrofit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pooria.mvvm_retrofit.R;
import com.example.pooria.mvvm_retrofit.Utils.Common;
import com.example.pooria.mvvm_retrofit.model.UserModel;
import com.example.pooria.mvvm_retrofit.remote.APIService;
import com.example.pooria.mvvm_retrofit.remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edt_username, edt_password;
    private Button btn_register;
    private TextView txt_forgot;
    private APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BindControls();
        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginRequest();
            }
        });

    }

    private void LoginRequest() {
        String _username = edt_username.getText().toString();
        String _password = edt_password.getText().toString();
        apiService = Common.getAPI();
        apiService.PerformLogin(_username,_password).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                    UserModel body = response.body();
                    String username = body.getUsername();
                    String password = body.getPassword();
                    Log.d("model", "dksfljjjjjjjjjjjjjjjjjsdlkfjsdlk");
                    Log.d("model", username);

            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d("model", t.toString());
            }
        });
    }

    private void BindControls() {
        edt_username = findViewById(R.id.edt_username);
        edt_password = findViewById(R.id.edt_username);
        btn_register = findViewById(R.id.btn_register);
        txt_forgot = findViewById(R.id.txt_forgot);
    }
}
