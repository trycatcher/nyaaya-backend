name := """nyaaya-backend"""

version := "1.0-SNAPSHOT"

lazy val root = project.in(file(".")).enablePlugins(PlayScala)

mappings in Universal ++=
  (baseDirectory.value / "app/resources" * "*" get) map
    (x => x -> ("app/resources/" + x.getName))
