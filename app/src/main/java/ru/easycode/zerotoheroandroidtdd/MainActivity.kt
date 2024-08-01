package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel:MainViewModel
    private lateinit var actionButton: Button
    private lateinit var titleTextView: TextView
    private lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel= (application as App).viewModel
        setContentView(binding.root)
        actionButton = binding.actionButton
        titleTextView = binding.titleTextView
        progressBar = binding.progressBar

        actionButton.setOnClickListener {
            viewModel.load()
        }
        viewModel.liveData().observe(this){
            it.apply(titleTextView,actionButton,progressBar)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.restore(BundleWrapper.Base(savedInstanceState))
    }

}