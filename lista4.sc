//zadanie 3
sealed trait BT[+A]

case object Empty extends BT[Nothing]

case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

def breadthBTtail[A](tt: BT[A]) = {
  def breadthBTHelper[A](queue: List[BT[A]], resList: List[A]): List[A] = {
    queue match {
      case Nil => resList.reverse
      case Empty :: t => breadthBTHelper(t, resList)
      case Node(value, left, right) :: t => breadthBTHelper(t ::: List(left, right), value :: resList)
    }
  }

  breadthBTHelper(List(tt), List())
}


def breadthBT[A](tt: BT[A]) = {
  def breadthBTHelper[A](queue: List[BT[A]]): List[A] = {
    queue match {
      case Nil => Nil
      case Empty :: t => breadthBTHelper(t)
      case Node(value, left, right) :: t => value :: breadthBTHelper(t ::: List(left, right))
    }
  }

  breadthBTHelper(List(tt))
}

val tt = Node(1,
  Node(2,
    Node(4,
      Empty,
      Empty
    ),
    Empty
  ),
  Node(3,
    Node(5,
      Empty,
      Node(6,
        Empty,
        Empty
      )
    ),
    Empty
  )
);
;


breadthBT(tt)


//zadanie 4


def wewSciezka[A](tt: BT[A]) = {
  def wewSciekaHelp(depth: Int, curr: BT[A]): Int = {
    curr match {
      case Empty => 0
      case Node(value, left, right) => depth + wewSciekaHelp(depth + 1, left) + wewSciekaHelp(depth + 1, right)
    }
  }

  wewSciekaHelp(0, tt)
}

wewSciezka(tt)


def zewSciezka[A](tt: BT[A]) = {
  def zewSciekaHelp(depth: Int, curr: BT[A]): Int = {
    curr match {
      case Empty => depth
      case Node(value, left, right) => zewSciekaHelp(depth + 1, left) + zewSciekaHelp(depth + 1, right)
    }
  }

  zewSciekaHelp(0, tt)
}

zewSciezka(tt)

//zadanie 5

sealed trait Graphs[A]

case class Graph[A](succ: A => List[A]) extends Graphs[A]

val g = Graph((i: Int) => i match {
  case 0 => List(3)
  case 1 => List(0, 2, 4)
  case 2 => List(1)
  case 3 => Nil
  case 4 => List(0, 2)
  case n => throw new Exception("Graph g: node " + n
    + " doesn't exist")
})



def depthSearch[A](gfunc: Graph[A])(start: A) = {
  def depthSearchHelp(visited: List[A], curr: List[A]): List[A] = {
    curr match {
      case Nil => Nil
      case h :: t => if (visited.contains(h)) depthSearchHelp(visited, t) else h :: depthSearchHelp(h :: visited, (gfunc succ h) ::: t)
    }
  }

  depthSearchHelp(List(), List(start))
}


depthSearch(g)(4)