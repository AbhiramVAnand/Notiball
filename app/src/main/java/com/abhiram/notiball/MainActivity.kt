package com.abhiram.notiball

import android.app.Notification
import android.content.Context
import android.graphics.drawable.Icon
import android.net.ConnectivityManager
import android.os.Build
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.nio.channels.Channel
import java.util.*


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frag_view, NotificationFragment()).addToBackStack("Path").commit()
    }
}