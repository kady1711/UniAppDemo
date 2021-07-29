package com.example.uniappdemo.service;

import android.util.Log;

import com.example.uniappdemo.contract.UniListContract;
import com.example.uniappdemo.model.UniListResponse;
import com.example.uniappdemo.model.UniPojo;
import com.example.uniappdemo.network.ApiClient;
import com.example.uniappdemo.network.Apiinterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UniListModel implements UniListContract.Model {

    private final String TAG = "UniListModel";

    @Override
    public void getUniList(final OnFinshedListener onFinshedListener) {

        Apiinterface apiService = ApiClient.getClient().create(Apiinterface.class);
        Call<UniListResponse> call=apiService.getUniList();

        call.enqueue(new Callback<UniListResponse>() {
            @Override
            public void onResponse(Call<UniListResponse> call, Response<UniListResponse> response) {
                List<UniPojo> universities= response.body().getRes();

                Log.e(TAG, "Number of Universities"+ universities.size());
                onFinshedListener.onFinised(universities);
            }

            @Override
            public void onFailure(Call<UniListResponse> call, Throwable t) {
                    Log.e(TAG, t.toString());
                    onFinshedListener.onFailure(t);
            }
        });
    }
}
