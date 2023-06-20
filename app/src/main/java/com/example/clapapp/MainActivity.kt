package com.example.clapapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var mediaPlayer:MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this,R.raw.clapping)

        val playButton = findViewById<FloatingActionButton>(R.id.fabPlay)
        playButton.setOnClickListener{

        }

        val pauseButton = findViewById<FloatingActionButton>(R.id.fabPause)
        pauseButton.setOnClickListener{

        }

        val stopButton = findViewById<FloatingActionButton>(R.id.fabStop)
        stopButton.setOnClickListener{

        }




//        val button = findViewById<Button>(R.id.btnClap)
//
//        button.setOnClickListener{
//            mediaPlayer.start()
//        }


    }
}