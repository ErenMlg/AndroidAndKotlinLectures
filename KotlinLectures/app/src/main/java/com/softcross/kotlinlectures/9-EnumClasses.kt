package com.softcross.kotlinlectures

/**
- Enum classes is Enumeration on the software. They are used for clean code.
How they to this?
Sample:
if(userType == "Admin"){}
else if(userType == "Member"){}
else if(userType == "Student"){}
if we use enums;
enum class USER_TYPE {
ADMIN, USER, SUPER_ADMIN
}
if (type == USER_TYPE.ADMIN) {}
else if (type == USER_TYPE.USER) {}
- Easy explanation is used for handle states, types. Constant is created for each state.
- If enum classes have property on constructor, each constants must take this parameter.
- Classes can not implemented by enums but interface can implemented by enums.
Implemented interfaces methods, must be override on enum classes inside or on all constants
- Enum classes can not inherited.
 */

enum class Direction(var distance:Int) {
    NORTH(0), SOUTH(0), WEST(0), EAST(0)
}

// Non-ordinal Enum
enum class Paint(var orderNumber: Int) : BasicColors, BlendingColors {
    MONA_LISA(0) {
        override fun getPaint(): Paint = MONA_LISA
        override fun draw(color: String) {
            println("Mona Lisa Printed With $color")
        }

        override fun toString(): String {
            return "printed Mona Lisa, order number: $orderNumber"
        }
    },
    STAR(1) {
        override fun getPaint(): Paint = STAR
        override fun draw(color: String) {
            println("Star Printed With $color")
        }

        override fun toString(): String {
            return "printed Star, order number: $orderNumber"
        }
    },

    SUN(2) {
        override fun getPaint(): Paint = SUN
        override fun draw(color: String) {
            println("Sun Printed With $color")
        }

        override fun toString(): String {
            return "printed Sun, order number: $orderNumber"
        }
    },
    STREET(3) {
        override fun getPaint(): Paint = STREET
        override fun draw(color: String) {
            println("Street Printed With $color")
        }

        override fun toString(): String {
            return "printed Street, order number: $orderNumber"
        }
    };

    /**
    - Enum constants can declare their own anonymous classes with their corresponding methods,
    as well as with overriding base methods.
     */
    abstract fun getPaint(): Paint

    override fun blend(color: String, color2: String) {
        println("Colors blended. $color and $color2")
    }
}

interface BasicColors {
    fun draw(color: String)
}

interface BlendingColors {
    fun blend(color: String, color2: String)
}

enum class Lessons {
    MATH, SCIENCE, COMPUTER, PHYSIC, BIOLOGY, CHEMICAL, MUSIC, ART
}

fun main() {
    for (lesson in Lessons.entries) println(lesson.toString()) // prints MATH, SCIENCE, COMPUTER, PHYSIC, BIOLOGY, CHEMICAL, MUSIC, ART
    println("The first lesson is: ${Lessons.valueOf("MATH")}") // prints "The first lesson is: MATH"
    println(Lessons.MATH.name)    // prints MATH
    println(Lessons.PHYSIC.ordinal) // prints 3
}
