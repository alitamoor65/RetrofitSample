package com.example.alitamoor.retrofitsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.alitamoor.retrofitsample.rest.AddUserPojo;
import com.example.alitamoor.retrofitsample.rest.AddUserResponsePojo;
import com.example.alitamoor.retrofitsample.rest.RestDBApi;
import com.example.alitamoor.retrofitsample.rest.UserPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN";
    Retrofit retrofit;
    private final static String API_KEY = "";
    public static final String BASE_URL = "https://dluxsoft-b70c.restdb.io/rest/";
    RestDBApi restDBApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        restDBApi = retrofit.create(RestDBApi.class);
        Call<List<UserPOJO>> userPOJOCall = restDBApi.getAllUsers();
        userPOJOCall.enqueue(new Callback<List<UserPOJO>>() {
            @Override
            public void onResponse(Call<List<UserPOJO>> call, Response<List<UserPOJO>> response) {
                List<UserPOJO> userPOJOList = response.body();
                for (UserPOJO userPOJO : userPOJOList) {
                    Log.i(TAG, "onResponse: " + userPOJO.getDisplayname());
                    Log.i(TAG, "onResponse: " + userPOJO.getEmail());
                    Log.i(TAG, "onResponse: " + userPOJO.getId());
                    Log.i(TAG, "onResponse: " + userPOJO.getPassword());
                    Log.i(TAG, "onResponse: " + userPOJO.getMock());
                    Log.i(TAG, "onResponse: " + userPOJO.getUserId());
                }
                Log.i(TAG, "onResponse: " + response.body());
            }

            @Override
            public void onFailure(Call<List<UserPOJO>> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getLocalizedMessage());
            }
        });

        findViewById(R.id.buttonRegisterID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    void registerUser(){
        AddUserPojo addUserPojo = new AddUserPojo();
        addUserPojo.setEmail("retroUser@gmail.com");
        addUserPojo.setPassword("retroUser");
        addUserPojo.setActive("true");
        addUserPojo.setDisplayname("User Pojo Name");
        Call<AddUserResponsePojo> userResponsePojoCall = restDBApi.reqisterUser(addUserPojo);
        userResponsePojoCall.enqueue(new Callback<AddUserResponsePojo>() {
            @Override
            public void onResponse(Call<AddUserResponsePojo> call, Response<AddUserResponsePojo> response) {
                Log.i(TAG, "onResponse: " + response.body().getDisplayname());
            }

            @Override
            public void onFailure(Call<AddUserResponsePojo> call, Throwable t) {
                Log.i(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}
