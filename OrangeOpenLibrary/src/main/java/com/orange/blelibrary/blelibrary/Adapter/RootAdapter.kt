package com.orange.blelibrary.blelibrary.Adapter

import android.bluetooth.BluetoothDevice
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.orange.blelibrary.R
import com.orange.blelibrary.blelibrary.EventBus.ConnectBle
import com.orange.blelibrary.blelibrary.ScanBle
import org.greenrobot.eventbus.EventBus
import java.util.ArrayList

 open class RootAdapter(val layout:Int) : RecyclerView.Adapter<RootAdapter.ViewHolder>() {
    var size=0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        override fun toString(): String {
            return super.toString() + " ''"
        }
    }
}