// TODO 細かい調整未完成
import scala.io.StdIn

object Main extends App {
  val n = StdIn.readInt()
  val cardPattern = """(\w)(\d+)""".r
  val origList = StdIn.readLine().split(" ")
    .map { case cardPattern(suit, number) =>
      Card(suit.head, number.toInt)
    }.toList

    val bList = bsort(origList)
    val sList = ssort(origList)

    println(bList.mkString(" "))
    println("Stable")
    println(sList.mkString(" "))
    if (bList == sList) {
      println("Stable")
    } else {
      println("Not stable")
    }

    def foward: (List[Card]) => List[Card] = {
      case Nil => Nil
      case List(x) => List(x)
      // x :: xs を listという変数に束縛
      case list @ x :: xs =>
        // もちろん list.min というListの最小値を求める関数もアリ
        val minValue = list.foldLeft(Card('',  Int.MaxValue){(preMin, nCard) =>
          Math.min(preMin, n.number)
        }
        if(x.number != minValue){
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

    case class Card(suit: Char, number: Int) {
      override def toString = s"$suit$number"
    }
}
