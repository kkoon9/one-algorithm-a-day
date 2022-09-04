//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.*
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val token = StringTokenizer(readLine())
//    val number = token.nextToken().toInt()
//    val sb: StringBuilder = StringBuilder()
//    for(i in 1 .. number) {
//        for(j in 1 .. number - i) {
//            sb.append(" ")
//        }
//        for(j in 1 .. i) {
//            sb.append("*")
//        }
//        sb.append("\n")
//    }
//    println(sb.toString())
//}
