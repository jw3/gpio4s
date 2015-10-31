package gpio4s

import akka.actor.ActorContext

/**
 * Provider of [[PinRef]] for a giving pin number
 */
trait PinProducer {
    def get(num: Int)(implicit ctx: ActorContext): PinRef
}
