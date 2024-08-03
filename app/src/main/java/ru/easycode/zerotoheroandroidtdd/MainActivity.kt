package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel:MainViewModel
    lateinit var titleTextView:TextView
    lateinit var actionButton:Button
    lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bindind= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)
        viewmodel= (application as App).viewModel

        titleTextView= bindind.titleTextView
        actionButton=bindind.actionButton
        progressBar= bindind.progressBar

        actionButton.setOnClickListener {
            viewmodel.load()
        }
        viewmodel.liveData().observe(this){
            it.apply(titleTextView, progressBar, actionButton)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewmodel.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle
    ) {
        super.onRestoreInstanceState(savedInstanceState)
        viewmodel.restore(BundleWrapper.Base(savedInstanceState))
    }
}