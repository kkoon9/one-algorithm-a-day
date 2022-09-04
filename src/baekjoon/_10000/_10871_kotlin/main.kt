//package baekjoon._10000._10871_kotlin
//
//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.lang.StringBuilder
//import java.util.*
//
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    var token = StringTokenizer(readLine())
//    val N = token.nextToken().toInt()
//    val X = token.nextToken().toInt()
//    token = StringTokenizer(readLine())
//
//    var result = StringBuilder()
//
//    for (i in 1..N) {
//        val num = token.nextToken().toInt()
//        if (num < X) {
//            result.append(num)
//            result.append(" ")
//        }
//    }
//
//    println(result.toString())
//
//}
