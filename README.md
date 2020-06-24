# Interactive Pizza Ordering Chat Bot

A Chatbot that can let people order pizza online The bot will display the menu to the customer. 
The user will select a pizza along with quantity and toppings Special Discount will be provided to the customer if the order exceeds above 500. 
The user will be able to place home address for delivery

##Technologies Used

- Spring Boot
- Swagger UI
- H2 Database
- Microsoft Bot Framework
- Facebook Messenger
 
## Prerequisites for Spring Boot to run  
 
Make sure you've installed Java 1.8 and Maven in your system. 

You can verify it by using the following commands

- ``java -version``

- ``mvn -version`` 

Once when you verify the above versions, you are good to go.

## Running Spring Boot Application

If you are running this application for the first time, give the following command

``mvn clean install``

You can observe that target folder has been created in the directory. It creates a JAR file which can be later used for 
deployment of the application

To run the spring boot app, give the following command

``mvn spring-boot:run``

Now your spring boot will be running in the port 8080 in your system. 
In this application, we've integrated swagger documentation ui as well for better testing and viewing of endpoints and apis

Use the url mentioned below to access Swagger UI

``http://localhost:8080/swagger-ui.html``

If you can able to see the Swagger UI, you are good to go

