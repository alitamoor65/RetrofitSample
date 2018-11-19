package com.example.alitamoor.retrofitsample.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RestDBApi {

    @Headers("x-apikey: fc0580cad6c2d5b4f7728dd868ae02eed6f6b")
    @GET("users")
    Call<List<UserPOJO>> getAllUsers();

    @Headers("x-apikey: fc0580cad6c2d5b4f7728dd868ae02eed6f6b")
    @POST("users")
    Call<AddUserResponsePojo> reqisterUser(@Body AddUserPojo userPOJO);
}
