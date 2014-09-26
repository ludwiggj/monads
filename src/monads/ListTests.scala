package monads

object ListTests extends App {
  val numbers: List[Int] = (1 to 10).toList
  println(s"numbers $numbers")

  val total = numbers.map(x => x * 5)
  println(s"numbers * 5: $total")

  val mappedTotal: List[List[Int]] = numbers.map(n1 => numbers.map(n2 => n1 * n2))
  println(s"numbers * numbers (map): $mappedTotal")

  val flatMappedTotal = numbers.flatMap(n1 => numbers.map(n2 => n1 * n2)).sum
  println(s"numbers * numbers (flatMap): $flatMappedTotal")

  // Now using for...

  val forTotal = (for {
    n1 <- numbers
    n2 <- numbers
  } yield n1 * n2).sum
  println(s"numbers * numbers (forTotal): $forTotal")
}