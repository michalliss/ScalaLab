class CQueue[+T] private(private val xys: (List[T], List[T])) {
  def toNormal[S >: T](xs: List[S], ys: List[S]) = (xs, ys) match {
    case (Nil, ys) => new CQueue[S](ys.reverse, Nil)
    case queue => new CQueue((xs, ys));
  }

  def enqueue[S >: T](x: S): CQueue[S] = {
    val (xs, ys) = xys;
    toNormal(xs, x :: ys)
  }

  def dequeue(): CQueue[T] = xys match {
    case (Nil, _) => this
    case (h :: t, ys) => toNormal(t, ys)
  }

  def first[S >: T]: T = xys match {
    case (Nil, _) => throw new Exception
    case (h :: t, _) => h
  }

  def isEmpty = xys._1 == 0

  def print = println("1: " + xys._1 + " 2: " + xys._2);
}

object CQueue {
  def empty[T]() = new CQueue[T]((Nil, Nil));
}

val t = CQueue.empty();
var t2 = t.enqueue(5);
t2 = t2.enqueue(6);
t2 = t2.enqueue(7);
t2.print



