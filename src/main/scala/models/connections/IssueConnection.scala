package models.connections

import models.objects.Issue

case class IssueConnection(val nodes:List[Issue]) extends Connection[Issue]