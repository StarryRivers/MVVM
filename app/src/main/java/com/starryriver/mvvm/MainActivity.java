package com.starryriver.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.starryriver.mvvm.databinding.ActivityMainBinding;
import com.starryriver.mvvm.viewmodel.MainViewModel;

/**
 * @author : StarryRivers
 * Project  : MVVM
 * Desc     : MainActivity
 * @date : 2020/11/5 18:47
 */
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mainViewModel.getMpData();
        mainBinding.rvMain.setAdapter(mainViewModel.mainAdapter);
    }
}
