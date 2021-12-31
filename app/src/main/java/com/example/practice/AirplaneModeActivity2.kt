package com.example.practice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class AirplaneModeActivity2 : AppCompatActivity() {
    val intentFilter = IntentFilter("android.intent.action.AIRPLANE_MODE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_airplane_mode2)

        val receiver: BroadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                Log.d("AirplaneMode", "Service state changed")
            }
            if(Settings.System.getInt(context.getContentResolver(), Settings.Global.AIRPLANE_MODE_ON, 0)== 0)
            {
                val context = null
                Toast.makeText(context, "AIRPLANE MODE Off", Toast.LENGTH_SHORT).show();
            }
            else
            {
                val context = null
                Toast.makeText(context, "AIRPLANE MODE On", Toast.LENGTH_SHORT).show();
            }
        }

        val context = null
        with(context) {
            registerReceiver(receiver, intentFilter)
        }

    }
    }
}