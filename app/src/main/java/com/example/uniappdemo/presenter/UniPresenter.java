package com.example.uniappdemo.presenter;

import com.example.uniappdemo.contract.UniListContract;
import com.example.uniappdemo.model.UniPojo;
import com.example.uniappdemo.service.UniListModel;

import java.util.List;

public class UniPresenter implements UniListContract.Presenter, UniListContract.Model.OnFinshedListener{

    private UniListContract.View uniListView;
    private UniListContract.Model uniListModel;

    public UniPresenter(UniListContract.View uniListView) {
        this.uniListView = uniListView;
        uniListModel=new UniListModel();
    }

    @Override
    public void onDestroy() {
        this.uniListView=null;
    }

    @Override
    public void getMoreData() {
        if(uniListView!=null){
            uniListView.showProgress();
        }
        uniListModel.getUniList(this);

    }

    @Override
    public void requestDataFromServer() {
        if(uniListView!=null){
            uniListView.showProgress();
        }
        uniListModel.getUniList(this);

    }

    @Override
    public void onFinised(List<UniPojo> uniArrayList) {

        uniListView.setDataToRecylcerView(uniArrayList);
        if(uniListView!=null){
            uniListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        uniListView.onResposeFailure(t);
        if(uniListView!=null){
            uniListView.hideProgress();
        }
    }
}
