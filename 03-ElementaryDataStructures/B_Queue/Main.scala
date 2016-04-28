import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object Main extends App {

  val Array(n,  quantum) = StdIn.readLine().split(" ").map(_.toInt)
  val queue = Queue(quantum)

  Iterator.continually(StdIn.readLine()).takeWhile(_ != null).foreach {
    _.split(" ") match {
      case Array(pName: String,  time: String) => queue.enqueue(Data(pName,  time.toInt))
    }
  }

  Iterator.continually {
    val data = queue.dequeue()
    if (data.time == 0) {
      println(s"${data.pName} ${queue.currentTime}")
    }
    queue.isEmpty
  } forall (!_)
}

case class Queue(quantum: Int) {
  var currentTime = 0
  private[this] val queue = ArrayBuffer.empty[Data]

  def enqueue(data: Data): Unit = {
    queue.append(data)
  }

  def dequeue(): Data = {
    val data = queue.remove(0)
    val time = Math.min(quantum,  data.time)
    currentTime += time
    val newData = Data(data.pName,  data.time - time)
    if (newData.time != 0) {
      queue.append(newData)
    }
    newData
  }

  def isEmpty: Boolean = {
    queue.isEmpty
  }
}

case class Data(pName: String,  time: Int)
