package ru.easycode.zerotoheroandroidtdd

import java.lang.IllegalStateException

interface Count {
    class Base(step: Int) : Count {
        val mystep = step
        init { //Блок инициализации (init блок) — это блок кода, который обязательно выполняется при создании объекта
            if (step<=0){
                throw IllegalStateException ("шаг должен быть > 0")
            } }

        override fun increment(number: String): String {
            val result:Int = number.toInt() + mystep
            return result.toString()
        }
    }

 abstract fun increment(number: String): String
}