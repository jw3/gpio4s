package gpio4s

import com.typesafe.config.Config
import gpio4s.gpiocfg.CfgDSL._
import gpio4s.gpiocfg.CfgIO.PinCfg


// service events
case class Configure(conf: Config)
object Configure {
    def apply(fn: PinNumberBuilder => Unit): Configure = Configure(gpio(fn))
}
case class Subscribe(pin: Int)
case class Unsubscribe(pin: Int)

// pin events
case class DigitalWrite(pin: Int, state: Boolean)
case class DigitalRead(pin: Int)

trait ModeEvent
private[gpio4s] case class Reset(pin: Int) extends ModeEvent
private[gpio4s] case class Setup(pin: PinCfg) extends ModeEvent

// responses
case class DigitalEvent(pin: Int, state: Boolean)
