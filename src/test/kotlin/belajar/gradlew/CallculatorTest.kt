package belajar.gradlew

import org.junit.jupiter.api.*
import org.opentest4j.TestAbortedException
import java.lang.IllegalArgumentException

@DisplayName("Test for callculator class")
class CallculatorTest {

    val callculator = Callculator()

    companion object {

        @BeforeAll
        @JvmStatic
        fun beforeAll() {
            println("Sebelum semua unit test di eksekusi")
        }

        @AfterAll
        @JvmStatic
        fun afterAll() {
            println("Setelah semua unit test di eksekusi")
        }
    }

    @BeforeEach
    fun beforeEach() {
        println("Sebelum setiap unit test")
    }

    @AfterEach
    fun afterEach() {
        println("Setelah setiap unit test")
    }

    @Test
    @DisplayName("Add success addData(12,12)")
    fun addSuccess() {
        println("ini unit test addSuccess")
        val result = callculator.addData(12,12)
        Assertions.assertEquals(24, result, "Harusnya hasilnya 24")
    }

    @Test
    fun addDataSuccess2() {
        println("ini unit test addDataSuccess2")
        val result = callculator.addData(24,24)
        Assertions.assertEquals(48, result, "Harusnya hasilnya 24")
    }

    @Test
    fun minusDataSuccess() {
        println("ini unit test minusDataSuccess")
        val result = callculator.minusData(12, 12)
        Assertions.assertEquals(0, result)
    }

    @Test
    fun testDevideSuccess() {
        println("ini unit test testDevideSuccess")
        val result = callculator.devide(100, 10)
        Assertions.assertEquals(10, result)
    }

    @Test
    @Disabled
    fun testDeviceFail() {
        assertThrows<IllegalArgumentException> { callculator.devide(100,0) }
    }

    @Test
    fun testAborted() {
        val systemEnv = System.getenv()["PROFILE"]
        if ("DEV" != systemEnv) {
            throw TestAbortedException()
        }

        println("Test is not aborted becouse profile is dev")
    }

    /**
     * Execute if assumption is dev
     */
    @Test
    fun testAssumptionsTrue() {
        Assumptions.assumeTrue("DEV" == System.getenv()["PROFILE"])
    }

    @Test
    fun testAssumptionsFalse() {
        Assumptions.assumeTrue("DEV" != System.getenv()["PROFILE"])
    }

}