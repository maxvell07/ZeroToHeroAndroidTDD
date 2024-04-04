package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var text: TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text= findViewById(R.id.titleTextView)
        button= findViewById(R.id.changeButton)
        button.setOnClickListener {
            text.setText("I am an Android Developer!")
        }
    }
}