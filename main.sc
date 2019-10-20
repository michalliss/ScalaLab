def mniejsze(xs: List[Int], x: Int): Boolean = {
  if(xs.isEmpty){
    true
  }else if(xs.head >= x){
    false
  }  else mniejsze(xs.tail, x)
}


mniejsze(List(1,2,3), 4)



