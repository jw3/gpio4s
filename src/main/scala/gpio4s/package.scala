import akka.actor.{Actor, ActorContext, ActorRef, Props}
import com.typesafe.config.Config
import gpio4s.gpiocfg.CfgDSL._
import gpio4s.gpiocfg.CfgIO.PinCfg


package object gpio4s {
    type PinRef = ActorRef
    type PinAllocation = Map[Int, PinRef]

    trait PinProducer {
        def get(num: Int)(implicit context: ActorContext): PinRef
    }

    trait DeviceInfo {
        def id: String
        def conf: Config
        def impl: Class[_ <: Device]

        final def props(pins: PinAllocation): Props = Props(impl, id, conf, pins)
    }

    /**
     * Tagging interface that identifies a Device Actor
     * A Device requires a ctor that takes
     */
    trait Device extends Actor
    object Device {
        sealed trait DeviceMessage
        case class InstallDevice(info: DeviceInfo) extends DeviceMessage
        case class DeviceInstalled(id: String, actorRef: ActorRef) extends DeviceMessage
        case class DeviceInstallFailed(id: String, e: Throwable) extends DeviceMessage
    }

    trait ModeEvent

    // pi events
    case class Configure(conf: Config)
    object Configure {
        def apply(fn: PinNumberBuilder => Unit): Configure = Configure(gpio(fn))
    }
    case class Subscribe(pin: Int)
    case class Unsubscribe(pin: Int)

    // pin events
    case class DigitalWrite(pin: Int, state: Boolean)
    case class DigitalRead(pin: Int)

    private[gpio4s] case class Reset(pin: Int) extends ModeEvent
    private[gpio4s] case class Setup(pin: PinCfg) extends ModeEvent

    // responses
    case class DigitalEvent(pin: Int, state: Boolean)
}
