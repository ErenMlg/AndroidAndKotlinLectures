package com.softcross.kotlinlectures

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
- With some common kinds of properties, even though you can implement them manually every
time you need them, it is more helpful to implement them once, add them to a library,
and reuse them later. For example:
 * Lazy properties: the value is computed only on first access.
 * Observable properties: listeners are notified about changes to this property.
 * Storing properties in a map instead of a separate field for each property.

 */
class Example { var p: String by Delegate() }

fun main(){
    val example = Example()
    println(example.p)
    println(example::p)
}
/**
- The syntax is: val/var <property name>: <Type> by <expression>.
The expression after by is a delegate, because the get() (and set()) that correspond to the
property will be delegated to its getValue() and setValue() methods. Property delegates don't have
to implement an interface, but they have to provide a getValue() function (and setValue() for vars).
 */

class Delegate {
    // this ref ownself of object, property parameter storage info from property
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}
/*
    val example = Example()
    println(example.p)
    println(example::p) => access like this
    example.p = "Hello"
 */


// LAZY DELEGATION

/**
 - Value is assigned on first calling, the operations in lazy are not repeated on the next call.
 - Review work is synchronized as default, its mean value is calculated on only one thread but
 another all threads see this value.

 - If don't wanted to access multiple thread at initialization then send LazyThreadSafetyMode.PUBLICATION
 parameter to lazy func
 */

val value: String by lazy {
    println("computed!")
    "Hello"
}
// Assuming that the following operations are performed one after the other
// println(value) // This print computed! and Hello
// println(value) // this print only hello

// OBSERVABLE PROPERTIES

/**
- Delegates.observable() takes two arguments: the initial value and a handler for modifications.
- Used to show different old value and new value
- The handler is called every time you assign to the property (after the assignment has been performed).
It has three parameters: the property being assigned to, the old value, and the new value
 */
class User {
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("$old -> $new")
    }
}
/*
    val user = User()
    user.name = "first"
    user.name = "second"
    Output;
        <no name> -> first
        first -> second
*/

// Map delegation can use for the make it easier to json works. It can work with var
class User2(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

val user = User2(
    mapOf(
        "name" to "John Doe",
        "age" to 25
    )
)
// println(user.name) // Prints "John Doe"
// println(user.age)  // Prints 25

/**
- A property can delegate another property, For example;
There is use for development and notify purposes by supporting older versions without deleting the
deprecated property.
 */
class MyClass2 {
    var newName: Int = 0

    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldName: Int by this::newName
}

/*
       val myClass = MyClass()
       // Notification: 'oldName: Int' is deprecated, Use 'newName' instead
       myClass.oldName = 42
       println(myClass.newName) // Output : 42
 */

/**
- You can create delegates as anonymous objects without creating new classes,
by using the interfaces ReadOnlyProperty and ReadWriteProperty from the Kotlin standard library.
They provide the required methods: getValue() is declared in ReadOnlyProperty;
ReadWriteProperty extends it and adds setValue(). This means you can pass a ReadWriteProperty
whenever a ReadOnlyProperty is expected.
 */
class Resource

fun resourceDelegate(resource: Resource = Resource()): ReadWriteProperty<Any?, Resource> =
    object : ReadWriteProperty<Any?, Resource> {
        var curValue = resource
        override fun getValue(thisRef: Any?, property: KProperty<*>): Resource = curValue
        override fun setValue(thisRef: Any?, property: KProperty<*>, value: Resource) {
            curValue = value
        }
    }

val readOnlyResource: Resource by resourceDelegate()  // ReadWriteProperty as val
var readWriteResource: Resource by resourceDelegate()


/**
- Lateinit keyword used for the assign value of after the initialize.
- Lateinit can't used with primitive because lateinit to control is value assigned
with special null type, but primitive types can't accept null type.

- Control of initialization is done by taking the class reference together with reflection.
 */

class LateInitProperty {
    private lateinit var info: String

    fun setInfo(info: String) { this.info = info }

    fun getInfo(): String? {
        // Reflection
        return if (this::info.isInitialized) {
            info
        } else {
            null
        }
    }
}

/**
- On primitive types we can't use lateinit, so usually used convert to type nullable and use everywhere
with null check, instead of this can use notNull() delegation.
 */
var notNullInt: Int by Delegates.notNull()
