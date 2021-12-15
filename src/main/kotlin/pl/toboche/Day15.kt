package pl.toboche


typealias Point = Pair<Int, Int>

class Day15 {

    fun task1(input: List<String>): Int {
        val risks = input.map { it.map { it.digitToInt() } }
        val stopNode = risks[0].size to risks.size
        val n = risks[0].size
        val m = risks.size
        val source = Vertex(0, 0)
        val destination = Vertex(n - 1, m - 1)

        val graph1 = Graph.from(risks)

        return dijkstraShortestPathCost(graph1, source, destination)
    }

    fun task2(input: List<String>): Int {
        val risks = input.map { it.map { it.digitToInt() } }
        val stopNode = risks[0].size to risks.size
        val matrix2 = explode(risks, 5)
        val n2 = matrix2[0].size
        val m2 = matrix2.size
        val destination2 = Vertex(n2 - 1, m2 - 1)

        val graph2 = Graph.from(matrix2)

        return dijkstraShortestPathCost(graph2, Vertex(0, 0), destination2)
    }

    fun explode(matrix: List<List<Int>>, steps: Int): List<List<Int>> {
        val down = incrementDown(matrix, steps)
        val result = down as MutableList<MutableList<Int>>
        var curr = down
        repeat(steps - 1) {
            val next = increment(curr)
            for (i in 0 until result.size) {
                result[i].addAll(next[i])
            }
            curr = next
        }
        return result
    }

    private fun incrementDown(matrix: List<List<Int>>, steps: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        var curr = matrix
        result.addAll(curr)
        repeat(steps - 1) {
            val next = increment(curr)
            result.addAll(next)
            curr = next
        }
        return result
    }

    private fun increment(matrix: List<List<Int>>): List<List<Int>> {
        val n = matrix[0].size
        val m = matrix.size
        val result = MutableList(m) { MutableList(n) { 0 } }
        for (j in 0 until m) {
            for (i in 0 until n) {
                val curr = matrix[j][i]
                result[j][i] = if (matrix[j][i] == 9) 1 else curr + 1
            }
        }
        return result
    }

    fun dijkstraShortestPathCost(graph: Graph, source: Vertex, destination: Vertex): Int {
        val adjacencyList = graph.adjacencyList
        val queue = mutableSetOf(source)
        val minDistances = graph.vertices.fold(mutableMapOf<Vertex, Int>()) { acc, vertex ->
            acc[vertex] = Int.MAX_VALUE
            acc
        }
        minDistances[source] = 0

        while (queue.isNotEmpty()) {
            val current = queue.minByOrNull { minDistances[it]!! }!!
            queue.remove(current)
            for (neighbour in adjacencyList[current]?.let { it.keys } ?: emptySet()) {
                val newDistance = minDistances[current]!! + adjacencyList[current]!![neighbour]!!
                if (newDistance < minDistances[neighbour]!!) {
                    minDistances[neighbour] = minOf(minDistances[neighbour]!!, newDistance)
                    queue.add(neighbour)
                }
            }
        }
        return minDistances[destination]!!
    }


    data class Vertex(val i: Int, val j: Int)
    data class Edge(val from: Vertex, val to: Vertex, val cost: Int)

    data class Graph(val vertices: Set<Vertex>, val edges: List<Edge>) {
        val adjacencyList: Map<Vertex, Map<Vertex, Int>>
            get() {
                val result = mutableMapOf<Vertex, MutableMap<Vertex, Int>>()
                for ((from, to, cost) in edges) {
                    val neighboursFrom = result[from] ?: mutableMapOf()
                    neighboursFrom[to] = cost
                    result[from] = neighboursFrom
                }
                return result.toMap()
            }

        companion object {
            fun from(matrix: List<List<Int>>): Graph {
                val vertices = mutableSetOf<Vertex>()
                val edges = mutableListOf<Edge>()
                val n = matrix[0].size
                val m = matrix.size
                for (j in 0 until m) {
                    for (i in 0 until n) {
                        val vertex = Vertex(i, j)
                        vertices.add(vertex)
                        if (i < n - 1)
                            edges.add(Edge(vertex, Vertex(i + 1, j), matrix[j][i + 1]))
                        if (j < m - 1)
                            edges.add(Edge(vertex, Vertex(i, j + 1), matrix[j + 1][i]))
                        if (i > 0)
                            edges.add(Edge(vertex, Vertex(i - 1, j), matrix[j][i - 1]))
                        if (j > 0)
                            edges.add(Edge(vertex, Vertex(i, j - 1), matrix[j - 1][i]))
                    }
                }
                return Graph(vertices.toSet(), edges.toList())
            }
        }
    }

}