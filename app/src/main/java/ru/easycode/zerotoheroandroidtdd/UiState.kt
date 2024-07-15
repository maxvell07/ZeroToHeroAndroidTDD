package ru.easycode.zerotoheroandroidtdd

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(button: Button, textView: TextView, progressBar: ProgressBar)

    object ShowProgress: UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            button.isEnabled = false
            progressBar.visibility = VISIBLE
        }
    }

    object ShowData: UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            button.isEnabled = true
            progressBar.visibility = GONE
            textView.visibility = VISIBLE
        }
    }
}