#Incident Accident Report Server


This project creates a J2EE web application written in Spring MVC that records and maintains incidents and accidents that occur
in an institution.  This application is specifically designed for MizzouRec.  

The application runs on Apache Tomcat 7 with MySQL as the database.

## Development ##
The framework uses [Gradle](http://www.gradle.org) for it's build platform.  It is a multi-level application.  The incident_accident (root) folder
is one project.  It uses forms-web and mizzrec-api as children.  The forms-web project is the dynamic web project that gets deployed to the server as
a WAR file.  The mizzrec-api project contains the business layer and data layer.  This project is built as a JAR and included in the WAR with all of the
other dependencies.  The deploy folder contains the libraries, artifacts, and scripts necessary to install the application onto a fresh server install.

## Developer Tools ##
The Vagrant tool sets up a database server that is accessible from MySQL Workbench or through PhpMyAdmin using the root username and password provided in 
the ```bootstrap.sh``` file. 
Development of the code was performed using the [Spring Tool Suite](https://spring.io/tools) and the Gradle Plugin in STS. To get started simply clone
this project into your workstation, start STS, import the project through Gradle, and start coding.  I installed a local tomcat7 instance on my development
machine and pointed the datasource to the IP Address of the database (which in this case is found in the vagrantfile). 

## Database connection configuration ##
Configuration information for the database and security access is found in the context.xml file in the META-INF folder of the forms-web project. 
It is suggested to change the password prior to deploying to the production environment.

## Vagrant ##
To assist with getting a development environment up quickly, this project uses [Vagrant](https://www.vagrantup.com) to create a virtual machine to house the database server. 

Vagrant provides easy to configure, reproducible, and portable work environments built on top of industry-standard technology and controlled by a 
single consistent workflow to help maximize the productivity and flexibility of you and your team.

## Getting started with Vagrant ##
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

You can also input

```
vagrant ssh
```
to ssh into the virtual machine.

Make sure you already have the ubuntu/trusty32 loaded.  If not do
```
vagrant box add ubuntu/trusty32
```
before starting the virtual machine.

To safely stop the box simply run the command:
```vagrant halt```

To destroy the box run:
```vagrant destroy```

If you modify ```bootstrap.sh``` you can reprovision the box by running:
```vagrant provision```

More information about setting up Vagrant can be found at the Vagrant website: [https://www.vagrantup.com/docs/getting-started/](https://www.vagrantup.com/docs/getting-started/)

##Resources##

* **Apache:** [http://httpd.apache.org](http://httpd.apache.org)

* **Git:** [http://git-scm.com](http://git-scm.com)

* **Gradle** [http://gradle.org/](http://gradle.org/)

* **Maven:** [https://maven.apache.org](https://maven.apache.org)

* **MySQL:** [https://www.mysql.com](https://www.mysql.com)

* **PHP MyAdmin:** [https://www.phpmyadmin.net](https://www.phpmyadmin.net)

* **Spring Tool Suite:** [http://spring.io/tools/sts](http://spring.io/tools/sts)

* **Spring MVC:** [http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html)

* **Tomcat:** [http://tomcat.apache.org](http://tomcat.apache.org)

* **Vagrant:** [https://www.vagrantup.com](https://www.vagrantup.com)