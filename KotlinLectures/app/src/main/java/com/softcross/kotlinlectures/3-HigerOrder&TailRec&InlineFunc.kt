package com.softcross.kotlinlectures

import android.view.View
import android.widget.EditText

fun main() {

    fun sumHigher(a: Int, b: Int): Int = a + b

    fun higherOrderFunc(a: Int, b: Int, operation: ((Int, Int) -> Int)) {
        println("result:${operation(a, b)}")
    }

    fun printSentence(sentence: String, print: (String) -> Unit) {
        print(sentence)
    }

    fun additionAnonymous(addition: ((Int, Int) -> Int)?) {
        val result = addition?.invoke(10, 20)
        println(result)
    }

    // We can named function parameters
    fun rollDice(range: IntRange, time: Int, callback: (result: Int) -> Unit) {
        for (i in 0 until time) {
            val result = range.random()
            callback(result)
        }
    }

    /**
     - Functions that are used as parameters or return a function are called higher-order functions
     - They can used as belowe;
     */
    higherOrderFunc(4, 5) { a, b ->
        a + b
    }

    // For the pass function;
    higherOrderFunc(4, 5, ::sumHigher)
    // kotlin reflection(::) -> creates a performance bottleneck, but not enough to affect your application

    // When higher order functions have one parameter they represent with it identifier.
    printSentence("Hello") {
        println(it)
    }

    // Lambda expressions can returned as value.
    fun returnLambda(): () -> String? {
        val lambda = { null }
        return lambda
    }

    // Kotlin have invoke(), in this main reason lambda expression can be null.
    val message = returnLambda()
    println(message)
    println(message.invoke())

    // Anonymous functions can pass higher order functions
    val add = fun(a: Int, b: Int): Int {
        return a + b
    }
    additionAnonymous(add)

    /**
     - Sometimes algorithms give recursive solution but sometimes called functions can give
     stackoverflow exception in this recursive solutions. This is reason for the using tailrec functions.
     */

    // In this 'n * recursiveFactorial(n - 1)' isn't last calling.
    // This func do all job with one function inside more function.
    var result = 0
    fun recursiveLCM(a:Int, b:Int): Int {
        return if (result%a==0 && result%b==0){
            result
        }else{
            result++
            recursiveLCM(a,b)
        }
    }

    // But in this 'factorialTailRec(n - 1, soFar)' is last calling.
    // This func do all job as synchronized so one func finished do another func.
    fun LCM(a:Int, b:Int, result:Int=1): Int {
        return if (result%a==0 && result%b==0){
            result
        }else{
            LCM(a,b,result+1)
        }
    }

    tailrec fun tailRecLCM(a:Int, b:Int,result:Int=1): Int {
        return if (result%a==0 && result%b==0){
            result
        }else{
            tailRecLCM(a,b,result+1)
        }
    }

    /**
                                INLINE
     - In kotlin inline functions used for the blocking the memory problems.
     So think we have a function with inside a function.
                fun firstFun(){ secondFun() }
                fun secondFun(){ print("Hi") }

     in compile time this code show like this on java;
                 fun firstFun(){ secondFunc(); }
                 fun secondFun(){ String var1 = "Hi"; System.out.println(var1); }

     But if we use inline keyword on second function;
                 fun firstFun(){ secondFunc() }
                 inline fun secondFun(){ print("Hi") }
     in compile time show like this;
                 fun firstFun(){
                     int $i$f$secondFunc = false;
                     String var1 = "Hi";
                     System.out.println(var1);
                 }
                fun secondFun(){ String var1 = "Hi"; System.out.println(var1); }

     That's mean second func all body complete copied inside of first func.

                                        NOINLINE
     - Higher order functions can take lambda functions, if we don't want to copy func body to another
     func we can use 'NOINLINE' keyword.
     Noinline funcs don't give permission to non-local return


                                        CROSSINLINE
     - This keyword include some inline properties and some noinline properties. Let's explain,
     We can use crossinline keyword if we want function will be inline but do works on another scopes.
     */
}

fun first(){
    secondFun()
}
inline fun secondFun(){
    println("Hi")
}
inline fun inlineButNoInline(lambda:() -> Unit, noinline noInlineLambda:() -> Unit) {
    lambda()
    // println(lambda()) Error
    println(noInlineLambda())
    noInlineLambda()
}

inline fun EditText.customizedOnFocusChangeListener(
    crossinline functionFocus:() -> Unit,
    crossinline functionUnfocused: () -> Unit
){
    this.onFocusChangeListener = View.OnFocusChangeListener { _, focus ->
        if (focus){
            functionFocus()
        }else{
            functionUnfocused()
        }
    }
}