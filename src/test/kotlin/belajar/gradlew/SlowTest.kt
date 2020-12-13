package belajar.gradlew

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import java.util.concurrent.TimeUnit

@Execution(ExecutionMode.CONCURRENT)
class SlowTest {

    /**
     * TImeout on test
     */
    @Test
    @Timeout(
            value = 5,
            unit = TimeUnit.SECONDS
    )
    fun timeTest1() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(
            value = 5,
            unit = TimeUnit.SECONDS
    )
    fun timeTest2() {
        Thread.sleep(3000)
    }

    @Test
    @Timeout(
            value = 5,
            unit = TimeUnit.SECONDS
    )
    fun timeTest3() {
        Thread.sleep(3000)
    }

}