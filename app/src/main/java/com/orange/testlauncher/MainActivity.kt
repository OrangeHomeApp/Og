package com.orange.testlauncher

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.orange.blelibrary.blelibrary.BleActivity
import com.orange.testlauncher.Frage.Home

class MainActivity : BleActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
ChangePage(Home(),R.id.frage,"Home",false)
    }
}
