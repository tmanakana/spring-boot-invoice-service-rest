# spring-boot-invoice-service-rest
Small application to demonstrate how to create a RESTful web service using spring boot

How to run
==========
Assumption: The source has already been cloned/downloaded. Computer has access to internet. Maven is installed.
Using command line tool of your choice navigate to the same directory where the pom.xml is located
run command: mvn clean install. If failure is experienced due to TEST failure run command mvn clean install -DskipTests
run command: java -jar target/invoice-service-rest-0.0.1-SNAPSHOT.jar
Congratulations!! Your REST service is up. You can add invoices using postman or any web service client tool of choice(sample_data.txt is provided)

H2 Console details
==================
URL: http://localhost:8080/h2 
USER: platoonian
PASSWORD: [blank. As in should be left empty :-) ]
