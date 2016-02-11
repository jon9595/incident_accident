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

## Vagrant ##
To assist with getting a development environment up quickly, this project uses [Vagrant](https://www.vagrantup.com) to create a virtual machine to house the database server. 

Vagrant provides easy to configure, reproducible, and portable work environments built on top of industry-standard technology and controlled by a 
single consistent workflow to help maximize the productivity and flexibility of you and your team.

### Getting started with Vagrant ###
Download and install the latest version of Vagrant: (apt-get versions can be out of date)

[https://www.vagrantup.com/downloads.html](https://www.vagrantup.com/downloads.html)

Also download and install the latest version of VirtualBox for your OS: (Note: As of this writing, version 5.0 wasn't fully compatible. Use the latest version 4)

[https://www.virtualbox.org/](https://www.virtualbox.org/)

Then you should be able to:

```
cd ~/git/incident_accident
vagrant up
```

This may take awhile, but when the command finishes, you should have a working database server.