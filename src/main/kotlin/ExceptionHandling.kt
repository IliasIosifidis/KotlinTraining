import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val myHandler = CoroutineExceptionHandler{coroutineContext, throwable ->
            println("exc handled: ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(myHandler) {
            println("thrown exc from job")
            throw IndexOutOfBoundsException()
        }
        job.join()

        val deferred = GlobalScope.async {
            println("throw exc from async")
            throw ArithmeticException("exception from async")
        }

        try {
            deferred.await()
        } catch (e: ArithmeticException){
            println("caught arithmetic exc ${e.localizedMessage}")
        }
    }
}