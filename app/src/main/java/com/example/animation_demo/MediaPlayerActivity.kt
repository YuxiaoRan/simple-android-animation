package com.example.animation_demo

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_media_player.*
import java.io.IOException

class MediaPlayerActivity : AppCompatActivity(), SurfaceHolder.Callback {

    val player: MediaPlayer = MediaPlayer()
    lateinit var holder: SurfaceHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)

        try {
            player.setDataSource(resources.openRawResourceFd(R.raw.randvidp1))
            holder = surfaceView.holder
            holder.addCallback(this)
            player.prepare()
            player.setOnPreparedListener {
                player.start()
                player.isLooping = true
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    override fun surfaceCreated(p0: SurfaceHolder) {
        player.setDisplay(holder)
    }

    override fun surfaceChanged(p0: SurfaceHolder, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder) {
    }
}