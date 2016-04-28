import scala.io._

object Main extends App {
  val n = StdIn.readInt
  val list = readLine.split(" ").map(_.toInt).toList
  val sortedList = ssort(list)
  println(sortedList.mkString(" "))

  def foward: (List[Int]) => List[Int] = {
    case Nil => Nil
    case List(x) => List(x)
    // x :: xs を listという変数に束縛
    case list @ x :: xs =>
      // もちろん list.min というListの最小値を求める関数もアリ
      val minValue = list.foldLeft(Int.MaxValue){(preMin, n) => Math.min(preMin, n)}
      if(x != minValue){
        // 最小値を先頭にし、残りの要素は元のリストから最小値のdiff(集合の差)を取ったリスト。
        minValue :: (list diff List(minValue))
      }else{
        list
      }
  }

  def ssort: (List[Int]) => List[Int] = {
    case Nil => Nil
    case List(x) => List(x)
    case xs =>
      val (y :: ys) = foward(xs)
      y :: ssort(ys)
  }
}
