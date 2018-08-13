# spring-boot-invoice-service-rest
Small application to demonstrate how to create a RESTful web service using spring boot

How to run
==========
Assumption: The source has already been cloned/downloaded. Computer has access to internet. Maven is installed
Using command line tool of your choice navigate to the same directory where the pom.xml is located
mvn clean install

H2 Console details
==================
URL: http://localhost:8080/h2 
USER: platoonian
PASSWORD: [blank. As in should be left empty :-) ]

DISCLAIMER
==========
I assumed the spec requires InvoiceController to addInvoice method to return invoice object in order to get hadle of the generated invoice ID
I did not re-organise the package structure as the spec indicated a package to be used
No handling of exceptions :-(
