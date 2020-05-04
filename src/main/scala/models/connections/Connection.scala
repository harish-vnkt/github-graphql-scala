package models.connections

trait Connection[N] {
  val nodes = List[N]
}
