package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var text: TextView
    lateinit var butt:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count: Count = Count.Base(2)
        var num="0"
        butt = findViewById(R.id.incrementButton)
        text =findViewById(R.id.countTextView)
        butt.setOnClickListener {
            text.text = count.increment(text.text.toString())
        }
    }
}