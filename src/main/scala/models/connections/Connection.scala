package models.connections

trait Connection[N] {
  def nodes = List[N]
}
