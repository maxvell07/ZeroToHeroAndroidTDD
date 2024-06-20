package ru.easycode.zerotoheroandroidtdd
import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {

    fun apply(button1: Button,button2: Button, textView: TextView)

    data class Base(val text: String) : UiState {
        override fun apply(button1: Button, button2: Button, textView: TextView) {
            textView.text = text
            button1.isEnabled = true
            button2.isEnabled = true
        }
    }

    data class Max(val text: String) : UiState {
        override fun apply(button1: Button, button2: Button, textView: TextView) {
            textView.text = text
            button1.isEnabled = false
            button2.isEnabled = true
        }
    }

    data class Min(val text: String) : UiState {
        override fun apply(button1: Button, button2: Button, textView: TextView) {
            textView.text = text
            button1.isEnabled = true
            button2.isEnabled = false
        }
    }
}