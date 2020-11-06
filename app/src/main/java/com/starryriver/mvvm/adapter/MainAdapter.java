package com.starryriver.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.starryriver.mvvm.R;
import com.starryriver.mvvm.bean.MpBean;
import com.starryriver.mvvm.databinding.AdapterMainBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : StarryRivers
 * Project  : MVVM
 * Desc     : MainAdapter
 * @date : 2020/11/6 12:54
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<MpBean> list = new ArrayList<>();
    private LayoutInflater inflater;

    public MainAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterMainBinding adapterMainBinding = DataBindingUtil.inflate(inflater, R.layout.adapter_main, parent, false);
        return new ViewHolder(adapterMainBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        MpBean bean = list.get(position);
        if (bean != null) {
            holder.binding.setMp(bean);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private AdapterMainBinding binding;

        ViewHolder(@NonNull AdapterMainBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<MpBean> list) {
        this.list = list;
        notifyDataSetChanged();
    }
}
