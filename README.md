# Josephus Problem Solver (Scala)
This is a sample application solving the Josephus Problem (https://en.wikipedia.org/wiki/Josephus_problem). 
The solution uses circular buffer based on mutable ArrayBuffer and index. I have originally used immutable IndexedSeq, but later switched to ArrayBuffer for performance reasons.
The application uses Scalatest and scala-logging backed with logback.

## Running the Application
The application requires SBT (http://www.scala-sbt.org/) to be installed locally.
Run the application from command line or shell:
```cmd
sbt "run 3 2"
```

## Running the Tests
```cmd
sbt test
```

## Enabling detailed logging
 - Edit _src/main/resources/logback.xml_
 - Change line _\<root level="**info**"\>_ to _\<root level="**debug**"\>_
 - Run the application and observe logs in console and in _josephus-solver.log_

