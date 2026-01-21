import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    runBlocking {
        val job1 = launch {
//            delay(3000)
            println("job 1")
            val job2 = launch {
                println("job 2 launch")
                delay(3000)
                println("job 2 complete")
            }
            job2.invokeOnCompletion{ println("job 2 complete") }
            val job3 = launch {
                println("job 3 started")
                delay(2000)
                println(" job 3 done")
            }
            job3.invokeOnCompletion { println("job 3 complete") }
        }
        job1.invokeOnCompletion { println("job 1 complete") }
        delay(500)
        println("job 1 cancel")
        job1.cancel()
    }
}