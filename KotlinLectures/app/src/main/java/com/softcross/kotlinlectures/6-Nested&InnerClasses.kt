package com.softcross.kotlinlectures


/**
- Class as defined in a class is known as 'Nested Class'.
- If nested classes cant marked with 'inner' keyword they be static class,
therefore they cant access upper class members.

- If nested classes marked with 'inner' keyword they can access upper class members and you can not
define nested class inside inner nested class.
 */

class LogFile {
    private val logName = "Logged ..."
    fun printFileName() = println("Hello $logName")

    class LogDetail {
        private val fileDetail = "19.03.2023, 16:08:00, User"
        fun printFileDetail() = println("Hello $fileDetail")

        init {
            //logName => Error
        }
        inner class LogAllInfo {
            init {
                //printFileName => X
                fileDetail
                printFileDetail()
            }
        }
    }
}

fun main() {
    // If nested class cant marked with 'inner' keyword it be static so accessible with Outer.Nested
    val logDetail = LogFile.LogDetail()
    // If nested class marked with 'inner' keyword, you must create new object and access on this object.
    val logAllInfo = logDetail.LogAllInfo()
}