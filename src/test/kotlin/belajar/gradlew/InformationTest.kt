package belajar.gradlew

import org.junit.jupiter.api.*

@DisplayName("Display with name info")
class InformationTest {

    @Test
    @DisplayName("Contoh")
    @Tags(value = [Tag("Contoh1"), Tag("Contoh2")])
    fun testInfo(testInfo: TestInfo) {
        println(testInfo.displayName)
        println(testInfo.tags)
        println(testInfo.testClass)
        println(testInfo.testMethod)
    }

}