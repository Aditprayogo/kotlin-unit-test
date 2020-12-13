package belajar.gradlew

import java.lang.IllegalArgumentException

class Callculator {

    fun addData(data1: Int, data2: Int): Int {
        return data1 + data2
    }

    fun minusData(data1 : Int, data2: Int) : Int {
        return data1 - data2
    }

    fun devide(first: Int, second: Int) : Int {
        if (second.equals(0)) {
            throw IllegalArgumentException("Tidak bisa di bagi nol")
        }else {
            return first / second
        }
    }

}