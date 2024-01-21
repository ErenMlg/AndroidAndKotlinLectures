package com.softcross.kotlinlectures

/**
- Sometimes you need to create an object that is a slight modification of some class,
without explicitly declaring a new subclass for it.Kotlin can handle this with object expressions
and object declarations.

- Object expressions create objects of anonymous classes, that is,
classes that aren't explicitly declared with the class declaration. Such classes are useful for one-time use.
Anonymous classes objects named as 'anonymous object'

- Object expressions start with the 'object' keyword.
 */

val helloWorld = object {
    val hello = "Hello"
    val world = "World"

    // object expressions extend Any, so `override` is required on `toString()`
    override fun toString() = "$hello $world"
}

/*
                    OBJECT EXPRESSION
        window.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                clickCount++
            }

            override fun mouseEntered(e: MouseEvent) {
                enterCount++
            }
        })
 */

abstract class EventListener {
    abstract fun onClick()
    abstract fun onDoubleClick()
    abstract fun onTouch()
}

interface BluetoothListener {
    fun onConnected()
    fun onLowEnergy()
    fun onDisconnected()
}

class BluetoothService {

    private var bluetoothListener: BluetoothListener? = null

    fun setBluetoothListener(bluetoothListener: BluetoothListener?) {
        this.bluetoothListener = bluetoothListener
    }

    fun connect() {
        bluetoothListener?.onConnected()
    }

    fun disconnect() {
        bluetoothListener?.onDisconnected()
    }

    fun informLowEnergy() {
        bluetoothListener?.onLowEnergy()
    }
}

/**
 - Object declarations usually used for the singleton pattern-
 - Singleton Pattern: Create one object and use everywhere this.
 */

object Database {

    /**
     - Double checked locking don't provide guarantee everytime. Volatile keyword, tell this variable
     can change with asynchronous working threads.

     Double checked locking on java;
     if (resource == null) {
         synchronized (lock) {
             if (resource == null) {
                resource = initializeResource();
             }
         }
     }
     */
    @Volatile
    private var connection: Connection? = null
    /**
     - To access this functions by java used Database.INSTANCE.getConnection() expression, but
     @JvmStatic annotation make this connection to static for used to without INSTANCE by java
     */
    @JvmStatic
    fun getConnection(): Connection {
        if (connection == null) {
            /**
             - One thread can created instance but another thread can pass first check,
             so this works must be synchronized. In this code if connection is null,
             synchronized is will lock this and guaranteed connection is null to second control
             state and if connection null object will be create.
             */
            synchronized(Database::class.java) {
                if (connection == null) {
                    connection = Connection()
                }
            }
        }
        return connection!!
    }
}


class Connection

/**
 - In kotlin when we want print to object, output give us ObjectName@HashCode. If we want to print
  special type, we should override toString() method but if we want we can mark with 'data' keyword
  and directly print as ObjectName.
  - Data objects can not take equals and hashcode implementation
 */

data object Info

/**
 - Objects can define in a class, but access to objects method, should use objects name. Companion
 objects for directly access method on class name.
 */

class MyClass {

    object MyObject {
        fun newInstance() = MyClass()
    }

    companion object MyCompanionObject {
        @JvmStatic
        fun newInstance() = MyClass()
    }
    /**
     * However, on the JVM you can have members of companion objects generated
     * as real static methods and fields if you use the @JvmStatic annotation.
     */

    // Companion object can implement interfaces, classes, abstract classes...
    /*companion object : CompanionInterface {
        override fun createInstance(): MyClass {
            return MyClass()
        }
    }*/
}

interface CompanionInterface {
    fun createInstance(): MyClass
}

/**
 - Object expressions are executed (and initialized) immediately, where they are used.
 - Object declarations are initialized lazily, when accessed for the first time.
 - A companion object is initialized when the corresponding class is loaded (resolved)
 that matches the semantics of a Java static initializer.
 */

fun main() {
    println(helloWorld)

    val deviceName = "Blueetoooth"

    /**
     - Instant object expression without creating another object to make the anonymous class function.
     */
    val eventListener = object : EventListener() {
        override fun onClick() {

        }

        override fun onDoubleClick() {

        }

        override fun onTouch() {

        }
    }

    val bluetoothListener = object : BluetoothListener {
        override fun onConnected() {
            println("Connected. We are in at $deviceName!")
        }

        override fun onLowEnergy() {
            println("Low Energy. Please charge $deviceName")
        }

        override fun onDisconnected() {
            println("Disconnected $deviceName!")
        }
    }

    val bluetoothService = BluetoothService().apply {
        setBluetoothListener(bluetoothListener)
    }

    bluetoothService.connect()
    bluetoothService.informLowEnergy()
    bluetoothService.disconnect()

    println(Info)

    MyClass.MyObject.newInstance()
    // Companion Object
    // If companion object named, don't necessary used when reaching it.
    MyClass.MyCompanionObject.newInstance()
    MyClass.newInstance()
}


