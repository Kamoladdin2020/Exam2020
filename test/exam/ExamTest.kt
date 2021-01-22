package exam

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExamTest {

    @Test
    fun testExample() {
        assertEquals(42, example("input/example.txt"))
    }


    @Test
    fun atmPressure() {
        assertEquals("01.01:778, 09.04:777", atmPressure("input/pressure.txt", "x < next"))
    }
}