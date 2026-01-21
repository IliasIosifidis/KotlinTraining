import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var funCalls = 0

suspend fun main() {
    GlobalScope.launch {completeMessage()}
    GlobalScope.launch { improveMessage() }
    print("hell")
    Thread.sleep(1500)
    println(funCalls)
}

suspend fun completeMessage(){
    delay(500)
    println("world")
    funCalls++
}

suspend fun improveMessage(){
    delay(1000)
    println("it suspends")
    funCalls++
}