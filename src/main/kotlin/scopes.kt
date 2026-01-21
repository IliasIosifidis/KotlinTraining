import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    println("program will block")
    runBlocking {
        launch {
            delay(1000)
            println("task from run blocking")
        }
        GlobalScope.launch {
            delay(500)
            println("task from global")
        }
        coroutineScope {
            launch {
                delay(1500)
                println("task from coroutine score")
            }
        }
    }
    println("continue")
}
