package com.example.uniappdemo.network;

import com.example.uniappdemo.model.UniListResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apiinterface {

    @GET("universities")
    Call<UniListResponse> getUniList();
}
