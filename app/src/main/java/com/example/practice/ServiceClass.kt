package com.example.practice

import android.app.Service
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceClass : Service()  {
    override fun onBind(intent: Intent?): Int {
        val datastring= intent?.getStringExtra("ExtraData")
        datastring?.let{
            Log.d(TAG,datastring)
        }
        Thread{
            while (true){}
        }.start()
        Log.d(TAG,"Service has been Started")
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"Service has been Destroyed")
    }
}
    }
}