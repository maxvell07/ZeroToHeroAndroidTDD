package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable
import java.lang.IllegalStateException

interface UiState {
    fun geter (): String
    fun ismax():Boolean
    data class Base(var text: String) :UiState {
        var outtext=text
        val bool:Boolean=false;
          override fun geter(): String {
              return outtext
          }

        override fun ismax(): Boolean {
            return bool
        }
    }
     data class Max(val text: String):UiState  {
         var outtext= text
         val bool:Boolean=true;
         override fun geter(): String {
             return outtext
         }
         override fun ismax(): Boolean {
             return bool
         }
     }
}