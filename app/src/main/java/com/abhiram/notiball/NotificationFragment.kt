package com.abhiram.notiball

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment

class NotificationFragment : Fragment() {
    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val channelId = "notiball"
    private val description = "Test notification"

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val inflate = inflater.inflate(R.layout.fragment_notification, container, false)
        val channel = NotificationChannel("notiball",
            "NotiBall",
            NotificationManager.IMPORTANCE_HIGH)
        notificationManager =
            requireActivity().getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val btn: Button = inflate.findViewById(R.id.button)
        btn.setOnClickListener {
            // checking if android version is greater than oreo(API 26) or not
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                notificationChannel =
                    NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationChannel.enableLights(true)
                notificationChannel.lightColor = Color.GREEN
                notificationChannel.enableVibration(false)
                notificationManager.createNotificationChannel(notificationChannel)

                builder = Notification.Builder(context, channelId)
                    .setSmallIcon(com.google.android.material.R.drawable.ic_clock_black_24dp)
                    .setLargeIcon(BitmapFactory.decodeResource(this.resources,
                        R.drawable.ic_launcher_background))
                    .setContentText("Hey From NotiBall")
                    .setContentTitle("NotiBall")

                notificationManager.notify(1234, builder.build())
            }

        }
        return inflate
    }
}