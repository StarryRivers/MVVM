package com.starryriver.mvvm.viewmodel;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.starryriver.mvvm.adapter.MainAdapter;
import com.starryriver.mvvm.base.BaseData;
import com.starryriver.mvvm.bean.MpBean;
import com.starryriver.mvvm.model.MainModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

/**
 * @author : StarryRivers
 * Project  : MVVM
 * Desc     : ViewModel MVVM
 * @date : 2020/11/6 12:37
 */
public class MainViewModel extends AndroidViewModel {
    private MainModel mainModel = MainModel.getInstance();
    private Context mContext;
    public MainAdapter mainAdapter;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mContext = application;
        mainAdapter = new MainAdapter(application);
    }

    public void getMpData() {
        Observer<BaseData<List<MpBean>>> observer = new Observer<BaseData<List<MpBean>>>() {
            @Override
            public void onSubscribe(@io.reactivex.rxjava3.annotations.NonNull Disposable d) {

            }

            @Override
            public void onNext(@io.reactivex.rxjava3.annotations.NonNull BaseData<List<MpBean>> listBaseData) {
                if (listBaseData.getErrorCode() == 0) {
                    mainAdapter.setList(listBaseData.getData());
                }
            }

            @Override
            public void onError(@io.reactivex.rxjava3.annotations.NonNull Throwable e) {
                // error
            }

            @Override
            public void onComplete() {
                Toast.makeText(mContext, "get data completed.", Toast.LENGTH_SHORT).show();
            }
        };
        mainModel.subscribe(observer);
    }
}
