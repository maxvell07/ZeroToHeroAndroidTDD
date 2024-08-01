package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay

interface Repository {
    suspend fun  load():SimpleResponse
    class Base(val service:SimpleService,val url: String) : Repository {
        override suspend fun load():SimpleResponse {
            delay(1500)
            return service.fetch(url)
        }
    }
}