package com.example.uniappdemo.contract;

import com.example.uniappdemo.model.UniPojo;

import java.util.List;

public class UniListContract {

    public interface Model{
        interface OnFinshedListener{
            void onFinised(List<UniPojo>uniArrayList);
            void onFailure(Throwable t);
        }

        void getUniList(OnFinshedListener onFinshedListener);

    }

    public interface View{
        void showProgress();
        void hideProgress();
        void setDataToRecylcerView(List<UniPojo> uniListArray);
        void onResposeFailure(Throwable throwable);
    }

    public interface Presenter{
        void onDestroy();
        void getMoreData();
        void requestDataFromServer();

    }
}
