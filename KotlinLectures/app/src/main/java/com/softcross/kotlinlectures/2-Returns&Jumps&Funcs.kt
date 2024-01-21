package com.softcross.kotlinlectures

fun main() {

    // Expressions can be marked with label.
    outerLoop@ for (i in 1..3) {
        innerLoop@ for (j in 1..3) {
            if (i == 2) {
                break@outerLoop
            }
            println("i:$i j:$j")
        }
    }

    // Used pass this step for the lambda function
    intArrayOf(1, 2, 3, 4, 5).forEach lambda@{
        if (it == 3) return@lambda
        println(it)
    }

    // Directly return lambda function
    run loop@{
        intArrayOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop
            println(it)
        }
    }

    /**
     - Default arguments minimize the overload operation.
     - Even if the parent class has default arguments, they are converted to normal argument
     when overridden
     */
    fun sumDefault(a: Int, b: Int = 0): Int {
        return a + b
    }

    sumDefault(4)

    /**
     - If a function can't return anything so this return type is Unit. Dont needed return type
     for the Unit.
     - When vararg is used, any number of values can be sent for the variable used.
     - Only one parameter can marked as vararg
     */
    fun add(vararg sentences: String, author: String): Unit {
        for (str in sentences) {
            println(str)
        }
        println(author)
    }
    add("Yazılım", "Kotlin", "Android", "Mühendis", author = "Eren Mollaoğlu")

    /**
     - Extension Function
     We have a class, we want add feature this class but want don't change anything on the class,
     we can use extension function for this job.
     */

    fun Int.findClosestLowerValue(): Int = this - 1
    println("Closest lower value of 5 is : " + 5.findClosestLowerValue())

    /**
     - Infix function
     If one function marked as infix, this can not necessary used '.' when we calling this.
     - They must member or extension function.
     - They must have one parameter and this parameter can't vararg or default.

     Member Function: Defined function in the one class.
     */

    infix fun Int.sumWith(a: Int): Int = this + a
    val result = 5 sumWith 10
    println("5 + 10 = $result")

    class Operation {
        infix fun add(a: Int): Int = 4 + a

        fun buildAddOperation() {
            val a = this add 5
            val b = add(5)
            println(a)
            println(b)
            // add 5 => false
        }
    }

    var op = Operation()
    op.buildAddOperation()


    /**
     - Lambda expressions and anonymous functions named as functions literals.
     - Function literals means is a function don't defined but passed instantly as expression.
     -
     - Functions parameter types and return types defined like below this;
     (Parameter Type 1,Parameter Type 2) -> Return Type
     (x:Int, y:Int) -> String

     - for the define nullable function ((Int,Int)->Int)?
     */
    val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    println(sum.invoke(5, 5))

    val sumLeaved = { x: Int, y: Int -> x + y }
    println(sumLeaved.invoke(5, 4))

    /**
     - A lambda function is defined as a parameter of the one function, before the function parameter
     separate with ({}) bracket. They named as trailing lambda
    */
    val lectures = arrayOf("XY", "YZ", "Z", "DE")
    lectures.fold("") { acc, e ->
        acc + e
    }
    /*
    public inline fun <T, R> Array<out T>.fold(initial: R, operation: (acc: R, T) -> R): R {
        var accumulator = initial
        for (element in this) accumulator = operation(accumulator, element)
        return accumulator
    }
    */

    /**
     - Use one parameter for the lambda function is common usage. In this case the '->' sign can
     ignored when using lambda. This parameter is called implicit
    */
    println(
        lectures.filter {
            it.length == 1
        }
    )
    /**
     - Lambda Expressions can be used sequentially in LINGQ-style
     when they can be used with curly brackets outside functions.
     */
    println(
        lectures.filter {
            it.length == 2
        }.sortedBy {
            it
        }.map {
            it.toLowerCase()
        }
    )

    // Parameters not to be used can show as '_'
    lectures.forEachIndexed { _, s ->
        println(s)
    }

    /**
     - Lambda functions cannot specify the return type of the function,
     to specify the return type Anonymous functions are used, these functions are anonymous,
     a body or single expression can be written as It is not necessary to specify the type of return
     that can be inferred.
    */
    val filterFunction = fun(a: String) =
        a.length > 1 // or val filterFunction = fun(a: String):Boolean = a.length > 1
    println(lectures.filter(filterFunction))

    /**
     - Lambda expressions or local funcs can reach own top scope. This case named as 'own closure'.

     Reached variable in filter with inside of forEach
     */
    var sumOfClosure = ""
    lectures.filter {
        it.length > 1
    }.forEach {
        sumOfClosure += it
    }
    println(sumOfClosure)

    // Lambda functions can named pseudonym, and can use everywhere as this name.
    fun typeAliasFunc(action:SumFunc){}
}
// If name complex or long can named pseudonym
typealias SumFunc = (Int, Int) -> Int
fun double(x: Int) = x * 2


