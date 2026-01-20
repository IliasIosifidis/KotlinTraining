import kotlinx.coroutines.Delay
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlin.random.Random

suspend fun main() {
    coroutineScope {
        val firstDeferred = async { getValue(1000)
            println("first Deferred result")
            getValue(1000)
        }

        val secondDeferred = async { getValue(1000) }
        println("some processing")
        delay(500)
        println(firstDeferred.await())
        println(secondDeferred.await())
        println("finished proc")

    }
    Thread.sleep(4000)
}

suspend fun getValue(delay: Long): Int {
    delay(delay)
    return Random.nextInt()
}