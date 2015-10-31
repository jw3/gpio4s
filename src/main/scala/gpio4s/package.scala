import akka.actor.{Actor, ActorContext, ActorRef, Props}
import com.typesafe.config.Config
import gpio4s.gpiocfg.CfgDSL._
import gpio4s.gpiocfg.CfgIO.PinCfg

package object gpio4s {
    type PinRef = ActorRef
    type PinAllocation = Map[Int, PinRef]
}
