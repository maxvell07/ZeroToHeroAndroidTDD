package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    fun save(uiState: UiState)
    fun restore(): UiState

    interface Save:BundleWrapper {
        override fun save(uiState: UiState)
    }

    interface Restore:BundleWrapper {
        override fun restore(): UiState
    }
    interface Mutable: Save, Restore {
    }
    class Base (private val bundle: Bundle):Mutable{
        override fun save(uiState: UiState) {
            bundle.putSerializable("KEY",uiState)
        }

        override fun restore(): UiState {
            return bundle.getSerializable("KEY") as UiState
        }
    }
}