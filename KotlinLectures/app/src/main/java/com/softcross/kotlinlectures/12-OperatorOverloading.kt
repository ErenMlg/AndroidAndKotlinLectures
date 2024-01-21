package com.softcross.kotlinlectures

/**
     - In kotlin available calculate operators; (This operators can different behaviors can be acquired)

     - x1 + x2	        x1.plus(x2)
     - x1 – x2	        x1.minus(x2)
     - x1 * x2	        x1.times(x2)
     - x1/ x2	        x1.div(x2)
     - x1 % x2	        x1.rem(x2)
     - x1..x2	        x1.rangeTo(x2)
     - x1 in x2	        x2.contains(x1)
     - x1 !in x2	    !x2.contains(x1)
     - x[i]	            x.get(i)
     - x[i, j]	        x.get(i, j)
     - x[i] = b	        x.set(i, b)
     - x[i, j] = b	    x.set(i, j, b)
     - x()	            x.invoke()
     - x(i)	            x.invoke(i)
     - x(i, j)	        x.invoke(i, j)
     - +x1              x1.unaryPlus()
     - -x1              x1.unaryMinus()
     - x1 += x2	        x1.plusAssign(x2)
     - x1 -= x2	        x1.minusAssign(x2)
     - x1 *= x2	        x1.timesAssign(x2)
     - x1 /= x2	        x1.divAssign(x2)
     - x1 %= x2	        x1.remAssign(x2)
*/

data class Calc(val x: Int, val y: Int) {
    operator fun invoke() = "X:$x Y:$y"
}

operator fun Calc.plus(other: Calc): Calc {
    return Calc(x + other.x, y + other.y)
}

operator fun Calc.minus(other: Calc): Calc {
    return Calc(x - other.x, y - other.y)
}

fun main(){
    val point = Calc(3,5)
    point.invoke()
    point.plus(Calc(4,5))
}



