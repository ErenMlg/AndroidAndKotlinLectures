package com.softcross.kotlinlectures

/**
- A class derived with another class is inheritance.
- In kotlin all classes derive Any class as implicit.
- In kotlin all classes default final so you can not inherit they, so if you want inherit one class
you must put start of class 'open' keyword.
 */

open class Animal(val age: Int)

// If inheritance class have parameter, must put this parameter when derived.
class Dog : Animal(10)

open class Vehicle() {
    constructor(vehicleWeight: Int) : this()

    constructor(vehicleWeight: Int, vehicleWheelCount: Int) : this()
}

class DerivedWithSecondaryConstructor : Vehicle {
    constructor(vehicleWeight: Int) : super(vehicleWeight)
    constructor(vehicleWeight: Int, vehicleWheelCount: Int) : super(
        vehicleWeight,
        vehicleWheelCount
    )
}

// In kotlin if we want override method, we must put 'open' keyword.
open class Book {
    open var pageNumber: Int = 10
    open fun addPage() {
        pageNumber++
    }

    fun writeOnPage(text: String) {
        println(text)
    }
}

open class WorkBook : Book() {
    override var pageNumber: Int
        get() = super.pageNumber
        set(value) {}

    // If we don't want more override method, can put 'final' keyword
    final override fun addPage() {
        super.addPage()
    }
    // We cant override writeOnPage because this method can't marked with 'open'.
}

class MathWorkBook : WorkBook() {
    // In here pageNumber can overridable but addPage can't because it defined as 'final'
    override var pageNumber: Int
        get() = super.pageNumber
        set(value) {}
}

open class Plane(companyName: String) {
    init {
        println("init in plane")
    }

    open val companyNameLength: Int = companyName.length.also {
        println("nameLength in plane")
    }
}

/**
 - In the initialization process, the place where the derived class gives parameters to
 the base class is works first.
 - Second, derived class's init and properties work respectively

 */
class SmallPlane(companyName: String) :
    Plane(companyName.also { println("argument initialization") }) {
    init {
        println("init in SmallPlane")
    }

    override val companyNameLength: Int = super.companyNameLength.also {
        println("nameLength in SmallPlane")
    }
}

fun main(){
    val sp = SmallPlane("Turk")
}