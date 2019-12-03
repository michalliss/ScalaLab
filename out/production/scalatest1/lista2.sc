def fib(x: Int): Int = {
  x match {
    case 0 => 1
    case 1 => 1
    case _ => fib(x - 1) + fib(x - 2)
  }
}

def fibTail(x: Int): Int = {
  def fibTail2(x1: Int, x2: Int, n: Int): Int = {
    if (n == 0) x2 else fibTail2(x2, x1 + x2, n - 1)
  }

  fibTail2(0, 1, x)
}



def root3(x: Double): Double = {
  def root3in(a: Double, x0: Double): Double = {
    math.abs((x0 * x0 * x0) - a) <= 10.0E-5 * math.abs(a) match {
      case true => x0
      case false => root3in(a, x0 + (a / (x0 * x0) - x0) / 3)
    }
  }

  if (x > 1) root3in(x, x / 3) else root3in(x, x)
}

val x = root3(5)



val _ :: _ :: x :: _ = List(-2, -1, 0, 1, 2)
val _ :: (x, _) :: _ = List((1, 2), (0, 1))


def initSegment[A](xs: List[A], ys: List[A]): Boolean = {
  (xs, ys) match {
    case (Nil, _) => true
    case (h :: t, Nil) => false
    case (h1 :: t1, h2 :: t2) => if (h1 == h2) initSegment(t1, t2) else false
  }
}



def replaceNth[A](xs: List[A], count: Int, elem: A): List[A] = {
  if (count < 0) xs
  else (xs, count) match {
    case (Nil, _) => xs
    case (h::t, 0) => elem::t
    case (h::t, _) => h::replaceNth(t, count-1, elem)
  }
}



