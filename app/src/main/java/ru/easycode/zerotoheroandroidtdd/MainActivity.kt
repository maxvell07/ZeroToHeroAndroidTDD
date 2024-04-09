package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var butt:Button
    lateinit var text:TextView
    lateinit var linerlayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linerlayout = findViewById(R.id.rootLayout)
        butt = findViewById(R.id.removeButton)
        text = findViewById(R.id.titleTextView)
        butt.setOnClickListener {
            linerlayout.removeView(text)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedview = linerlayout.childCount == 1
        outState.putBoolean(KEY, removedview)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean(KEY)){
            linerlayout.removeView(text)
        }
    }

    companion object {
        private const val KEY="KEY1"
    }
}