package ru.easycode.zerotoheroandroidtdd

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleService {

@GET("{url}")
suspend fun fetch(@Path(value="url",encoded = true) url:String):SimpleResponse
}

data class SimpleResponse(@SerializedName("text") private val text: String) {
    fun getText() = text
}
