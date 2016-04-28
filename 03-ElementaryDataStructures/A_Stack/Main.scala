import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Main extends App {
  val inputList = StdIn.readLine().split(" ").map {
    str =>
      try {
        str.toInt
      } catch {
        case e: NumberFormatException =>
          str
      }
  }.toList

  val stack = new Stack

  inputList.foreach { elm =>
    stack.push(elm)
  }
  println(stack.pop())
}

class Stack {
  val array = ArrayBuffer.empty[Int]

  def push(elm: Any): Unit = {
    elm match {
      case n: Int =>
        array += n
      case str: String =>
        val (o1,  o2) = pop2()
        str match {
          case "+" =>
            push(o2 + o1)
          case "-" =>
            push(o2 - o1)
          case "*" =>
            push(o2 * o1)
        }
    }
  }

  def pop(): Int = {
    array.remove(array.length - 1)
  }

  def pop2(): (Int,  Int) = {
    (pop(),  pop())
  }
}
