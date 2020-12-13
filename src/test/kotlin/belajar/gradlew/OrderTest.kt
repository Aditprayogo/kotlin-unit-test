package belajar.gradlew

import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class OrderTest {

    @Test
    @Order(2)
    fun print1() { println("Acip ahoy") }

    @Test
    @Order(value = 1)
    fun print2() { println("Acip ahoy 2") }

}