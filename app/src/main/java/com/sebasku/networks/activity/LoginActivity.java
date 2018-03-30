package com.sebasku.networks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.BaseApiService;
import com.sebasku.networks.api.UtilsApi;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button Login;
    BaseApiService apiService;
    EditText username,password;
    String mUsername,mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialized();
        actionClicked();
        apiService = UtilsApi.getAPIService();
    }
    public void initialized(){
        Login =findViewById(R.id.btn_login);
        username = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);

    }
    public void actionClicked(){
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsername = username.getText().toString();
                mPassword = password.getText().toString();
                saveLogin(mUsername,mPassword);
            }
        });
    }

    private void saveLogin(String username, String password){

        apiService.addLogin(username,password)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(LoginActivity.this,MenuActivity.class);
                            startActivity(i);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Cek email atau Password", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
