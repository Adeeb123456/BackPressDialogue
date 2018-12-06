package com.dialogue.back.backpressdialogue;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;


import com.dialogue.back.backpressdialogue.adapter.BaseRecyclerAdapter;
import com.dialogue.back.backpressdialogue.adapter.RecyclerAdapter;
import com.dialogue.back.backpressdialogue.adapter.holder.MenuItemHolderExit;
import com.dialogue.back.backpressdialogue.model.AppItems;

import java.util.ArrayList;

public class DialogueUtil {



    public static void showExitDialogue(Activity activity){
        AlertDialog.Builder builder =new AlertDialog.Builder(activity);
        boolean[] check = new boolean[1];
        builder.setPositiveButton("Yes",(dialog,which)->{
            activity.finish();
            if (check[0]) {
                TinyDB.getInstance(activity).putBoolean("dialog_status", true);
            } else {
                TinyDB.getInstance(activity).putBoolean("dialog_status", false);
            }

        }).setNegativeButton("No",(dialog,which)->{



        });


        AlertDialog alertDialog = builder.create();

        View dialogueView =activity.getLayoutInflater().inflate(R.layout.dlg_recomended_apps,null);


        BaseRecyclerAdapter<AppItems, MenuItemHolderExit> mAdapter;
        mAdapter = new BaseRecyclerAdapter(R.layout.li_apps, MenuItemHolderExit.class);
        RecyclerView mAppsList = dialogueView.findViewById(R.id.rv_recommended_apps);

        CheckBox checkBox = dialogueView.findViewById(R.id.check_box_ask);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                check[0] = isChecked;
            }
        });
        /*mAppsList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAppsList.setAdapter(mAdapter);
        mAdapter.setData(getRecommendedApps());*/

    mAppsList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mAppsList.setAdapter(new RecyclerAdapter(getRecommendedApps(),activity));


        alertDialog.setView(dialogueView);
        alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        alertDialog.show();

        Button b = alertDialog.getButton(DialogInterface.BUTTON_NEGATIVE);
        b.setTextColor(ContextCompat.getColor(activity, R.color.colorAccent));
        b = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        b.setTextColor(ContextCompat.getColor(activity, R.color.colorAccent));


        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                activity.finish();
            }
        });


    }




    private static ArrayList<AppItems> getRecommendedApps() {
        ArrayList<AppItems> list = new ArrayList<>();
        list.add(new AppItems(-1, R.drawable.ic_launcher_background, "\t\n" +
                "appName", "pkgename"));
        list.add(new AppItems(-2, R.drawable.ic_launcher_background, "AppName", "PkgName"));

        return list;
    }

}
