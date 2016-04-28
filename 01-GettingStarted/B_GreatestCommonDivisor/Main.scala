import scala.io.StdIn

object Main{
  def main(args: Array[String]) = {
    def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
    // 束縛時Listパターンマッチ
    val (a :: b :: _) = StdIn.readLine().split(" ").map(_.toInt).toList
    println(gcd(a, b))
  }
}

