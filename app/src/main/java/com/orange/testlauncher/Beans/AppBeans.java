package com.orange.testlauncher.Beans;

import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.List;

public class AppBeans {
    public ArrayList<String> image = new ArrayList<String>();
    public ArrayList<String> tit = new ArrayList<String>();
    public ArrayList<String> name = new ArrayList<String>();
    public List<ResolveInfo> app= new ArrayList<ResolveInfo>();
    public void AddItems(String image, String tit, String name) {
        this.image.add(image);
        this.tit.add(tit);
        this.name.add(name);
    }
    public void clear(){
        image.clear();
        tit.clear();
        name.clear();
    }
}
