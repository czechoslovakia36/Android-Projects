package com.example.clapapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private  var mediaPlayer:MediaPlayer?= null

    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this,R.raw.clapping)
        seekBar= findViewById(R.id.sbClapping)

        val playButton = findViewById<FloatingActionButton>(R.id.fabPlay)
        playButton.setOnClickListener{
            if(mediaPlayer==null){
                mediaPlayer = MediaPlayer.create(this,R.raw.clapping)
            }
            mediaPlayer?.start()
        }

        val pauseButton = findViewById<FloatingActionButton>(R.id.fabPause)
        pauseButton.setOnClickListener{
                mediaPlayer?.pause()
        }

        val stopButton = findViewById<FloatingActionButton>(R.id.fabStop)
        stopButton.setOnClickListener{
            mediaPlayer?.stop()
            mediaPlayer?.reset()
            mediaPlayer?.release()
            mediaPlayer=null

        }




//        val button = findViewById<Button>(R.id.btnClap)
//
//        button.setOnClickListener{
//            mediaPlayer.start()
//        }


    }

    private  fun initializeSeekBar(){
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{


            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })


    }
}