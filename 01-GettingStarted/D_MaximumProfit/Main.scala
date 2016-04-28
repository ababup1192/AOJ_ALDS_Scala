import scala.io._

object Main extends App {
  val n = StdIn.readInt
  // 入力を流し込んで(最大, 最小)のタプルを書き換えて(畳み込んで)いく。
  val (max, _) = Iterator.continually(readLine()).takeWhile(_ != null)
    .foldLeft((Int.MinValue,  Int.MaxValue)){
      case ((preMax, preMin), in) =>
        val inNum = in.toInt
        val max = Math.max(preMax, inNum - preMin)
        val min = Math.min(preMin, inNum)
        (max, min)
    }
    // 最終結果のmaxを出力。
    println(max)
}
