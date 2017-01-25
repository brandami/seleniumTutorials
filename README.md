# seleniumTutorials
Git-Repository zur Sammlung verschiedener Selenium-Tutorials.

## Maven - Installieren von Apache Maven (Windows)

Die Installation von Apache Maven ist einfach zu realisieren. Zuerst muss das entsprechende Maven-Archiv heruntergelanden und entpackt werden. Anschließend muss noch der Pfad zum Ordner `bin` zur Systemvariable `PATH` hinzugefügt werden und schon ist Maven installiert.

**Download:**
* [Maven-3.3.9](http://mirrors.ae-online.de/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip)

**Steps:**
* Sicherstellen, dass `JAVA_HOME` Systemvariable gesetzt ist und auf die entsprechende JDK-installation zeigt
  * Starten der Kommandozeile mit Windows + R then type `cmd`
```
echo $JAVA_HOME
```
  * Der Ausgabepfad sollte ähnlich wie `C:\Program Files\Java\jdk1.7.0_79` sein.

*  Das Maven-Archiv in einem beliebigen Ordner extrahieren.
```
unzip apache-maven-3.3.9-bin.zip
```

* Maven-Pfad zur Systemvariable `PATH` hinzufügen
  * Windows System-Einstellungen öffnen (Windows + Pause)
  * `Erweiterte Einstellungen` auswählen
  * `Umgebungsvariablen` öffnen
  * Pfad `...\apache-maven-3.3.9\bin` zu PATH hinzufügen
* Prüfen, ob Installation erfolgreich
  * Öffnen der Kommandozeile (Windows + R)
```
mvn -v
```

  * Die Ausgabe sollte ähnlich wie Folgende aussehen.

```
Apache Maven 3.3.9 (bb52d8502b132ec0a5a3f4c09453c07478323dc5; 2015-11-10T17:41:4
7+01:00)
Maven home: C:\Program Files\apache-maven-3.3.9\bin\..
Java version: 1.8.0_121, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_121\jre
Default locale: de_DE, platform encoding: Cp1252
OS name: "windows 7", version: "6.1", arch: "amd64", family: "dos"
```

Damit ist die Maven-Installation abgeschlossen!
