package belajar.gradlew

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito

class MockTest {

    @Test
    fun testMock() {

        //create mocking
        val list : List<String> = Mockito.mock(List::class.java) as List<String>

        Mockito.`when`(list.get(0)).thenReturn("Aditiya")
        Mockito.`when`(list.get(1)).thenReturn("Ihzar")

        Assertions.assertEquals("Aditiya", list.get(0))
        Assertions.assertEquals("Ihzar", list.get(1))

        //verify mock
        Mockito.verify(list, Mockito.times(1)).get(0)
        Mockito.verify(list, Mockito.times(1)).get(1)

    }

}