package lista13

///////////////////////////////////////////////////////////
class TPair[A, B](var fst: A, var snd: B) {

  override def toString = fst.toString + snd.toString
}

//////////////////////////////////////////////////////////
trait APair {
  type A
  type B
  var fst: A
  var snd: B

  override def toString = fst.toString + snd.toString
}

object Main extends App {
  val pair = new TPair(4, "asdf")
  println(pair.getClass)

  val pair2 = new APair {
    override type T = this.type
    override var fst: this.type = _
    override var snd: this.type = _
  }
}
