package com.sebasku.networks.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sebasku.networks.R;
import com.sebasku.networks.api.BaseApiService;
import com.sebasku.networks.api.UtilsApi;
import com.sebasku.networks.apimodel.ResponseLogin;
import com.sebasku.networks.apimodel.Token;
import com.sebasku.networks.session.sessionManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button Login;
    String accesToken;
    sessionManager session;
    BaseApiService apiService;
    EditText username,password;
    String mUsername,mPassword;
    List<Token> listToken = new ArrayList<>();

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
                .enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
                            Token token = response.body().getToken();
                            accesToken = token.getAccessToken();
                            session.createLoginSession(accesToken);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Cek email atau Password", Toast.LENGTH_SHORT).show();
                        }
                    }

                                    @Override
                                    public void onFailure(Call<ResponseLogin> call, Throwable t) {
                                        Toast.makeText(getApplicationContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }

                }
