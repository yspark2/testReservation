package com.example.reservation

import java.lang.Exception
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val red = "\u001B[31m"

class Reservation {
    fun menu() {
        println("호텔예약 프로그램 입니다.")
        println("[메뉴]")
        var num = inputVal("num").toString()
        when (num) {
            "1" -> {
                var name = inputVal("name").toString()
                var roomNumber = inputVal("roomNumber").toString()
                var checkIn = inputVal("checkIn").toString()
            }
        }
    }

    fun inputVal(value1: String): Any? {
        return when (value1) {
            "num" -> {
                while (true) {
                    try {
                        println("1.방예약  2.예약목록출력  3.예약목록(정렬)출력  4.시스템 종료  5.금액(입금-출금)내역목록출력  6.예약 변경/취소")
                        var value2 = readLine()!!.toInt()
                        if (value2?.toInt() == 4) {
                            println("호텔 예약 시스템을 종료합니다.")
                            return System.exit(0)
                        } else if (value2 != 4 && value2 < 7) {
                            return value2
                        } else {
                            println("올바르지 않은 입력입니다. 선택영역은 1~6 이내입니다.")
                        }
                    } catch (e: Exception) {
                        println("올바르지 않은 입력입니다. 선택영역은 1~6 이내입니다.")
                    }
                }
            }
            "name" -> {
                println("예약자분의 성함을 입력해주세요.")
                var value2: String? = readLine()
                return value2
            }
            "roomNumber" -> {
                while (true) {
                    try {
                        println("예약할 방 번호를 입력해주세요.")
                        var value2 = readLine()!!.toInt()
                        if (value2 > 99 && value2 < 1000) {
                            return value2
                        } else {
                            println("올바르지 않은 방 번호 입니다. 방번호는 100 ~ 999 이내 영역입니다.")
                        }
                    } catch (e: Exception) {
                        println("올바르지 않은 방 번호 입니다. 방번호는 100 ~ 999 이내 영역입니다.")
                    }
                }
            }
            "checkIn" -> {
                var current = LocalDateTime.now()
                var formatter = DateTimeFormatter.ofPattern("yyMMdd")
                var formatted = current.format(formatter)
                while(true){
                    println("체크인 날짜를 입력해주세요. 표기형식: ${formatted} ")
                    try{
                        var value2 = readLine().toString()
                        var setValue = ValidDate().isDate(value2)
                        if(formatted.toInt() <= setValue && setValue != 0){
                            println("호텔 예약이 완료되었습니다.")
                            return setValue
                        }else{
                            println("이전날짜 또는 존재하지 않는 날짜를 입력하셨습니다. 표기형식에 맞춰 다시 입력하세요. ")
                        }
                    }catch (e: Exception){
                        println("올바르지 않은 표기형식 입니다. 표기형식에 맞춰 다시 입력하세요. ")
                    }
                }
            }
            else -> {
            }
        }
    }

}

