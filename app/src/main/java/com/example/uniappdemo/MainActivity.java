package com.example.uniappdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.uniappdemo.contract.UniListContract;
import com.example.uniappdemo.model.UniPojo;
import com.example.uniappdemo.presenter.UniPresenter;
import com.example.uniappdemo.view.UniListAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements UniListContract.View {

    private UniPresenter uniPresenter;
    private RecyclerView myUniList;
    private List<UniPojo> uniList;
    private UniListAdapter uniListAdapter;
    private ProgressBar pbLoading;

    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myUniList=findViewById(R.id.myUniList);
        pbLoading = findViewById(R.id.pbLoading);

        uniList = new ArrayList<>();
        layoutManager = new LinearLayoutManager(this);
        myUniList.setLayoutManager(layoutManager);
        myUniList.setHasFixedSize(true);

        uniPresenter = new UniPresenter(this);
        uniPresenter.requestDataFromServer();
    }

    @Override
    public void showProgress() {
        pbLoading.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgress() {
        pbLoading.setVisibility(View.GONE);

    }

    @Override
    public void setDataToRecylcerView(List<UniPojo> uniListArray) {

        uniList.addAll(uniListArray);
        uniListAdapter = new UniListAdapter(uniList, MainActivity.this);
        myUniList.setAdapter(uniListAdapter);
        myUniList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(MainActivity.this, "List Ends Here", Toast.LENGTH_LONG).show();

                }
            }
        });

    }

    @Override
    public void onResposeFailure(Throwable throwable) {

    }


}