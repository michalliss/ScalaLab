def sumProd(xs: List[Int]) = (xs.foldLeft((0, 1))) ((acc, h) => (acc._1 + h, acc._2 * h))
sumProd(List(1, 2, 3, 4))


def insertionSort[A](pred: (A, A) => Boolean, xs: List[A]) = {
  def insert(pred: (A, A) => Boolean, elem: A, xs: List[A]): List[A] = {
    xs match {
      case Nil => List(elem)
      case h :: t => if (!pred(h, elem)) elem :: xs
      else h :: insert(pred, elem, t)

    }
  }

  (xs.foldLeft(List[A]())) ((acc, elem) => insert(pred, elem, acc))
}

def isLess(first: (Int, Int), second: (Int, Int)) =
  first._1 <= second._1


insertionSort(isLess, List((1, 0), (-1, 1), (-1, 2)));



def mergesort[A](pred: (A, A) => Boolean, xs: List[A]): List[A] = {
  val length = xs.length
  if (length < 2) xs else {
    def merge(left: List[A], right: List[A]): List[A] = {
      (left, right) match {
        case (Nil, _) => right
        case (_, Nil) => left
        case (h1 :: t1, h2 :: t2) =>
          if (pred(h1, h2)) h1 :: merge(t1, right)
          else h2 :: merge(left, t2)
      }
    }


    def split(left: List[A], right: List[A], counter: Int): (List[A], List[A]) = {
      counter match {
        case 0 => (left.reverse, right)
        case _ => split(right.head :: left, right.tail, counter - 1)
      }
    }

    val (l, r) = split(List(), xs, length / 2)
    merge(mergesort(pred, l), mergesort(pred, r))

  }
}

mergesort(isLess, List((1, 0), (-1, 1), (-1, 2)))



