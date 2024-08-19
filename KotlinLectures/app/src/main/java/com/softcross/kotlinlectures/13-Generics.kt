package com.softcross.kotlinlectures

/**
- Generics in Kotlin allow you to write code that is flexible and reusable,
by specifying a type parameter when defining a class, interface, or function.This type parameter
can then be replaced with a concrete type when the class, interface, or function is used.

- Generics can define inside of '<T>' representation with a letter. On calling time specifying
a type.

- T in '<T>' used for shortcut of 'type', can use anything letter or word.
- This variance is invariant.
 */
fun <T> entry(x: T) {
    println(x)
}

fun main(){
    entry<String>(4324)
}

interface Keyboard<T> {
    fun enter(x: T)
}

/**
 - In this interface when used must specify a type. In bottom compiler can understand T is String
 and override according to string
 */
class Letters : Keyboard<String> {
    override fun enter(x: String) {

    }
}
interface CarGeneric
interface SportCar : CarGeneric
interface OldCar : CarGeneric

class Ferrari : SportCar
class Mustang : OldCar

interface ManagerClass {
    fun match(subject: OldCar): SportCar
}

class PersonalClass : ManagerClass {
    override fun match(subject: OldCar): Ferrari {
        return Ferrari()
    }
}

fun createPersonalClass() = PersonalClass()



/**
 - A subtype must return at most the same range of types as its supertype declares.
 - A subtype must accept at least the same range of types as its supertype declares.
 */

open class Biology {
    // some methods & member variables
}

class Genetics : Biology() {
    // some methods & member variables
}

//Invariance; is the use of exactly the type specified
class InvarianceGenericClass<T : Biology>
/**
 - Genetics is subtype of Biology. It can give on according specify type but in this firstInvariance
  variable type now convert to InvarianceGenericClass<Genetics>
 */
/*
    var firstInvariance = InvarianceGenericClass<Genetics>()
    firstInvariance = InvarianceGenericClass<Biology>()
    val secondInvariance: InvarianceGenericClass<Biology> = InvarianceGenericClass<Genetics>()
*/

/**
 - Covarianca; usage subtype instead of super type
 - It can use only out position, its mean usable as return type of function.
 - It usable as val property, but can't use as var property.
 */
class CovarianceGenericClass<out T : Biology>

// Generic must be marked with out to be used the subtype of the class
val covarianceGenericClass: CovarianceGenericClass<Biology> = CovarianceGenericClass<Genetics>()

/**
 - Contravarianca; usage super type instead of subtype.
 - It can use only in position, its mean usable as parameter.
 - It can't use as out position so it can't usable as val or var property.
 */
class ContravarianceGenericClass<in T : Biology>

// Generic must be marked with in to be used the super type of the class
val contravarianceGenericClass: ContravarianceGenericClass<Genetics> =
    ContravarianceGenericClass<Biology>()

/**
 - if X is subtype of Y Array<X> is can't subtype of Array<Y> in generics and inheritance.
 This is solved by making variance.

 - Type is define objects shared properties, its mean tells which type planned for the use to compiler.
 - Class is implementation of this Type.

 - Here 'Elephant' is both a class and a type, as the name suggests.
 */
data class Elephant(val elephantName: String, val isChild: Boolean) : Animals(elephantName) {
    /*fun eat() {}
    fun sleep() {}*/
}
data class Duck(val duckName: String) : Animals(duckName) {
    /*fun eat() {}
    fun sleep() {}*/
}
open class Animals(val name: String) {
    fun eat() {}
    fun sleep() {}
}
/**
 - In here list defined with Animals but can send Duck or Elephant, reason of this situation List
  is marked with out and this provide us covariance.

 - Covariance sent as one-way, its mean we can say Duck is subtype of Animals, but we can't say
  Animal is Duck.
 */

fun printCars(elements: List<SportCar>) {
    elements.forEach {
        it.toString()
    }
}

fun main(){
    val personalClass = createPersonalClass()
    val managerClass = personalClass as ManagerClass

    val sportCar = managerClass.match(Mustang())
    val ferrari = personalClass.match(Mustang())
    println(sportCar)
    println(ferrari)
    var list:List<SportCar> = listOf(Ferrari(),Ferrari())
    printCars(list)
}
/**
 - Contravariant is opposite of covariance. Its mean Animal is Duck but Duck isn't Animal.
 Contravariance is done by marking with in.
 */