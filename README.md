# Post-It-Restful Web Service

Post-It is an __Social Network__ that allow the users to post text to share with the followers that can like, dislike or comment the posts. The users to register or login to the application to share their life with the followers.

This is the first version where it was developed the first part of the Backend. There is a __CRUD for users and posts__ from the users using Rest web services. It also allow the users to __follow__ other ones or delete this followers. Finally, you can check all the data about the users created, the posts they have shared and the followers and followings.

The data is saved in a MySQL database and sensitive data like the password is filtered so it will not be showed in the response, showing instead other interesting information to access next using __HATEOAS__. Besides, the service provides documentation about this web service and all the information about the entire list of resources available and how to interact with them using the different __HTTP methods__ offered in the documentation. The documentation also offers details about the version and description of this Restful Web Service.

This first version is the base of the project that will be developed during the next months. It has all the main resources that will be exposed. Soon, it will be released a Register/Login for the users and security to control to which data they are allowed to access.

## Install/Execute

It is needed to clone, create your own database and update it in the application.properties and execute the Main Class of the project located in com.urena.postit.postit package. The server (Tomcat) is already embedded in the Spring Boot framework. Futhermore, in the v2/api-docs you have all documentation about the web service and in the /actuator more information as the health or the beans used. To create the database, there is already a SQL Script file that allows you to create it automatically.

## Built with

* Java - Programming language
* Spring boot - Framework for Java
* Swagger2 - Rest Service Documentation
* MySQL - SQL Database Management
* Hibernate - JPA implementation to access to the data in the database.
* HATEOAS - library to expose more resources that can be useful for the user.
* HAL browser - library to obtain information about the different URLs provided by the Rest Service.
