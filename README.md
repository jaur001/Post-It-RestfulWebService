# Post-It-Restful Web Service

This project is the first version of Social network that will be developed in the future. The application will allow the users to register or login to the application to use it. The users can post text to share with the followers and the followers can like, dislike or comment the posts.

During the first version, it has been developed the first part of the Backend. There is a CRUD for users and posts from the users using Rest web services. It also allow the users to follow other ones or delete this followers. Finally, you can check all the data about the users created, the posts they have shared and the followers and followings.

The data is saved in a MySQL database and sensitive data like the password is filtered so it will not be showed in the response, showing instead other interesting information to access next using HATEOAS. Besides, the service provides documentation about this web service and all the information about the entire list of resources available and how to interact with them using the different HTTP methods offered in the documentation. The documentation also offers details about the version and description of this Restful Web Service.

This first version is the base of the project that will be developed during the next months. It has all the main resources that will be exposed. Soon, it will be released a Register/Login for the users and security to control to which data they are allowed to access.

## Install/Execute

It is only need to clone and execute the Main Class of the project located in com.urena.postit.postit package. The server (Tomcat) is already embedded in the Spring Boot framework. Futhermore, in the v2/api-docs you have all documentation about the web service and in the /actuator more information as the health or the beans used.

## Built with
