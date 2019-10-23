def dlugosc[A](xs: List[A]): Int = {
  def dlugosc2(xs: List[A], acc: Int): Int = {
    xs match {
      case Nil => acc
      case hd::tl => dlugosc2(tl, acc+1)
    }
  }
  dlugosc2(xs, 0)
}

dlugosc(List(1,2,3,4,5))
dlugosc(List())
dlugosc(List(0,0,0,0))
dlugosc(List(1))
dlugosc(List("A","B"))