package builders

sealed trait PaginationValue {
  def argument: String
}

case class First(number: Int) extends PaginationValue {
  override val argument: String = s"first:$number"
}

case class Last(number: Int) extends PaginationValue {
  override val argument: String = s"last:$number"
}
