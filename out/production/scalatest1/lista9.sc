
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
