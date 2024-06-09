package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException

interface Count {
    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max <= 0) throw IllegalStateException("max should be positive, but was $max")
            if (step > max) throw IllegalStateException("max should be more than step")
        }

        override fun increment(number: String): UiState {
            val futureValue = number.toInt() + step
            return if (futureValue + step > max) UiState.Max(futureValue.toString()) else UiState.Base(
                futureValue.toString()
            )
        }
    }

}