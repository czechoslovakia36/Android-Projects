package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {



    private lateinit var viewModel:MainActivityViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



//
        viewModel= ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val textView = findViewById<TextView>(R.id.count_text)
        val btn= findViewById<Button>(R.id.button)
        textView.text= viewModel.getCurrentCount().toString()
        btn.setOnClickListener{
//            count++
//            textView.text= count.toString()
            textView.text= viewModel.getUpdatedCount().toString()
        }


    }
}