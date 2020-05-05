package models.connections

import models.objects.Language

case class LanguageConnection(val nodes:List[Language]) extends Connection[Language]