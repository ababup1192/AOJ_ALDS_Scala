import scala.io.StdIn

object Main extends App {
  val inputs = StdIn.readLine().split(" ")
  val stack = inputs.foldLeft(new Stack()){ (acc,  elem) => acc.push(elem) }
  println(stack.pop)
}

class Stack(val elems: List[String]){
  def this() = this(Nil)

  def push: (String) => Stack = {
    case "+" =>
      val (x1, x2, xs) = pop2
      new Stack((x1 + x2).toString :: xs)
    case "-" =>
      val (x1, x2, xs) = pop2
      new Stack((x2 - x1).toString :: xs)
    case "*" =>
      val (x1, x2, xs) = pop2
      new Stack((x1 * x2).toString :: xs)
    case elem =>
      new Stack(elem :: elems)
  }

  def pop: String = elems.head

  def pop2: (Int,  Int,  List[String]) = {
    elems match {
      case x1 :: x2 :: xs =>
        (x1.toInt, x2.toInt, xs)
      case _ => (0, 0, elems)
    }
  }
}
