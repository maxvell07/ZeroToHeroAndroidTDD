package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button1: Button
    lateinit var textView: TextView
    lateinit var progressbar:ProgressBar
    lateinit var rootLayout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.actionButton)
        textView = findViewById(R.id.titleTextView)
        progressbar = findViewById(R.id.progressBar)
        rootLayout= findViewById(R.id.rootLayout)

        button1.setOnClickListener {
            button1.isEnabled = false
            progressbar.visibility = View.VISIBLE
            button1.postDelayed({
                textView.visibility= View.VISIBLE
                progressbar.visibility=View.GONE
                button1.isEnabled=true
                                },
                3500)

            textView.visibility= View.GONE
        }
    }

}