import scala.io.StdIn

object Main {
  def main(args: Array[String]){
    val N = StdIn.readInt()
    val inputs = (0 to N-1).map(_ => StdIn.readInt)
    println(inputs.filter{i =>
      // forall 全ての要素が条件を満たすときtrue を利用して、素数判定
      // http://www.ne.jp/asahi/hishidama/home/tech/scala/collection/method.html
      // 篩実装は結構大変
      (2 to Math.sqrt(i).toInt).forall(i % _ != 0)
    }.length)
  }
}
