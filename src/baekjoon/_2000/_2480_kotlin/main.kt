import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.max

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val token = StringTokenizer(readLine())
    val dice1 = token.nextToken().toLong()
    val dice2 = token.nextToken().toLong()
    val dice3 = token.nextToken().toLong()
    var result = 0L
    if (dice1 == dice2) {
        result += 1000L
        if (dice1 == dice3) {
            result += 9000L + dice1 * 1000L;
        } else {
            result += dice1 * 100L;
        }
    } else if (dice2 == dice3) {
        result += 1000L
        if (dice1 == dice3) {
            result += 9000L + dice1 * 1000L;
        } else {
            result += dice2 * 100L;
        }
    } else if (dice1 == dice3) {
        result += 1000L
        if (dice2 == dice3) {
            result += 9000L + dice1 * 1000L;
        } else {
            result += dice1 * 100L;
        }
    } else {
        result += max(dice1, max(dice2, dice3)) * 100;
    }

    println("$result")
}
