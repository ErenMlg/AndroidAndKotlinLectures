package com.softcross.kotlinlectures

interface Remove {
    fun removeText()
}

interface Edit {
    var text: String
    fun editText()
}

fun main() {
    /**
    - Delegation is transfer a object work to another object.
    - The Delegation pattern has proven to be a good alternative to implementation inheritance,
    and Kotlin supports it natively requiring zero boilerplate code.
     **/

    //Explicit Delegation
    class SpecialRemover : Remove {
        override fun removeText() { TODO() }
    }
    open class UserInfo() {
        open fun show() { TODO() }
    }

    class Screen(private val userInfo: UserInfo, private val remove: Remove) {
        fun show() {
            userInfo.show()
        }
        fun destroy() {
            remove.removeText()
        }
    }

    // Kotlin provide delegation work as implicit, provide class delegation and delegated properties features
    class DatabaseEditor : Edit {
        override var text: String = "databaseEditter"
        override fun editText() { TODO() }
    }

    // This delegated with by, its mean can access given nameable as directly,
    // we can directly override functions inside given classes without write function
    class DatabaseDelegation(name: Edit, remove: Remove) : Edit by name, Remove by remove {
        override fun editText() { TODO() }
        // override fun removeText() { TODO() }
        override var text: String
            get() = TODO()
            set(value) {}
    }


}