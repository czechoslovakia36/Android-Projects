package com.example.clapapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import androidx.core.os.postDelayed
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private  var mediaPlayer:MediaPlayer?= null

    private lateinit var seekBar: SeekBar

    private lateinit var runnable: Runnable

    private  lateinit var  handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this,R.raw.clapping)
        seekBar= findViewById(R.id.sbClapping)
        handler= Handler(Looper.getMainLooper());

        val playButton = findViewById<FloatingActionButton>(R.id.fabPlay)
        playButton.setOnClickListener{
            if(mediaPlayer==null){
                mediaPlayer = MediaPlayer.create(this,R.raw.clapping)
                initializeSeekBar()
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
            handler.removeCallbacks(runnable)
            seekBar.progress=0;

        }







//        val button = findViewById<Button>(R.id.btnClap)
//
//        button.setOnClickListener{
//            mediaPlayer.start()
//        }


    }

    private  fun initializeSeekBar(){
        seekBar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{


            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
                if(fromUser) mediaPlayer?.seekTo(progress)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                TODO("Not yet implemented")
            }
        })
        val tvPlayed= findViewById<TextView>(R.id.tvPlayed)
        val tvDue= findViewById<TextView>(R.id.tvDue)


        seekBar.max= mediaPlayer!!.duration
        runnable= Runnable {


                seekBar.progress= mediaPlayer!!.currentPosition

            val playedTime = mediaPlayer!!.currentPosition/1000
            tvPlayed.text="$playedTime sec"
            val duration= mediaPlayer!!.duration/1000
            val dueTime = duration-playedTime
            tvDue.text="$dueTime sec"
            handler.postDelayed(runnable,1000)
        }
        handler.postDelayed(runnable,1000)


    }
}