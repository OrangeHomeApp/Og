package com.orange.blelibrary.blelibrary;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.orange.blelibrary.R;
import com.orange.blelibrary.blelibrary.Adapter.SelectBle;
import com.orange.blelibrary.blelibrary.EventBus.SerchDevice;
import com.orange.blelibrary.blelibrary.Server.ScanDevice;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;


public class ScanBle extends AppCompatActivity {
    ArrayList<BluetoothDevice> ble=new ArrayList<>();
    SelectBle selectBle=new SelectBle(ble,this);
   public ScanDevice scan=new ScanDevice();
    RecyclerView re;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_ble);
        re=findViewById(R.id.re);
        re.setLayoutManager(new LinearLayoutManager(this));
        re.setAdapter(selectBle);
        scan.setmBluetoothAdapter(this);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if(grantResults[0]!=0){
                Toast.makeText(this, "Please enable GPS", Toast.LENGTH_LONG).show();
            }else{ scan.RequestPermission();}
        }
    }
    //----------------------------------------When find Device it will callback on here----------------------------------------
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(SerchDevice a){
        try{
            if(!ble.contains(a.getDevic())&&a.getDevic().getName()!=null){
                ble.add(a.getDevic());
                selectBle.notifyDataSetChanged();}
        }catch (Exception e){
            Log.w("error",e.getMessage());}
    }
    public void close(View view){
        scan.scanLeDevice(false);
        this.finish();
    }
    @Override
    public void onBackPressed() {
        scan.scanLeDevice(false);
        this.finish();
    }

}
