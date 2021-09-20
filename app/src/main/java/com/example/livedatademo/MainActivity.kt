package com.example.livedatademo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    private val factsTextView: TextView
        get() = findViewById(R.id.factsTextView)

    private val btnUpdate: Button
        get() = findViewById(R.id.btnUpdate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        // Observer the live data of MainViewModel class
        mainViewModel.liveData.observe(this, Observer {
            //Toast.makeText(this, "Hello world", Toast.LENGTH_LONG).show()
            factsTextView.text = it
        })

        btnUpdate.setOnClickListener {
            mainViewModel.updateLiveData()
        }

    }
}