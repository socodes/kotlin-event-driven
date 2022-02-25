
fun requestData() {
    val result = InputOutputDevice.getData()
    when (result) {
        is Result.Loading -> UserInterface.showLoadingScreen()
        is Result.Success -> UserInterface.showData(result.value)
        is Result.Error -> UserInterface.showErrorMessage()
    }
}

sealed class Result {
    object Loading : Result()
    object Error : Result()
    data class Success(val value: String) : Result()
}

//This represents some generic IO device, which you would request data from
object InputOutputDevice {
    fun getData(): Result {
        return Result.Success("Congrats!")
    }
}
//This represents the User Interface, which is empty for now.
object UserInterface {
    fun showLoadingScreen() {

    }

    fun showData(data: String) {

    }

    fun showErrorMessage() {

    }
}
//enums that represents mathematical operators.
enum class MathematicalOperator(val op: Char) {
    PLUS('+'),
    MINUS('-'),
    MULTIPLY('*'),
    DIVIDE('/')
}

fun checkOperator(op: MathematicalOperator): (Double, Double) -> Double {
    return when (op) {
        MathematicalOperator.PLUS -> { x, y -> x + y }
        MathematicalOperator.MINUS -> { x, y -> x - y }
        MathematicalOperator.DIVIDE -> { x, y -> x / y }
        MathematicalOperator.MULTIPLY -> { x, y -> x * y }
    }
}

fun main(args:Array<String>){
    val mathFunction = checkOperator(MathematicalOperator.MULTIPLY)
    println(mathFunction.invoke(4.0, 4.0))
}