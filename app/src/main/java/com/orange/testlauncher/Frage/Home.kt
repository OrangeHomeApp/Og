package com.orange.testlauncher.Frage


import android.content.Intent
import android.content.pm.ResolveInfo
import android.content.res.Resources
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.orange.blelibrary.blelibrary.RootFragement
import com.orange.testlauncher.Adapter.AppAdapter
import com.orange.testlauncher.Beans.AppBeans

import com.orange.testlauncher.R
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.util.ArrayList

class Home : RootFragement() {
 var appbeans: AppBeans= AppBeans()
    lateinit var adapter:AppAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootview=inflater.inflate(R.layout.fragment_home, container, false)
        adapter= AppAdapter(appbeans)
        rootview.re.layoutManager=GridLayoutManager(act,4)
        rootview.re.adapter=adapter
        loadApps()
        return rootview
    }
    lateinit var mResources: Resources;

    fun loadApps() {
        appbeans.clear()
        val mainIntent =  Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        appbeans.app = act.packageManager.queryIntentActivities(mainIntent, 0);
        Log.e("size",""+appbeans.app.size)
        adapter.notifyDataSetChanged()
    }

}
