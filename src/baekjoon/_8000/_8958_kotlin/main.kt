package baekjoon._8000._8958_kotlin

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max
import java.util.StringTokenizer

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var token = StringTokenizer(readLine())
    val count = token.nextToken().toInt()
    val scoreOfSubjects = Array(count) { 0 }
    token = StringTokenizer(readLine())
    var maxOfSubjects = -1
    var sumOfSubjects = 0
    for(i in 0 until count) {
        scoreOfSubjects[i] = token.nextToken().toInt()
        sumOfSubjects += scoreOfSubjects[i]
        maxOfSubjects = max(scoreOfSubjects[i], maxOfSubjects)
    }

    println((sumOfSubjects.toDouble() / maxOfSubjects) * 100 / count)
}