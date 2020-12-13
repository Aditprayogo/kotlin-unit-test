package belajar.gradlew

import belajar.gradlew.resolver.RandomParameterResolver
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.Extensions

@Extensions(value = [
    ExtendWith(RandomParameterResolver::class)
])
abstract class ParentRandomCalculatorTest {

    val calculator = Callculator()

    @Test
    @BeforeEach
    fun beforeEach() {
        println("Before each")
    }

}