package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count =0

    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val textView= findViewById<TextView>(R.id.tvCount)
        val button = findViewById<Button>(R.id.btnCount)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        textView.text= viewModel.count.toString()

        button.setOnClickListener{
//            ++count
//            textView.text= count.toString()

            viewModel.updateCount()
            textView.text=viewModel.count.toString()

        }
    }
}