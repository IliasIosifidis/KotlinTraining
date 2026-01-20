import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    GlobalScope.launch {
        simpleFun()
    }
    simpleFun()
    Thread.sleep(1000)
}

suspend fun simpleFun(){
    delay(100)
    println("suspend!")
}