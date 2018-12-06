package com.dialogue.back.backpressdialogue.adapter.holder;


import android.content.Context;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dialogue.back.backpressdialogue.R;
import com.dialogue.back.backpressdialogue.model.AppItems;


public class MenuItemHolderExit extends BaseItemHolder<AppItems> {

    private ImageView mIcon;
    private TextView mName;


    public MenuItemHolderExit(View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_name);
        mIcon = itemView.findViewById(R.id.iv_icon);

    }

    private static void openUrl(Context context, String url) {
        final CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorPrimary));
        final CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(context, Uri.parse(url));
    }

    @Override
    public void bindData(AppItems object, int position, int size) {

        super.bindData(object, position, size);

        mIcon.setImageResource(mObject.getIcon());
        mName.setText(mObject.getMenuName());


        itemView.setOnClickListener(v -> openUrl(itemView.getContext(), "https://play.google.com/store/apps/details?id=" + mObject.getPackageName()));
    }
}
