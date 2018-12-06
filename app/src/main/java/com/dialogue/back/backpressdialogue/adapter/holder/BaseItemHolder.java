package com.dialogue.back.backpressdialogue.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author HANZALA
 */

public class BaseItemHolder<T> extends RecyclerView.ViewHolder {


    protected T mObject;
    protected int mPosition;
    protected int mSize;

    public BaseItemHolder(View itemView) {
        super(itemView);
    }

    public void bindData(T object, int position, int size) {
        this.mObject = object;
        this.mPosition = position;
        this.mSize = size;
    }

}