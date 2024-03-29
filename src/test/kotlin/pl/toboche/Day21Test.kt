package pl.toboche

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class Day21Test {
    @Test
    internal fun task1Example() {
        assertEquals(
            135,
            Day21().task1(4, 8, 19)
        )
    }

    @Test
    internal fun task1Example2() {
        assertEquals(
            336,
            Day21().task1(4, 8, 25)
        )
    }

    @Test
    internal fun task1Example3() {
        assertEquals(
            739785,
            Day21().task1(4, 8, 1000)
        )
    }

    @Test
    internal fun task1() {
        assertEquals(
            888735,
            Day21().task1(4, 6, 1000)
        )
    }

    @Test
    internal fun task2Example() {
        assertEquals(
            444356092776315,
            Day21().task2(4, 8, 21)
        )
    }

    @Test
    internal fun task2() {
        assertEquals(
            647608359455719,
            Day21().task2(4, 6, 21)
        )
    }
}