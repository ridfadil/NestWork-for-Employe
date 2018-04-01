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
import com.sebasku.networks.apimodel.LoginForm;
import com.sebasku.networks.apimodel.ResponseLogin;
import com.sebasku.networks.apimodel.Token;
import com.sebasku.networks.apimodel.User;
import com.sebasku.networks.session.sessionManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Button Login;
    String accesId;
    sessionManager session;
    BaseApiService apiService;
    EditText username, password;
    String mUsername, mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialized();
        actionClicked();
        session = new sessionManager(getApplicationContext());
        if (session.isLoggedIn()) {
            startActivity(new Intent(getApplicationContext(), MenuActivity.class));
        }

        apiService = UtilsApi.getAPIService();
    }


    public void initialized() {
        Login = findViewById(R.id.btn_login);
        username = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);

    }

    public void actionClicked() {
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsername = username.getText().toString();
                mPassword = password.getText().toString();
                saveLogin(mUsername, mPassword);
            }
        });
    }

    private void saveLogin(String username, String password) {

        LoginForm login = new LoginForm(username, password);
        Call<ResponseLogin> call = UtilsApi.getAPIService().addLogin(login);

        call.enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()) {
                    User responsesId = response.body().getUser();
                    Token responsesToken = response.body().getToken();
                    String token = responsesToken.getAccessToken();
                    String id = responsesId.getId();
                    session.createIdSession(id);
                    Toast.makeText(LoginActivity.this, id, Toast.LENGTH_SHORT).show();
                    Toast.makeText(LoginActivity.this, token, Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this, MenuActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "check your Email or Password", Toast.LENGTH_SHORT).show();
                }
            }

       /* apiService.addLogin(username,password)
                .enqueue(new Callback<ResponseLogin>() {
                    @Override
                    public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(getApplicationContext(), "Success Login", Toast.LENGTH_SHORT).show();
                            Token token = response.body().getToken();
                            accesToken = token.getAccessToken();
                        *//*    session.createLoginSession(accesToken);*//*

                            Toast.makeText(LoginActivity.this, accesToken, Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Cek email atau Password", Toast.LENGTH_SHORT).show();
                        }
                    }*/

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Koneksi internet bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
