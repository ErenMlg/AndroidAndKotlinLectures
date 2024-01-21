package com.softcross.kotlinlectures

class PersonEmpty

class PersonConstructor constructor(firstName: String)

// If primary constructor don't have a annotation or visibility modifier then it can remove.

class PersonWithoutConstructor(firstName: String)

/**
 - The class header can't contain any runnable code. If you want to run some code during object creation,
 use initializer blocks inside the class body

 - During the initialization of an instance, first the initializer blocks are executed in
 the same order as they appear in the class body, after that constructors executed.

 - Constructors can have val or var keyword, if don’t marked with them it can’t visible for
 the out of initializer blocks.
*/
class PersonInitilazer(val firstName: String) {
    val variable1 = "Variable 1".also(::println)

    constructor(firstName: String, lastName: String) : this(firstName) {
        println("$firstName $lastName")
    }

    init {
        println("First initializer block that prints $firstName")
    }

    val variable2 = "Variable 2".also(::println)

    init {
        println("Second initializer block that prints ${firstName.length}")
    }
}

class WontCreate private constructor() // If we don’t want to create class

// If parameters of primary constructors have default value then JVM create constructor without parameter.

fun main() {

    val person = PersonInitilazer("Eren", "Mollaoğlu")
    val car = Car("x")
    println(car.carFullName)
    car.carFullName = "Erdem"
    println(car.carFullName)

    // Data class
    val person1 = Car.Person("eren","erdem")
    println(person1.toString())
    // Destructing
    val (name,surname) = person1
    val name2 = person1.component1()
    val surname2 = person1.component2()
    println(name+" "+surname)
    println(name2+" "+surname2)
    val person2 = person1.copy(name="erdem")
    println(person2)
}

/**
 - If parameter defined with val inside of constructor then JVM side have only getter functions,
 if defined with var then JVM side have both the setter and getter

 - If we pass default parameters inside of data class constructor, this default parameter give error
inside of java side to in constructor. For the solve this problem @JvmOverloads annotation can use.
 */
data class Car @JvmOverloads constructor(private var carName:String=""){

    /**
      fun getCarName()=carName -> Its give error on compiler time because JVM Side create same fun
      Instead of this
     - You can create custom getter and setter, in this case don't create a field and dont
		 took place on memory
     */

    var carFullName:String get() = carName
        set(value){
            carName = value
        }

    // Can read outside but can't changable
    var carNameSecond
        get() = carName
        private set(value) { carName = value }

    /**
        - Private: Can only access from to inside of own class
        - Public: Can access from to everywhere
        - Internal: Can only access from to same modules
        - Protected: Can only access from to derived class (Inherited Classes)
     */

    // Data Classes

    /**
     - To storage data used to data classes. They have properties like produce readable output, comparison of instance.
     - Primary constructor must have at least one parameter and all of parameters must marked with var or val.
     - They can’t be abstract, open, sealed or inner class.
     */

    data class Person(val name:String,var surname:String)

    /**
            val (name,surname) = person1
            val name2 = person1.component1()
            val surname2 = person1.component2()
            println(name+" "+surname)
            println(name2+" "+surname2)

        - Kotlin provide destructuring declarations as componentN
        - ToString() print like Person(name=eren,surname=erdem)
            val person1 = Car.Person("eren","erdem")
            println(person1.toString())
        - Property intents can copy with copy method, they produce hashCode and equals methods.

        - Some methods like equals and hashCode looks only primary constructor, so two person
            created with same name but different age, they will print true when controlling with equals.
     */
    data class Equality(val name: String) {
        var age: Int = 0
    }

    /**
     - Lets think we create a person by name is eren, surname is mollaoğlu but they define as val,
     if we want to change surname mollaoğlu to erdem then we can't do change on object,
     we can copy and create new object and changed surname:
            val person1 = Person("eren","erdem")
            val person2 = person1.copy(name="erdem")
     */

}