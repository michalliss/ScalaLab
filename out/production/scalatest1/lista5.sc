//zadanie 1

def lrepeat[A](k: Int, lxs: LazyList[A]) = {
  def help[A](lxs: LazyList[A], n: Int): LazyList[A] = {
    (n, lxs) match {
      case (_, LazyList()) => LazyList()
      case (0, h #:: tl) => h #:: help(tl, k - 1)
      case (n, h #:: tl) => h #:: help(lxs, n - 1)
    }
  }

  help(lxs, k - 1)
}

val res1 = lrepeat(4, LazyList(1, 2, 3, 4))
res1.force;


//zadanie 2

val lfib = {
  def help(x1: Int, x2: Int): LazyList[Int] = x2 #:: help(x2, x1 + x2)
  0 #:: help(0, 1)
}

val res2 = lfib.take(5)
res2.force

//zadanie 3

sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A];

def lBreadth[A](ltree:lBT[A]):LazyList[A] = {
  def help(queue:List[lBT[A]]):LazyList[A] = {
    queue match {
      case Nil => LazyList();
      case LEmpty::tl => help(tl)
      case LNode(elem, left, right)::tl => elem#::help(tl ::: List(left(), right()))
    }
  }
  help(List(ltree))
}

def lTree(k: Int):lBT[Int] = LNode(k, ()=>lTree(2*k), () => lTree(2*k+1))


val res3 = lBreadth(lTree(5)).take(10)
res3.force