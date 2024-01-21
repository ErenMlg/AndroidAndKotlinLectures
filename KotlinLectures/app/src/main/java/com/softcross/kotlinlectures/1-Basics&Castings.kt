package com.softcross.kotlinlectures

fun main() {
    /**
    - Kotlin automatically detect and accept variable type.
    But if we want can define variable type like this 'var variableName:Int && val variableName:Int'
    - Val : Can not redefine
    - Var : Can redefine

------------------------------------------------------------------------------------------------------------------------

    - Unsigned Integer => kotlin.UInt: unsigned 32-bit integer, ranges from 0 to 2^32 - 1
    - Unsigned is not only for the int, it is usable for Byte, Short, Long, Arrays etc.
    - We can think unsigned types as min value is 0 so they can't have negative values.

------------------------------------------------------------------------------------------------------------------------

    - Primitive types hide on stack, so they have LIFO principle, when we want to access they give
    us directly value of variable.
    - Non-Primitive types can not hide on stack, they hide on Hash, so if we want to access
    this types, they give us reference address to variable.

    - There are primitive types in Kotlin but there aren't :)
    - Explaining;
    - We cannot create primitive types directly, because kotlin works with JVM (Java Virtual Machine) and Java.
    In Kotlin primitive types can behave like non-primitive types, if we define them as follows;
    var number:Int? = value
    This variable behave as non-primitive because java can't agree null value for the integer type.
    - But if we define it as follows;
    var number:Int = value
    This variable behave as primitive because we cant give null value and java want this too.
     */
    val primitiveInt: Int = 4
    var nonPrimitiveInt: Int? = null
    nonPrimitiveInt = 5

    /**
     - In kotlin do memory optimization between -128 and 127 so in this range values can equivalent but cant equal
     */

    val a: Int = 100
    val boxedA: Int? = a
    val anotherBoxedA: Int? = a

    val b: Int = 10000
    val boxedB: Int? = b
    val anotherBoxedB: Int? = b

    println("is boxedA and anotherBoxedA reference equals?")
    println(boxedA === anotherBoxedA) // true
    println("is boxedB and anotherBoxedB reference equals?")
    println(boxedB === anotherBoxedB) // false
    println("is boxedB and anotherBoxedB value equals?")
    println(boxedB == anotherBoxedB) // true

    /**
     - '===' three equals is control they equal as reference so are they same object?
     - '=='  two equals is control they equivalent as value.
     - In primitive types '===' and '==' do same work, because they cant have reference address.

------------------------------------------------------------------------------------------------------------------------

     - In arithmetical operations can't need conversion;
     val longType: Long = 1 + 4L

     - But small types can not convert bigger types as directly, they have extension function for this job.
     val c:Long = primitiveInt  =>  Error
     val c: Long = primitiveInt.toLong()

------------------------------------------------------------------------------------------------------------------------

    - Strings are immutable, so if we define for once we can't change this.
    - Actually we can change but if we change string, created new reference for this change
    so they can't same object.
     */

    var i:Int = 5
    i.toLong()


    var str = "abcd"
    str.toUpperCase() // str cant change
    println("is str and UpperCased str referance equals?")
    println(str === str.toUpperCase())

    // Can navigable for string chars
    str.forEach {
        print(it + " ")
    }

    println("\nStr" + 1) // Str1

    val text = """
    for (x in str)
        print(x)
    """
    println(text)
    // This print with gaps

    val text2 = """
    |Merhaba bu 1.Satır
    |Merhaba bu 2.Satır
    |Merhaba bu 3.Satır
    |Merhaba bu 4.Satır
""".trimMargin()
    println(text2)
    // This gaps is removed. Because of '|'.

    /**
    Unsafe casting
------------------------------------------------------------------------------------------------------------------------
    val y = null
    val x: String = y as String
    println(x)
    => Give Error because we try to convert non-nullable type to null.

    Safe casting
------------------------------------------------------------------------------------------------------------------------
    val y = null
    val x: String? = y as? String
    println(x)
     */
}