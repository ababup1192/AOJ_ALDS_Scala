import scala.io.StdIn
import scala.annotation.tailrec

case class Process(name: String, time: Int){
  override def toString(): String = s"$name $time"
}

object Main extends App {
  val Array(_, quantum) = StdIn.readLine().split(" ").map(_.toInt)

  val queue = Iterator.continually(StdIn.readLine()).takeWhile(_ != null).foldLeft(Queue.empty) {
    (queue, line) => {
      line.split(" ") match {
        case Array(name: String,time: String) => queue.enqueue(Process(name, time.toInt))
      }
    }
  }

  @tailrec
  def loop(queue: Queue, out: Vector[Process] = Vector(), curTime: Int = 0): Vector[Process] = {
    if(queue.isEmpty) out
    else {
      val(process, nextQueue) = queue.dequeue
      if(process.time > quantum){
        loop(nextQueue.enqueue(process.copy(time = process.time - quantum)), out, curTime + quantum)
      }else{
        loop(
          nextQueue,
          out :+ process.copy(time = curTime + process.time),
          curTime + process.time
        )
      }
    }
  }

  println(loop(queue).mkString("\n"))
}

class Queue private(val in: List[Process], val out: List[Process]){
  def enqueue(elem: Process) = new Queue(elem :: in, out)

  def dequeue: (Process, Queue) = out match {
    case Nil if !in.isEmpty => val rev = in.reverse ; (rev.head, new Queue(Nil, rev.tail))
    case x :: xs            => (x, new Queue(in, xs))
    case _                  => throw new NoSuchElementException("dequeue on empty queue")
  }

  def isEmpty: Boolean = in.isEmpty && out.isEmpty

  override def toString() = in.toString
}

object Queue {
  def empty: Queue = new Queue(Nil, Nil)
  def apply(xs: Process*): Queue = new Queue(Nil, xs.toList)
}
