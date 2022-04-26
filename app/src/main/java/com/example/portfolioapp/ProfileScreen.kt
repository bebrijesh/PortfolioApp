package com.example.portfolioapp

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileScreen : AppCompatActivity() {

    var downloadID: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val resumeButton = findViewById(R.id.button_resume) as Button
        resumeButton.setOnClickListener {
            var request =
                DownloadManager.Request(Uri.parse("https://drive.google.com/drive/u/0/folders/19SMf1Fkqmj2aHFX9C-RJiDn9H9SaT4zw"))
                    .setTitle("Brijeshkumar Chavda")
                    .setDescription("Brijeshkumar Chavda Resume")
                    .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)

            var downloadManager: DownloadManager =
                getSystemService(DOWNLOAD_SERVICE) as DownloadManager
            downloadManager.enqueue(request)
        }
        var br = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, p1: Intent?) {
                var id: Long? = p1?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (id == downloadID) {
                    Toast.makeText(
                        applicationContext,
                        "Resume Download Successfully",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
        registerReceiver(br, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))
    }

}