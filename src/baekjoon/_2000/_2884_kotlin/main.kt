//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.*
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val token = StringTokenizer(readLine())
//    val H = token.nextToken().toLong()
//    val M = token.nextToken().toLong()
//
//    val alarm = alarmAhead45Minutes(M, H)
//
//    println("${alarm.hours} ${alarm.minutes}")
//}
//
//fun alarmAhead45Minutes(M: Long, H: Long): Time {
//    var minutes = M
//    var hours = H
//    if (M.minus(45) < 0) {
//        hours = H.minus(1)
//        if (hours < 0) {
//            hours = 23;
//        }
//        minutes = 60 + M.minus((45))
//    } else {
//        minutes = M.minus(45)
//    }
//    return Time(hours, minutes)
//}
//
//data class Time(
//    val hours: Long,
//    val minutes: Long
//)
//
