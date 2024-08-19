package com.softcross.kotlinlectures

fun main() {
    /**
    LET
    Object Reference: it      Return Value: Lambda Result        Is Extension function: Yes
    - It can usable on chaining calls and if result can not assigned a value or variable.
    - Usually used to use non-nullable values.
    - If a function using 'it' is to be called after using 'let', it can be referenced with '::'
     */

    var numbers = intArrayOf(5, 6, 8, 9, 0, 13, 5, 2, 6)
    numbers.map { it / 2 }.filter { it > 3 }.let(::println)


    /**
    WITH
    Object Reference: this     Return Value: Lambda Result       Is Extension function: No.
    - In code, with can be read as "with this object, do the following."
    - It can usable on when you don't need to use the returned result.
    - Isn't extension, takes the context object as an argument.
     */

    with(numbers) {
        println("Size is ${this.size}")
    }

    /**
    RUN
    Object Reference: this     Return Value: Lambda Result       Is Extension function: Yes.
    Object Reference: NO(-)     Return Value: Lambda Result       Is Extension function: No.
    - Kotlin have 2 type run.(Extension and Un-Extension)
    - It does same as 'with' but it implemented as extension function.
    - Run is useful when your lambda both initializes objects and computes the return value.
    - If used as un-extension it can't be object.
     */

    val person = Car.Person("John", "Walker")
    // Extension run
    val extensionRun = person.run {
        surname = "Sad"
        "Surname is $surname"
    }

    // Non-extension run
    val fullName: String? = run {
        person?.name?.plus(person.surname)?.capitalize()
    }
    val result = fullName ?: run {
        println("Name is null")
        throw Exception("ERRRRRROOOOOOOOORRROROORORO")
    }

    /**
    APPLY
    Object Reference: this     Return Value: Context Object       Is Extension function: Yes.
    - It usually used on that don't return a value and that mainly operate on the members of the receiver object
    - Such calls can be read as "apply the following assignments to the object."
     */

    person.apply {
        surname = "Wallet"
    }
    println(person.toString())

    /**
     ALSO
     Object Reference: it     Return Value: Context Object       Is Extension function: Yes.
     - It is useful for performing some actions that take the context object as an argument.
     - actions that need a reference to the object rather than its properties and functions,
     or when you don't want to shadow the this reference from an outer scope.
     */

    numbers.also {
        println("before filtering the size of numbers:${it.size}")
    }.filter {
        it > 3
    }

}
