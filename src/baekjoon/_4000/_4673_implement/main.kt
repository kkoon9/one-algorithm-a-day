//val SIZE = 10001
//fun main() {
//       val selfNumbers = Array(SIZE) { false }
//
//       var result = StringBuilder()
//       for(number in 1 until SIZE) {
//              selfNumbers[makeSelfNumber(number)] = true
//       }
//
//       for(index in 1 until SIZE) {
//              if (!selfNumbers[index]) {
//                     result.append(index).append("\n")
//              }
//       }
//       println(result.toString())
//}
//
//
//fun makeSelfNumber(number: Int): Int {
//       val str = number.toString()
//       var sum = number
//       for(ch in str) {
//           sum += ch.digitToInt()
//       }
//       if(sum >= SIZE) sum = 0;
//       return sum
//}
