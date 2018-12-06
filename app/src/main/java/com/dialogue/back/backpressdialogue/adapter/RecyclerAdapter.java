package com.dialogue.back.backpressdialogue.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;

import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.dialogue.back.backpressdialogue.R;
import com.dialogue.back.backpressdialogue.model.AppItems;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ImageView mIcon;
    private TextView mName;
    ArrayList<AppItems> appItems;
    Context context;

    public RecyclerAdapter(ArrayList<AppItems> appItems, Context context) {
     this.appItems=appItems;
     this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.li_apps,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mIcon.setImageResource(appItems.get(position).getIcon());
        holder.mName.setText(appItems.get(position).getMenuName());

        holder.itemView.setOnClickListener(v -> openUrl(holder.itemView.getContext(), "https://play.google.com/store/apps/details?id=" + appItems.get(position).getPackageName()));
    }
    private static void openUrl(Context context, String url) {
        final CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        final CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }
    @Override
    public int getItemCount() {
        return appItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView mIcon;
        private TextView mName;
        public ViewHolder(View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_name);
            mIcon = itemView.findViewById(R.id.iv_icon);
        }
    }
}
