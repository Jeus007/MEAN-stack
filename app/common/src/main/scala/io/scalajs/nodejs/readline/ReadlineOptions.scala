package io.scalajs.nodejs.readline

import io.scalajs.nodejs.stream.{Readable, Writable}

import scala.scalajs.js


/**
  * Readline Options
  * @author lawrence.daniels@gmail.com
  */

class ReadlineOptions(var input: js.UndefOr[Readable] = js.undefined,
                      var output: js.UndefOr[Writable] = js.undefined,
                      var completer: js.UndefOr[js.Function] = js.undefined,
                      var terminal: js.UndefOr[Boolean] = js.undefined,
                      var historySize: js.UndefOr[Int] = js.undefined)
    extends js.Object
