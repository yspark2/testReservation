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

    fun inputVal(x: String): Any? {
        return when (x) {
            "num" -> {
                while (true) {
                    try {
                        println("1.방예약  2.예약목록출력  3.예약목록(정렬)출력  4.시스템 종료  5.금액(입금-출금)내역목록출력  6.예약 변경/취소")
                        var y = readLine()!!.toInt()
                        if (y?.toInt() == 4) {
                            println("호텔 예약 시스템을 종료합니다.")
                            return System.exit(0)
                        } else if (y != 4 && y < 7) {
                            return y
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
                var y: String? = readLine()
                return y
            }
            "roomNumber" -> {
                while (true) {
                    try {
                        println("예약할 방 번호를 입력해주세요.")
                        var y = readLine()!!.toInt()
                        if (y > 99 && y < 1000) {
                            return y
                        } else {
                            println("올바르지 않은 방 번호 입니다. 방번호는 100 ~ 999 이내 영역입니다.")
                        }
                    } catch (e: Exception) {
                        println("올바르지 않은 방 번호 입니다. 방번호는 100 ~ 999 이내 영역입니다.")
                    }
                }
            }
            "checkIn" -> {
//                체크인 날짜는 지금 날짜와 비교해서 이전날짜는 입력받을 수 없고
//                체크아웃 날짜는 체크인 날짜보다 이전이거나 같을 수는 없어요
                val current = LocalDateTime.now()
                val formatter = DateTimeFormatter.ofPattern("yyMMdd")
                val formatted = current.format(formatter)
                while(true){
                    println("체크인 날짜를 입력해주세요. 표기형식: ${formatted} ")
                    try{
                        var y = readLine().toString()
                        var setValue : Boolean = ValidDate().isDate(y)
                        if(setValue == true){
                            return y
                        }else{
                            // 수정 필요
                            println("올바르지 않은 표기형식 입니다. 표기형식에 맞춰 다시 입력하세요. ")
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

