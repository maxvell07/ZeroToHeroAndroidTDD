package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var text:TextView
    var bool:Boolean=true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var count:Count=Count.Base(2,4)
        var actual:UiState
        text =findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)
        button.isEnabled=bool;
        button.setOnClickListener {
            actual = count.increment(text.text.toString())
            text.text=actual.geter()
            if (actual.ismax()){
                button.isEnabled=false;
            }
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        apply {
            outState.putBoolean(KEY, button.isEnabled)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
            button.isEnabled=savedInstanceState.getBoolean(KEY);
        }

    companion object {
        private const val KEY = "KEY"
    }
}