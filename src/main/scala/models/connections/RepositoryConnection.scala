package models.connections

import models.objects.Repository

case class RepositoryConnection(val nodes:List[Repository]) extends Connection[Repository]