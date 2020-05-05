package models.connections

import models.objects.Topic

case class TopicConnection(val nodes:List[Topic]) extends Connection[Topic]