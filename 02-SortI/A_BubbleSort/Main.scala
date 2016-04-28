import scala.io._

object Main extends App {
  val n = StdIn.readInt
  val list = readLine.split(" ").map(_.toInt).toList
  val sortedList = bsort(list)
  println(sortedList.mkString(" "))

  // 関数リテラルにして、matchを省略
  // http://www.ne.jp/asahi/hishidama/home/tech/scala/match.html#h_omit
  def bswap: (List[Int]) => List[Int] = {
    case Nil => Nil
    case List(x) => List(x)
    case x :: xs =>
      // バインド時パターンマッチ(なんて言うんだろ？)
      val y :: ys = bswap(xs)
      // swap
      if(x>y){
        y :: x :: ys
      }
      else{
        x :: y :: ys
      }
  }

  def bsort: (List[Int]) => List[Int] = {
    case Nil => Nil
    case List(x) => List(x)
    case xs =>
      val y :: ys = bswap(xs)
      y :: bsort(ys)
  }
}
