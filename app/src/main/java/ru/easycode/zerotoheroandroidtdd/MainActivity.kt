package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private val KEY = "KEY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel= (application as App).viewModel
        val button = findViewById<Button>(R.id.actionButton)
        val textView = findViewById<TextView>(R.id.titleTextView)
        val progressbar = findViewById<ProgressBar>(R.id.progressBar)
    button.setOnClickListener {
        viewModel.load()
    }
    viewModel.liveData().observe(this){
        it.apply(textView, button, progressbar)
    }

    }
//  Bad Solution
//    companion object SaveLiveData {
//        private val SaveData = LiveDataWrapper.Base()
//
//    }
override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putSerializable("KEY",LiveDataWrapper.Base())
}

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)

//        if (savedInstanceState != null) {
//            SaveData = savedInstanceState.getSerializable(KEY) as LiveDataWrapper.Base
//        }
    }

}