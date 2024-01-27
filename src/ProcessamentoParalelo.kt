
fun main() {
    val urls = mutableListOf<String>()

    while (true) {
        val input = readLine() ?: break
        if (input.isBlank()) break
        urls.add(input)
    }

    println("Iniciando downloads...")

    val results = mutableListOf<Pair<Int, Int>>()

    val threads = urls.mapIndexed { index, url ->
        Thread {
            val length = openLink(url)
            synchronized(results) {
                results.add(Pair(index, length))
            }
        }
    }

    threads.forEach {
        it.start()
    }

    Thread.sleep(3000)

    results.sortedBy { it.first }.forEachIndexed { idx, result ->
        println("Arq${idx + 1}: ${result.second}")
    }

    println("Tempo total: ${urls.size}")
}

fun openLink(url: String): Int {
    return url.length
}