package com.example.reservation

import java.lang.Exception
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ValidDate(){
    fun isDate(date: String): Int {
        var dateFormat = DateTimeFormatter.ofPattern("yyyyMMdd")
        try {
            var date = LocalDate.parse(date, dateFormat).toString()
            var temp = date.split("-")
            return (temp[0].substring(0, 4) + temp[1] + temp[2]).toInt()
        } catch (e: Exception) {
            return 0
        }
    }
}

//class SplitString(date: String ) : Int {
//    var temp = date.split("-")
//    return (temp[0].substring(0, 4) + temp[1] + temp[2]).toInt()
//}