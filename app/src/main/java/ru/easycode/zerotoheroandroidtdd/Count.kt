package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException

interface Count {
    fun increment(number: String): UiState
    data class Base(val step: Int,val max: Int) : Count {
        val mystep = step
        val maximum=max
        init { //Блок инициализации (init блок) — это блок кода, который обязательно выполняется при создании объекта
            if (step<=0){
                throw IllegalStateException ("step should be positive, but was ${mystep}")
            }else if(max<=0){
                throw IllegalStateException ("max should be positive, but was ${maximum}")
            }else if (max<step){
                throw IllegalStateException ("max should be more than step")
            } }

        override fun increment(number: String):UiState {
            val res:String = (number.toInt() + mystep).toString()
            if (number.toInt() == maximum){
                val result:UiState= UiState.Max(number)
                return result
            }
            if ( res.toInt() == max || (max-res.toInt()) < step ){
                val result:UiState= UiState.Max(res)
                return result
            }
            val result:UiState= UiState.Base(res)
            return result
        }

    }


}