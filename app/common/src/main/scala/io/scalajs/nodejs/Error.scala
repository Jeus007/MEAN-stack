package io.scalajs.nodejs

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSGlobal, JSImport}

/**
  * Creates a new Error object and sets the error.message property to the provided text message.
  * If an object is passed as message, the text message is generated by calling message.toString().
  * The error.stack property will represent the point in the code at which new Error() was called.
  * Stack traces are dependent on V8's stack trace API. Stack traces extend only to either (a) the
  * beginning of synchronous code execution, or (b) the number of frames given by the property
  * Error.stackTraceLimit, whichever is smaller.
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSImport("errors", "Error")
class Error(message0: String = js.native) extends js.Object {

  /**
    * The error.message property is the string description of the error as set by calling new Error(message).
    * The message passed to the constructor will also appear in the first line of the stack trace of the Error,
    * however changing this property after the Error object is created may not change the first line of the
    * stack trace (for example, when error.stack is read before this property is changed).
    */
  val message: String = js.native

  /**
    * The error.stack property is a string describing the point in the code at which the Error was instantiated.
    */
  val stack: js.Any = js.native

}

/**
  * Error Singleton
  * @author lawrence.daniels@gmail.com
  */
@js.native
@JSGlobal
object Error extends js.Object {

  /////////////////////////////////////////////////////////////////////////////////
  //      Properties
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Error.stackTraceLimit
    */
  def stackTraceLimit: Int = js.native

  /////////////////////////////////////////////////////////////////////////////////
  //      Methods
  /////////////////////////////////////////////////////////////////////////////////

  /**
    * Creates a .stack property on targetObject, which when accessed returns a string representing the location in the
    * code at which Error.captureStackTrace() was called.
    * @param targetObject   The first line of the trace, instead of being prefixed with ErrorType: message, will be the
    *                       result of calling targetObject.toString().
    * @param constructorOpt The optional constructorOpt argument accepts a function. If given, all frames above
    *                       constructorOpt, including constructorOpt, will be omitted from the generated stack trace.
    *                       The constructorOpt argument is useful for hiding implementation details of error generation
    *                       from an end user.
    * @example Error.captureStackTrace(targetObject[, constructorOpt])
    */
  def captureStackTrace(targetObject: js.Any, constructorOpt: js.Any = js.native): Unit = js.native

}