
class Time(private var h: Int) {
  if (h < 0) h = 0

  def hour: Int = h

  def hour_=(newHour: Int) {
    if (newHour < 0) h = 0
    else h = newHour
  }

}

object Time {
  def apply(h: Int): Time = new Time(h)
}


//ZAD2----------------------------------------------------------------------------------------

class Time2(private var h: Int, private var m: Int) {
  require(0 <= h && h < 24)
  require(0 <= m && h < 60)

  def hour: Int = h

  def hour_=(newHour: Int) {
    require(0 <= newHour && newHour < 24, "newHour=" + newHour)
    h = newHour
  }

  def minute: Int = h

  def minute_=(newMinute: Int) {
    require(0 <= newMinute && newMinute < 60, "newMinute=" + newMinute)
    m = newMinute
  }

  def before(other: Time2): Boolean = {
    h < other.h || (h == other.h && m < other.m)
  }

}


class Time3(h: Int, m: Int) {
  require(0 <= h && h < 24)
  require(0 <= m && h < 60)

  private var t = h * 60 + m

  def hour: Int = t / 60

  def hour_=(newHour: Int) {
    require(0 <= newHour && newHour < 24)
    t = newHour * 60 + minute
  }

  def minute: Int = t % 60

  def minute_=(newMinute: Int) {
    require(0 <= newMinute && newMinute < 60)
    t = hour * 60 + newMinute
  }

  def before(other: Time3): Boolean = {
    t < other.t
  }
}


var t = new Time3(12, 32);

t.hour
t.minute

t.minute = 3
t.hour
t.minute


//ZAD3--------------------------------------------------------------------------------------
class Pojazd(val producent: String, val model: String, val rok: Int = -1, var numRej: String = "") {
  def this(producent: String, model:String, numRej: String){
    this(producent, model,-1, numRej)
  }
}

var p1 = new Pojazd("polonez", "201", "123333")



//ZAD4------------------------------------------------------------------------------------------
object UzycieWyjatkow{
  def main(args: Array[String]): Unit = {
    try metoda1()
    catch {
      case e: Exception =>
        System.err.println(e.getMessage + "\n")
        e.printStackTrace()
    }
  }

  @throws[Exception]
  def metoda1(): Unit = {
    metoda2()
  }

  @throws[Exception]
  def metoda2(): Unit = {
    metoda3()
  }

  @throws[Exception]
  def metoda3(): Unit = {
    throw new Exception("Wyjatek zgloszony w metoda3")
  }
}

UzycieWyjatkow.main(null)

/*
Wyjatek zgloszony w metoda3
java.lang.Exception: Wyjatek zgloszony w metoda3
at $line12.$read$$iw$$iw$UzycieWyjatkow$.metoda3(<console>:24)
at $line12.$read$$iw$$iw$UzycieWyjatkow$.metoda2(<console>:19)
at $line12.$read$$iw$$iw$UzycieWyjatkow$.metoda1(<console>:14)
at $line12.$read$$iw$$iw$UzycieWyjatkow$.main(<console>:4)
 */