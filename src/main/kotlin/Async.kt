import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val firstDeferred = async { getFirst() }
        val secondDeferred = async { getSecond() }

        println("processing...")
        delay(500)
        println("waiting...")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()

        delay(500)
        println("total is ${firstValue + secondValue}")
    }
}

suspend fun getFirst():Int{
    delay(1000)
    val value = Random.nextInt(100)
    println("Returning first value ${value}")
    return value
}

suspend fun getSecond(): Int{
    delay(2000)
    val value = Random.nextInt(1000)
    println("Return second value ${value}")
    return value
}