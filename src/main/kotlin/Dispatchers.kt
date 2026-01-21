import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
//        launch(Dispatchers.Main){
//            println("main dispatcher. Thread: ${Thread.currentThread().name}")
//        }
        launch(Dispatchers.Unconfined) {
            println("unconf Thread: ${Thread.currentThread().name}")
            delay(100)
            println("unconf2 Thread: ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("default Thread: ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO) {
            println("io Thread: ${Thread.currentThread().name}")
        }
        launch(newSingleThreadContext("My Thread")) {
            println("newSingleThreadContext Thread: ${Thread.currentThread().name}")

        }
    }
}