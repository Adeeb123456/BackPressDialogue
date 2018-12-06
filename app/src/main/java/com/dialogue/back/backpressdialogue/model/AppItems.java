package com.dialogue.back.backpressdialogue.model;

import android.support.annotation.DrawableRes;

/**
 * Created by SSS on 10/3/2017.
 */

public class AppItems {
    int id;
    @DrawableRes
    int icon;
    String menuName;
    private String packageName;

    public AppItems(int id, int icon, String menuName) {
        this.id = id;
        this.icon = icon;
        this.menuName = menuName;
    }

    public AppItems(int id, int icon, String menuName, String packageName) {
        this.id = id;
        this.icon = icon;
        this.menuName = menuName;
        this.packageName = packageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @DrawableRes
    public int getIcon() {
        return icon;
    }

    public void setIcon(@DrawableRes int icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
