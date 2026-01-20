import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    coroutineScope {
        val job1 = launch {
            println("job1")
            val job2 = launch {
                println("job2")
                delay(2000)
                println("job 2 comple")
            }
            delay(2000)
            println("job 1 comple")
        }
        Thread.sleep(1000)
        job1.cancel()
        println("continue exec")
        Thread.sleep(3000)
    }
}