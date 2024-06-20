package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val counter: Count = Count.Base(2, 4, 0)

    private lateinit var state: UiState
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.incrementButton)
        button2 = findViewById(R.id.decrementButton)
        textView= findViewById(R.id.countTextView)

        button1.setOnClickListener {
            state = counter.increment(textView.text.toString())
            state.apply(button1,button2,textView)
        }
        button2.setOnClickListener {
            state = counter.decrement(textView.text.toString())
            state.apply(button1,button2,textView)
        }
        if (savedInstanceState == null) {
            state= counter.initial(textView.text.toString())
            state.apply(button1,button2,textView)
        }
    }

    companion object {
        private const val KEY = "key"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY) as UiState // лучше добавить if else TIRAMISU
        state.apply(button1,button2,textView)
        }
}