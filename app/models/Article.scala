package models

import play.api.libs.json.Json
import play.Play;
import scala.xml.XML

object Article {

  case class Section(article: String, description: String, simplified: String)

  implicit val sectionReads = Json.reads[Section]
  implicit val sectionWrites = Json.writes[Section]

  val TRAI = XML.loadFile(Play.application().getFile("/app/resources/TRAI.xml"))
  val traiSections = TRAI \\ "body" \ "section"
  val sections = traiSections.map(i => Section(((i \ "num").text + " " + (i \ "heading").text), ((i \ "subsection").text).split('\n').map(_.trim.filter(_ >= ' ')).mkString, "For mere mortals!"))
}