package monads

object OptionTests extends App {

  def flatMapEtAl {
    val nums = (1 to 10).toList
    val sumOfSquaresOfEvens = nums.
      filter(x => x % 2 == 0).
      map(x => x * x).
      foldLeft(0)((a, b) => a + b)

    println(s"sumOfSquaresOfEvens: $sumOfSquaresOfEvens")

    // Scala options
    val optResult = Some(sumOfSquaresOfEvens)
    val doubler = Some(2)
    val notThere: Option[Int] = None

    val doubleSumOfSquaresOfEvens = optResult.flatMap(n1 => doubler.map(n2 => n1 * n2))
    println(s"doubleSumOfSquaresOfEvens: $doubleSumOfSquaresOfEvens")

    val noAnswer1 = optResult.flatMap(n1 => notThere.map(n2 => n1 * n2))
    println(s"noAnswer1: $noAnswer1")

    val noAnswer2 = optResult.flatMap(n1 =>
      doubler.flatMap(n2 =>
        notThere.map(n3 => n1 * n2 * n3)
      )
    )
    println(s"noAnswer2: $noAnswer2")
  }

  def forEtAl {
    val nums = (1 to 10).toList

    val sumOfSquaresOfEvens = (for {
      n <- nums if n % 2 == 0
    } yield n * n).sum

    println(s"sumOfSquaresOfEvens: $sumOfSquaresOfEvens")

    // Scala options
    val optResult = Some(sumOfSquaresOfEvens)
    val doubler = Some(2)
    val notThere: Option[Int] = None

    val doubleSumOfSquaresOfEvens = for {
      n1 <- optResult
      n2 <- doubler
    } yield n1 * n2

    println(s"doubleSumOfSquaresOfEvens: $doubleSumOfSquaresOfEvens")

    val noAnswer1 = for {
      n1 <- optResult
      n2 <- notThere
    } yield n1 * n2

    println(s"noAnswer1: $noAnswer1")

    val noAnswer2 = for {
      n1 <- optResult
      n2 <- doubler
      n3 <- notThere
    } yield n1 * n2 * n3

    println(s"noAnswer2: $noAnswer2")
  }

  println("flatMapEtAl...")
  flatMapEtAl

  println("forEtAl...")
  forEtAl
}