package monads

import scala.util.{Try, Success, Failure}

object TryTests extends App {

  def divide: Try[Int] = {
    val dividend = Try(Console.readLine("Int to be divided:\n").toInt)
    val divisor = Try(Console.readLine("Int to divide by:\n").toInt)

    val problem = for {
      x <- dividend
      y <- divisor
    } yield x / y

    problem match {
      case Success(v) =>
        println(s"Result of ${dividend.get}/${divisor.get} is $v")
        Success(v)
      case Failure(e) =>
        println("Divide by 0 or entered a non-integer. Try again!")
        println(s"Exception: ${e.getMessage}")
        divide
    }
  }

  divide
}