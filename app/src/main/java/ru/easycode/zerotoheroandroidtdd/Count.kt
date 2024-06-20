package ru.easycode.zerotoheroandroidtdd
import android.util.Log
import java.lang.IllegalStateException

interface Count {
    fun increment(number: String): UiState
    fun initial(number: String): UiState
     fun decrement(number: String): UiState

    class Base(private val step: Int, private val max: Int, private val min: Int) : Count {

        init {
            if (step <= 0) throw IllegalStateException("step should be positive, but was $step")
            if (max <= 0) throw IllegalStateException("max should be positive, but was $max")
            if (step > max) throw IllegalStateException("max should be more than step")
            if (max < min) throw IllegalStateException("max should be more than min")
        }
        override fun initial(number: String): UiState {
            if ( number.toInt() == max){return UiState.Max(number)}
            else if (number.toInt() ==min) { return UiState.Min(number) }
            else {return UiState.Base(number)}
        }

        override fun increment(number: String): UiState {
            val futureValue = number.toInt() + step
//            return if (futureValue + step > max) UiState.Max(futureValue.toString()) else UiState.Base(
//                futureValue.toString()
//            )
            return initial(futureValue.toString())
        }

        override fun decrement(number: String): UiState {
            val futureValue = number.toInt() - step
//            return if ((futureValue - step > min)||(futureValue <=min)) UiState.Min(futureValue.toString()) else UiState.Base(
//                futureValue.toString()
//            )
            return initial(futureValue.toString())
        }
    }

}