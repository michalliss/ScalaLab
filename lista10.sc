
class CQueue[+T] private(private val xys: (List[T], List[T])) {
  def enqueue[S >: T](x: S): CQueue[S] = {
    val (xs, ys) = xys;

    (xs, x :: ys) match {
      case (Nil, ys) => new CQueue[S](ys.reverse, Nil)
      case (xs, ys) => new CQueue((xs, ys));
    }
  }

  def dequeue(): CQueue[T] = xys match {
    case (Nil, _) => this
    case (_ :: t, ys) => (t, ys) match {
      case (Nil, ys) => new CQueue[T](ys.reverse, Nil)
      case (xs, ys) => new CQueue((xs, ys));
    }
  }

  def first(): T = xys match {
    case (Nil, _) => throw new Exception
    case (h :: t, _) => h
  }

  def isEmpty = xys._1 == 0

  def print = println("1: " + xys._1 + " 2: " + xys._2);
}

object CQueue {
  def apply[T](x: T*) = new CQueue(x.toList, Nil)

  def empty[T]() = new CQueue[T]((Nil, Nil));
}

val t = CQueue(4, 3);
var t2 = t.enqueue(5);
t2 = t2.enqueue(6);
t2 = t2.enqueue(7);
t2.first()
t2 = t2.dequeue()
t2.first()




import scala.collection.mutable

def copy[T](src: mutable.Seq[T], dest: mutable.Seq[T]) = {
    var counter = 0
    src.foreach(elem =>{
      dest.update(counter, elem)
      counter += 1
    })
}
