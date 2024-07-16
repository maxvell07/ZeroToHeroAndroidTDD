package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import kotlinx.coroutines.delay

interface Repository {
    suspend fun load()
    class Base: Repository {
        override suspend fun load() {
            delay(1500)
        }
    }
}