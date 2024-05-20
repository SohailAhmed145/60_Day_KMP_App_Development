package Day_1_Kotlin_Basics

import kotlin.math.PI

fun functions(){

    //Functions
    //Exercise 1 Calculate circle Area by radius
    println(circleArea(2))

    //Exercise 2 conversion in seconds
    println(intervalsInSeconds(12,25))
    //Exercise 3 simplify code in single expression function
    println(singleCircleArea(4))

    //Lambda expressions

    //normal expression
    println(upperCaseString("hello"))
    //lambda expression
    println({string : String -> string.uppercase()}("hello2"))

    //assign to variable
    val uppercaseString = {string : String -> string.uppercase()}
    println(uppercaseString("hello3"))

    //filter method
    val numbers = listOf(1,-2,3,-4,5)
    val positives = numbers.filter{x -> x > 0}
    val negatives = numbers.filter{x -> x < 0}
    println(positives)

    //function types
    val uppercaseString1 : (String) -> String = {string -> string.uppercase() }
    println(uppercaseString1("hello4"))
}

fun circleArea(radius : Int): Double{
    return PI * radius * radius
}

//single expression function
fun singleCircleArea(radius: Int): Double = PI * radius * radius

fun intervalsInSeconds(hours : Int = 0, minutes : Int = 0, seconds : Int = 0 ): Int {
    return (((hours * 60)+ minutes)* 60 + seconds)
}

fun upperCaseString(string : String): String{
    return string.uppercase()
}

fun main() {

    functions()

}