package io.scalajs.nodejs.os

import scala.scalajs.js


/**
  * User Info Options
  * @author lawrence.daniels@gmail.com
  */

class UserInfoOptions(var encoding: js.UndefOr[String] = js.undefined,
                      var username: js.UndefOr[String] = js.undefined,
                      var shell: js.UndefOr[String] = js.undefined,
                      var homedir: js.UndefOr[String] = js.undefined)
    extends js.Object
