package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.Serializable

interface LiveDataWrapper {
    fun update(value: UiState)
    fun liveData(): LiveData<UiState>

    fun save(bundleWrapper: BundleWrapper.Save)

    class Base(
        private val liveData: MutableLiveData<UiState> = MutableLiveData()
    ) : LiveDataWrapper, Serializable {

        override fun update(value: UiState) {
            liveData.value=value
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it) }
    }
    }
}