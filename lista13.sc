import scala.collection.mutable
import scala.collection.mutable.Map

class TPair[A, B](var fst: A, var snd: B) {
  override def toString = fst.toString + snd.toString
}

val pair = new TPair(4, "asdf")

//pair: TPair[Int,String] = 4asdf
//////////////////////////////////////////////////////////
trait APair {
  type A
  type B
  var fst: A
  var snd: B

  override def toString = fst.toString + snd.toString
}


val pair2 = new APair {
  override type A = String
  override type B = Int
  override var fst = "asdf"
  override var snd = 4
}


//pair2: APair{type A = String; type B = Int} = asdf4


////////////////////////////////////////////////////////

class Pracownik(val nazwisko: String) {
  var zwolniony: Boolean = false
  Pracownik.counter += 1


  def zwolnij = {
    zwolniony = true
    Pracownik.counter -= 1
  }

  def liczbaPracowników = {
    Pracownik.counter;
  }

  override def toString: String = nazwisko + ", status zwolnienia: " + zwolniony
}

object Pracownik {
  private var counter: Int = 0;
  def apply(nazwisko: String): Pracownik = new Pracownik(nazwisko)
}


val prac1 = Pracownik("michal")
val prac2 = Pracownik("kuba")
prac1.liczbaPracowników
prac2.zwolnij
prac1.liczbaPracowników
prac2.toString


/////////////////////////////////////////////////////////
class Point(private var x_pos: Double = 0, private var y_pos: Double = 0) {
  def x: Double = x_pos

  def x_=(x: Double): this.type = {
    this.x_pos = x
    this
  }

  def y: Double = y_pos

  def y_=(y: Double): this.type = {
    this.y_pos = y
    this
  }
}

class Circle(x: Double = 0, y: Double = 0, private var r_val: Double = 1) extends Point(x, y) {
  def r: Double = r_val

  def r_=(r: Double): this.type = {
    this.r_val = r
    this
  }
}

class Cylinder(x: Double = 0, y: Double = 0, r: Double = 1, private var h_val: Double = 1) extends Circle(x, y, r) {
  def h: Double = h_val

  def h_=(h: Double): this.type = {
    this.h_val = h
    this
  }
}

val cyl = new Cylinder(1, 1, 3, 4)

cyl.h_=(2).h




def wordCounter(text: String): mutable.Map[String, Int] = {
  val map: mutable.Map[String, Int] = mutable.Map().withDefaultValue(0)
  for (word <- text.split(" ")) {
    map(word) += 1;
  }
  map
}

wordCounter("Ala je kota i kota")