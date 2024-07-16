package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {

    fun apply(textView: TextView, button: Button, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            textView.visibility= View.GONE
            progressBar.visibility= View.VISIBLE
            button.isEnabled=false
        }

    }

    object ShowData : UiState {
        override fun apply(textView: TextView, button: Button, progressBar: ProgressBar) {
            textView.visibility= View.VISIBLE
            progressBar.visibility= View.GONE
            button.isEnabled=true
        }

    }

}