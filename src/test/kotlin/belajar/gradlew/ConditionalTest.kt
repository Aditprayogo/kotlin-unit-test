package belajar.gradlew

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.*

class ConditionalTest {

    @Test
    @EnabledOnOs(value = [OS.LINUX])
    fun testOnLinux() {
        //only run on linux
    }

    @Test
    @DisabledOnOs(value = [OS.LINUX])
    fun disabledForLinux() {
        //disable for linux
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    fun onlyOnJava8() {
        //only run for java 8
    }

    @Test
    @DisabledOnJre(JRE.JAVA_11)
    fun disabledOnJava8(){}

    @Test
    @EnabledForJreRange(min = JRE.JAVA_8, max = JRE.JAVA_14)
    fun enableFromJava9to11() {}

}