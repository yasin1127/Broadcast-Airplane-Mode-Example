package com.example.broadcastreceiver

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val airplaneModeChangeReceiver=AirplaneModeChangeReceiver()
    private val exampleBroadcast= ExampleBroadcast()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerReceiver(exampleBroadcast, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))

        registerReceiver(airplaneModeChangeReceiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))


    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(airplaneModeChangeReceiver)
        unregisterReceiver(exampleBroadcast)
    }

}