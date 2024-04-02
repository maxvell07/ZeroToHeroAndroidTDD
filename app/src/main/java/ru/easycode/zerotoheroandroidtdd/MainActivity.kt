package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var butt: Button
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        butt=findViewById(R.id.changeButton)
        text=findViewById(R.id.titleTextView)
        Clicker()
    }
    fun Clicker(){
        butt.setOnClickListener{
            text.setText("I am an Android Developer!")
        }
    }
}