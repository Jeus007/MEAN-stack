package io.scalajs.nodejs.timers

import scala.scalajs.js

/**
  * Stops an intervalObject, as created by setInterval, from triggering.
  * @example clearInterval(intervalObject)
  */
@js.native
trait ClearInterval extends js.Object {

  /**
    * Stops an interval, as created by setInterval, from triggering.
    * @example clearInterval(intervalObject)
    */
  def apply(handle: Interval): Unit = js.native

}
