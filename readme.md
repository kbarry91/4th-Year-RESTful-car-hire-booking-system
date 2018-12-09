<p align="center">
  <b>A RESTful Car Hire Booking System using JAX-RS/Jersey, Java RMI and JAXB frameworks.
</b><br>
</p>

# Contents
* [Overview](#overview)
* [How to run](#how-to-run-the-program)
* [Technologies](#technologies)
* [Issues](#issues)

# Overview 
This project use the JAX-RS/Jersey, Java RMI and JAXB frameworks in order to develop a simple Car Hire Booking System. A Web Client page should provide users with the ability to Create/Modify/Update/Delete bookings for a specific vehicle for a given set of dates. The Web Client acts with a RESTful JAX-RS Web Service for bookings which is deployed on Apache Tomcat Server(Version 7). The RESTful Web Service acts as a RMI client to the RMI Database Server which handles persistence.

This project Contains three sub projects.
- RMI-Server : A RMI server to allow remote method inocavtion.
- Web-Service: A RESTfull API that allows CRUD functionality on the RMI database.
- Web-Client : A maven web client that connects to the REST server.

The main goal of this project was to gain hands on experience with modern technologies such as RESTful Web Services, Remote Method Invocation and Data Externalisation.

The project has been developed with 4 main aims

  * Simple Web Client
  * RESTFul Web Service
  * Data Models
  * RMI Database Server


# How to run the program

#### Step 1
Setup the database

#### Step 2
Run the ServiceSetup.java 

#### Step 3
Run WebService on server

#### Step 4
Navigate to Client app
```
http://localhost:8080/Web-Client/
```



# Technologies used
* [JAX-RS](https://en.wikipedia.org/wiki/Java_API_for_RESTful_Web_Services)
* [JAXB](https://www.oracle.com/technetwork/articles/javase/index-140168.html)
* [Jersey](https://jersey.github.io/)
* [Java 1.8](https://www.java.com/en/download/)
* [Tomcat Server](https://tomcat.apache.org/)
* [Eclipse IDE](https://www.eclipse.org/ide/)
* [MySQL Server 5.7](https://dev.mysql.com/downloads/mysql/5.7.html)
* [Maven](https://maven.apache.org/)

# Contributors
* [Kevin Barry](https://github.com/kbarry91)	
