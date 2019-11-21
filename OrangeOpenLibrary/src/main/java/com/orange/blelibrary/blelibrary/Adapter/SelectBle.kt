package com.orange.blelibrary.blelibrary.Adapter;


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


class SelectBle(private val a:ArrayList<BluetoothDevice>, private val scanner: ScanBle)
    : RecyclerView.Adapter<SelectBle.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.selectble, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(a[position].name==null){holder.device.text="Unknown Device"}else{holder.device.text=a[position].name}

        holder.address.text=a[position].address
        holder.mView.setOnClickListener(View.OnClickListener {
            EventBus.getDefault().post(ConnectBle(a[position].address))
            scanner.scan.scanLeDevice(false)
            scanner.finish()
        })
    }

    override fun getItemCount(): Int = a.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val device: TextView = mView.findViewById(R.id.textView)
        val address: TextView = mView.findViewById(R.id.textView2)
        override fun toString(): String {
            return super.toString() + " ''"
        }
    }
}