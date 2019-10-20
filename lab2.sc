def dlugosc(xs: List[Int]): Int = {
  def dlugosc2(xs: List[Int], acc: Int): Int = {
    xs match {
      case Nil => acc
      case hd::tl => dlugosc2(tl, acc+1)
    }

  }
  dlugosc2(xs, 0)
}

dlugosc(List(1,2,3,4,5))