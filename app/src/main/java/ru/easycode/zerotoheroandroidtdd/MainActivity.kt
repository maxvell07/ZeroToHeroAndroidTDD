package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var text:TextView
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text=findViewById(R.id.titleTextView)
        button=findViewById(R.id.hideButton)
        button.setOnClickListener {
            text.visibility=View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState) // сохранение состояния текста в Bundle
        outState.putInt("KEY",text.visibility) // добавили в мапу значение и ключ
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState) // при востановлении процесса мы вернули
        text.visibility = savedInstanceState.getInt("KEY") // сброшенные параметры
    }
//companion object {
//    private const val KEY ="visibilitykey" просто объект с ключом
//}
}
