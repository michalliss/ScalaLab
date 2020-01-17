

trait Debug {
  def debugName(): String = {
    "Klasa: " + getClass.getName
  }

  def debugVars(): String = {
    var s = ""
    var f = getClass.getDeclaredFields
    for(e <- f){
      e.setAccessible(true)
      try{
        s = s + e.getName + " -> " + e.getType + " = " + e.get(this) + "\n"
      }catch{
        case e: Exception => " "
      }

    }
    s
  }
}


class Point(xv: Int, xy: Int) extends Debug {
  var x: Int = xv
  var y: Int = xy
  var a: String = "test"
}


var p = new Point(3, 4)
p.debugName()
p.debugVars()