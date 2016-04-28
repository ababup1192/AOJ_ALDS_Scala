import scala.io._

object Main extends App {
  val n = StdIn.readInt
  val list = readLine.split(" ").map(_.toInt).toList
  val sortedList = isort(list)
  println(sortedList.mkString(" "))
  // 要素xをリストxsの適当な場所に挿入する。
  def insert: (Int, List[Int]) => List[Int] = {
      case (x, Nil) => List(x)
      case (x, y :: ys) =>
        // リストの先頭よりxが小さいとき
        if(y >= x) x :: y :: ys
        // 先頭に挿入出来ない場合は
        // リストの残りの要素を挿入対象のリストとして再帰
        else y :: insert(x, ys)
  }

  def isort(list: List[Int]) : List[Int] = {
    // 実はこれではダメ グローバルな状態を持つくらいしか綺麗な状態表示はできなそう。
    println(list.mkString(" "))
    list match{
      case Nil => Nil
      // 未挿入リスト => (先頭 :: 残り) => 先頭を挿入,  残りに対して挿入ソートの再帰
      case x :: xs =>
        insert(x, isort(xs))
    }
  }
}
