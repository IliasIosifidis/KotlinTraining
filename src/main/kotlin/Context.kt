import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        launch(CoroutineName("myCo")) {
            println("run from ${coroutineContext[CoroutineName.Key]}")
        }
    }
}