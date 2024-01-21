package com.softcross.kotlinlectures

/**
- Interfaces contain common abstract methods or properties that classes have.
- They can implemented by class or interfaces
- Interfaces similar to abstract class but they can implemented more than one class and
they cant have states.
 */

interface Peoples {
    fun eat()
    fun sleep()
    val name: Int
}

/**
- The classes that implement the interface must override all methods.
- Properties defined in interfaces cannot have backing fields.
 */

class Woman : Peoples {
    override fun eat() {}
    override fun sleep() {}
    override val name: Int
        get() = 1
}

/**
 - A interface can implement another interface. This state the classes that implement them do not
 have the properties they override.
 */
interface BasePeople {
    val name: Int
}

interface Man : Peoples {
    override val name: Int
        get() = parseType(mappedName)
    val mappedName: String
    override fun eat() {
        TODO("Not yet implemented")
    }
}

private fun parseType(value: String): Int {
    return value.toInt()
}

class Eren:Man{
    override val mappedName: String
        get() = TODO("Not yet implemented")

    //Must
    override fun sleep() {
        TODO("Not yet implemented")
    }

    //Optional
    override val name: Int
        get() = super.name
    override fun eat() {
        super.eat()
    }
}

class Cat(override val mappedName: String) : Man {
    override fun sleep() {
        TODO("Not yet implemented")
    }
}

/**
- In this state don't have to override type, but can access property of type.
- mappedName must override.

 - One class can implement more than one interface, and these interface can have same named methods.
 - To know which method to called can pre call like this super<Class>

 - If one interface method don't have body, this method named as 'abstract' and can't call directly
 by the class that implement them
 */

interface Taxi {
    fun takeCustomer() { println("taxi takes customer") }
    fun dropCustomer() { println("taxi drops customer") }
}
interface Boat {
    fun takeCustomer() { println("boat takes customer") }
    fun dropCustomer()
    fun mustOverride()
}

class SeaTaxi : Taxi, Boat {
    override fun takeCustomer() {
        super<Taxi>.takeCustomer()
        super<Boat>.takeCustomer()
    }

    override fun dropCustomer() {
        super<Taxi>.dropCustomer()
        // Abstract member cannot be accessed directly
        // super<Human>.sleep()
    }

    override fun mustOverride() {
        TODO("Not yet implemented")
    }


}