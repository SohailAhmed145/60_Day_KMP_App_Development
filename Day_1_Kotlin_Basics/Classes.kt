package Day_1_Kotlin_Basics

import kotlin.random.Random


//Exercise 1
data class Employee(val name: String, var salary: Int)

//Exercise 2
class RandomEmployeeGenerator(var minSalary: Int, var maxSalary: Int){
    val names = listOf("john", "jack", "mary","paul","Ann","Eliza")
    fun generateEmployee() =
        Employee(names.random(), Random.nextInt(from = minSalary, until = maxSalary))
}

fun main() {
    //Exercise 1
    val emp = Employee("Mary", 20)
    println(emp)
    emp.salary += 10
    println(emp)

    //Exercise 2
    val empGen = RandomEmployeeGenerator(10, 30)
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    println(empGen.generateEmployee())
    empGen.minSalary = 50
    empGen.maxSalary = 100
    println(empGen.generateEmployee())
}