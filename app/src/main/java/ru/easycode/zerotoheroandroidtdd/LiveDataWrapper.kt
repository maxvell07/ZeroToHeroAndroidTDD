package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.Serializable

interface LiveDataWrapper:Serializable {
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper {

        override fun update(value: UiState) {
            liveData.value=value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}