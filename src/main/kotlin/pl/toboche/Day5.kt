package pl.toboche

class Day5 {
    fun task1(input: List<String>) = task(input)

    fun task2(input: List<String>) = task(input, false)

    private fun task(input: List<String>, filterDiagonals: Boolean = true) = input.asSequence()
        .map {
            mapLine(it)
        }
        .filter {
            when {
                filterDiagonals -> it.first.first == it.second.first
                        || it.first.second == it.second.second
                else -> true
            }
        }
        .map { allPoints(it) }
        .flatten()
        .fold<Pair<Int, Int>, MutableMap<Pair<Int, Int>, Int>>(mutableMapOf()) { acc, point ->
            acc.compute(point) { key, value ->
                (value ?: 0) + 1
            }
            acc
        }
        .filter { pointEntry -> pointEntry.value >= 2 }
        .count()

    private fun allPoints(edges: Pair<Pair<Int, Int>, Pair<Int, Int>>): List<Pair<Int, Int>> {
        val (x1, y1) = edges.first
        val (x2, y2) = edges.second
        return if (x1 == x2) {
            (y1 toward y2).map { y ->
                x1 to y
            }
        } else if (y1 == y2) {
            (x1 toward x2).map { x ->
                x to y1
            }
        } else {
            (x1 toward x2)
                .zip(y1 toward y2)
        }
    }

    private infix fun Int.toward(to: Int): IntProgression {
        val step = if (this > to) -1 else 1
        return IntProgression.fromClosedRange(this, to, step)
    }

    internal fun mapLine(it: String): Pair<Pair<Int, Int>, Pair<Int, Int>> = it.split(" -> ")
        .map { points ->
            points.split(",")
                .map { point -> point.toInt() }
                .let { point ->
                    point[0] to point[1]
                }
        }
        .let { points ->
            points[0] to points[1]
        }
}