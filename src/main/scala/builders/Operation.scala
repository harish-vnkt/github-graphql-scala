package builders

sealed trait Operation {
  def argument: String
}

case class GreaterThan(number: Int) extends Operation {
  override val argument: String = s">$number"
}

case class GreaterThanEqualTo(number: Int) extends Operation {
  override val argument: String = s">=$number"
}

case class LesserThan(number: Int) extends Operation {
  override val argument: String = s"<$number"
}

case class LesserThanEqualTo(number: Int) extends Operation {
  override val argument: String = s"<=$number"
}

case class Between(n1: Int, n2: Int) extends Operation {
  override val argument: String = s"$n1..$n2"
}
