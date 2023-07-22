package com.example.reservation

import java.lang.Exception
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ValidDate() {
    fun isDate(Date: String): Int {
        var dateFormat = DateTimeFormatter.ofPattern("yyMMdd")
        try {
            var date = LocalDate.parse(Date, dateFormat).toString()
            var temp = date.split("-")
            return (temp[0].substring(2, 4) + temp[1] + temp[2]).toInt()
        } catch (e: Exception) {
            return 0
        }
    }

}