package gpio4s

/**
 * Describes a GPIO Controller
 */
trait ControllerInfo {
    val pins: List[Int]
}

object ControllerInfo {
    /**
     * Raspberry Pi Model B revision 2 P1 header only
     */
    object PiBrev2 extends ControllerInfo {
        val pins: List[Int] = 0 to 16 toList
    }

    /**
     * Raspberry Pi Model B revision 2, including P5 header
     */
    object PiBrev2wP5 extends ControllerInfo {
        val pins = PiBrev2.pins ::: (17 to 20).toList
    }

    /**
     * Raspberry Pi A+
     */
    object PiAplus extends ControllerInfo {
        val pins: List[Int] = PiBrev2.pins ::: (21 to 29).toList
    }

    /**
     * Raspberry Pi B+
     */
    object PiBplus extends ControllerInfo {
        val pins = PiAplus.pins
    }

    /**
     * Raspberry Pi 2 Model B
     */
    object Pi2b extends ControllerInfo {
        val pins = PiAplus.pins
    }
}
