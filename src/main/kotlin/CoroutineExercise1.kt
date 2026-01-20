import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main() {
    val limit = 123456
    var i = 3
    while (i <= limit){
        checkPrime(i)
        i += 2
    }
}

suspend fun checkPrime(number: Int){
    coroutineScope {
        var isPrime = true
        for (i in 2..number/2){
            if (number % i == 0){
                isPrime = false
                break
            }
        }
        if (isPrime){
            println("$number is a prime number")
        }
    }
}