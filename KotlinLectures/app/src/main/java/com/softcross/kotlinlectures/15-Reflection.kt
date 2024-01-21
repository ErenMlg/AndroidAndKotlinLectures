package com.softcross.kotlinlectures

import java.lang.reflect.Constructor
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

fun main() {
    /**
    - Reflection provide us examine codes structure on runtime. For example, we can learn
    type of a variable on runtime or we can set private to public or public to private.
     */

    class MyReflectionClass
    //Class reference, return type like as KClass, Kotlin class and Java class reference is not same.
    val reflectionKotlin = MyReflectionClass::class
    println(reflectionKotlin)
    println(reflectionKotlin.isAbstract)
    println(reflectionKotlin.isOpen)
    println(reflectionKotlin.supertypes)
    println(reflectionKotlin.constructors.size)


    //For take java class reference
    val reflectionJava = MyReflectionClass::class.java
    println("Java")
    println(MyReflectionClass::class == MyReflectionClass::class.java)
    println(reflectionJava.constructors.size)

    // If wanted to use a class's member or extension function; ClassName::FuncName
    val isEmpty = List<String>::isEmpty

    fun isOdd(x: Int) = x % 2 == 0
    // can access functions too with reflection
    val numbers = listOf(1, 2, 3)
    println(numbers.filter(::isOdd))

    data class UserData(val name: String)
    // Property reference can use on functions of accept only one parameter
    val name = UserData::name
    println(name)

    class Filled

    fun createFilled(initializer: () -> Filled) {
        val filled = initializer()
    }

    class ClassWithPrivateInstructor private constructor()
    class ClassWithPrivateProperty {
        private val name: String = "Hello From Private Property"
    }

    fun createPrivateClassWithReflection(): ClassWithPrivateInstructor {
        return (ClassWithPrivateInstructor::class.java.declaredConstructors[0].apply {
            isAccessible = true
        } as Constructor<ClassWithPrivateInstructor>).newInstance()
    }

    createFilled(::Filled)
    val privateClass = createPrivateClassWithReflection()
    val classWithPrivateProperty = ClassWithPrivateProperty()
    val field = ClassWithPrivateProperty::class.memberProperties.find {
        it.name == "name"
    }

    field?.let {
        it.isAccessible = true
        val w = it.get(classWithPrivateProperty)
        println(w)
    }
}