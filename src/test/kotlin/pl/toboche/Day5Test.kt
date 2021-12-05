package pl.toboche

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day5Test {
    @Test
    internal fun task1Example() {
        val input = File("src/test/resources/day5Example1.txt")
            .readLines()

        assertEquals(5,
            Day5().task1(input))
    }

    @Test
    internal fun mapLine() {
        assertEquals((0 to 9) to (5 to 9),
            Day5().mapLine("0,9 -> 5,9"))
    }
}