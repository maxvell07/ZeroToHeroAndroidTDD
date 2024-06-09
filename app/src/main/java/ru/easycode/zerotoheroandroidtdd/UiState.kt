package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable
import java.lang.IllegalStateException

interface UiState : Serializable {

    fun apply(button: Button, textView: TextView)

    data class Base(val text: String) : UiState {
        override fun apply(button: Button, textView: TextView) {
            textView.text = text
        }
    }

    data class Max(val text: String) : UiState {
        override fun apply(button: Button, textView: TextView) {
            textView.text = text
            button.isEnabled = false
        }
    }
}