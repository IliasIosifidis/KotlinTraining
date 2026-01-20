import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    GlobalScope.launch(Dispatchers.IO) {
        println("coroutine from global Scope")
    }

    runBlocking {
        println("run blocking")
    }
    println("Continue exec")
    Thread.sleep(10)
}