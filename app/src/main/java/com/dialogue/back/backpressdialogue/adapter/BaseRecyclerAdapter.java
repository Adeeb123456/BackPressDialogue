package com.dialogue.back.backpressdialogue.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.dialogue.back.backpressdialogue.adapter.holder.BaseItemHolder;

import java.util.ArrayList;
import java.util.List;


public class BaseRecyclerAdapter<T, D extends BaseItemHolder> extends RecyclerView.Adapter<D> {

    protected final int mLayout;
    protected final Class<? extends BaseItemHolder> mHolderClass;


    protected List<T> mList;

    public BaseRecyclerAdapter(@LayoutRes int layout, Class<? extends BaseItemHolder> holderClass) {
        mList = new ArrayList<>();
        mLayout = layout;
        mHolderClass = holderClass;
    }

    @Override
    public D onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(mLayout, parent, false);
//        return new D(view);
        try {
            return (D) mHolderClass.getConstructor(View.class).newInstance(view);
        } catch (Exception e) {
            Log.e("Generic adapter error", e + "");
        }
        return null;

    }

    @Override
    public void onBindViewHolder(BaseItemHolder holder, int position) {
        holder.bindData(mList.get(position), position, mList.size());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(@NonNull List<T> dataList) {
        mList = dataList;
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return mList;
    }

}
