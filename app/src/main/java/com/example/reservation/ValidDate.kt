package com.example.reservation

import java.lang.Exception
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class ValidDate(){
    fun isDate(Date : String ) : Boolean{
        val dateFormat = DateTimeFormatter.ofPattern("yyMMdd")
        try{
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyMMdd")
            //val dateFormat = current.format(formatter)
            val date = LocalDate.parse(Date, dateFormat)
            println("찍힌 값 ${date}")
            return true
        }catch(e: Exception){
            return false
        }
    }

}