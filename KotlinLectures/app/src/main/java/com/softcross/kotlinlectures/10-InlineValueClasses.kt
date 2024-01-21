package com.softcross.kotlinlectures

/**
- Sometimes it is useful to wrap a value in a class to create a more domain-specific type.
However, it introduces runtime overhead due to additional heap allocations.
Moreover, if the wrapped type is primitive, the performance hit is significant,
because primitive types are usually heavily optimized by the runtime,
while their wrappers don't get any special treatment.

- To solve such issues, Kotlin introduces a special kind of class called an inline class.
- Inline classes are a subset of value-based classes. They don't have an identity and can only hold values.
- Inline classes tell the compiler to behave as a primitive type even if an object is put inside.
- Inline classes define with put on start of function 'value' keyword.

!! Put @JvmInline annotation on the up of function to supported on JVM.
 */
@JvmInline
value class Name(private val fullName: String) : Printable {
    init {
        require(fullName.isNotEmpty()) {
            throw Exception("full name can not be empty")
        }
    }

    // Inline values can have body with kotlin 1.9.0 version
    constructor(firstName: String, lastName: String) : this("$firstName$lastName") {
        require(firstName.isNotEmpty()) {
            throw Exception("first name can not be empty")
        }

        require(lastName.isNotEmpty()) {
            throw Exception("last name can not be empty")
        }
    }

    override fun prettyPrint(): String {
        return fullName
    }
}

interface Printable {
    fun prettyPrint(): String
}

// Inline classes can have only just one property

fun asInline(f: Name) {}
fun <T> asGeneric(x: T) {}
fun asInterface(i: Printable) {}
fun asNullable(i: Name?) {}
fun <T> id(x: T): T = x


/**
 - On bottom two function take string parameter with same name, so they represent on jvm side as
 public final void printFullName-<hashcode>(String fullName).
 - If we want to change name on jvm side must use @JvmName annotation.
 */
fun printFullName(fullName: String) {}
@JvmName("printUserNameFully")
fun printFullName(fullName: Name) {}

fun main() {

    // This expression showed as string on runtime.
    val n = Name("Eren Mollaoğlu")
    asInline(n)    // unboxed: used as Name itself => String
    asGeneric(n)   // boxed: used as generic type T => Name
    asInterface(n) // boxed: used as type Printable => Name
    asNullable(n)  // boxed: used as Name?, which is different from Name => String?

    // below, 'n' first is boxed (while being passed to 'fullName') and then unboxed (when returned from 'fullName')
    // In the end, 'c' contains unboxed representation (just 'Eren Mollaoğlu'), as 'n'
    val c = id(n)
}
