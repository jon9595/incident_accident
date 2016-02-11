Incident Accident Report Server
===============================

This project creates a J2EE web application written in Spring MVC that records and maintains incidents and accidents that occur
in an institution.  This application is specifically designed for MizzouRec.  

The application runs on Apache Tomcat 7 with MySQL as the database.

## Development ##
The framework uses [Gradle](http://www.gradle.org) for it's build platform.  It is a multi-level application.  The incident_accident (root) folder
is one project.  It uses forms-web and mizzrec-api as children.  The forms-web project is the dynamic web project that gets deployed to the server as
a WAR file.  The mizzrec-api project contains the business layer and data layer.  This project is built as a JAR and included in the WAR with all of the
other dependencies.  The deploy folder contains the libraries, artifacts, and scripts necessary to install the application onto a fresh server install.