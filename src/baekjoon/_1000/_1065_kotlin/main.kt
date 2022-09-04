//import java.io.BufferedReader
//import java.io.InputStreamReader
//import java.util.StringTokenizer
//
//fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
//    val token = StringTokenizer(readLine())
//    val number = token.nextToken().toInt()
//    var result = 0
//
//    for (num in 1..number) {
//        if (isHanSu(num)) {
//            result += 1
//        }
//    }
//
//    println(result)
//}
//
//
//fun isHanSu(number: Int): Boolean {
//    if (number < 100) {
//        return true
//    }
//    val str = number.toString()
//    val diff = str[1] - str[0]
//    for (index in 2 until str.length) {
//        if (str[index] - str[index - 1] != diff) {
//            return false
//        }
//    }
//
//    return true
//}
