package ru.easycode.zerotoheroandroidtdd


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    lateinit var butt: Button
    lateinit var text: TextView
    lateinit var linerlayout: LinearLayout
    private var state: State = State.Initial
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linerlayout = findViewById(R.id.rootLayout)
        butt = findViewById(R.id.removeButton)
        text = findViewById(R.id.titleTextView)
        butt.setOnClickListener {
            state = State.Remove
            state.apply(linerlayout, text)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        apply { outState.putSerializable(KEY, state) }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            state = savedInstanceState.getSerializable(KEY, State::class.java) as State
        } else {
            state = savedInstanceState.getSerializable(KEY) as State
        }
        state.apply(linerlayout,text)
    }

    interface State : Serializable {
        fun apply(linearLayout: LinearLayout, textView: TextView)

        object Initial : State {
            override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit
        }

        object Remove : State {
            override fun apply(linearLayout: LinearLayout, textView: TextView) {
                linearLayout.removeView(textView)
            }
        }
    }
    companion object {
        private const val KEY = "KEY1"
    }
}