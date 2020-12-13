package belajar.gradlew

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*


class CallculatorRandomParameterTest : ParentRandomCalculatorTest() {

    companion object {

        @JvmStatic
        fun methodSource() : List<Int> {
            return listOf<Int>(10,20,30,40,50)
        }
    }
    /**
     * Test with parameter method source
     */
    @DisplayName("test calculator with parameter method source")
    @ParameterizedTest(
            name = "{displayName} with data {0}"
    )
    @MethodSource("methodSource")
    fun testWithMethodSource(value : Int) {
        assertEquals(value + value, calculator.addData(value, value))
    }

    /**
     * Test parameter with value source
     */
    @DisplayName("test calculator with parameter")
    @ParameterizedTest(
           name = "{displayName} with data {0}"
    )
    @ValueSource(
            ints = [10,20,30,40,50]
    )
    fun testWithValuerSource(value : Int) {
        val result = calculator.addData(value, value)
        println(result)
        assertEquals(value + value, result)
    }

    @Test
    fun testAddRandom(random : Random) {

        val first = random.nextInt(10)
        println(first)
        val second = random.nextInt(10)
        println(second)
        val result = calculator.addData(first,second)

        assertEquals(first + second, result)
    }

    @DisplayName("test-repeat-random")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    fun testRepeatRandom(random : Random) {
        val first = random.nextInt(10).also { println(it) }
        val second = random.nextInt(10).also { println(it) }
        val result = calculator.addData(first, second).also { println(it) }
        assertEquals(first + second, result)
    }

}