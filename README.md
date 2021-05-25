# Bug Bounty
### Project Introduction
Bug Bounty is application similar to our own Stack Overflow application. It is, where users/admin can submit Bugs. Admins will be approving bugs. Users and admins can post solutions for bugs reported by other users/admins and get points for a correct solution if accepted by the user/admin who posted the bug and if marked by an admin (not a admin who posted the relevant bug or solution).

The application will follow pseudo Microservice Architechture, in which there will be a 'loginservice' as a microservice and a 'bugservice' as a monolithic application. Both applications will share the same database.

All the bugs will be treated equally and users/admins who offer correct solutions will receive 5 points. When there are more than one correct solution for a bug, the solution offered first will receive the score.

A bug will change from different statuses. When reported by a user/admin, it will be ‘pending’ until an admin ‘accepts’ or ‘rejects’ it. Users/Admins can only view accepted bugs. A solution to the bug will ‘false’ or ‘true’ status. When a solution offered by a user/ an admin, it will be false until the relevant user/admin accepts the solution and updated it to ‘true’. Then when a user/an admin, accepts a solution to the bug by updating the status of the bug to ‘true’, an admin will mark the relevant bug ‘resolved’ and the relevant user/admin a resolver. The leadership score board will update automatically when the user/admin is marked a resolver.

A bug can be ‘rejected’ by an admin and will be invisible to all users.

### Environment / Technologies
Java, JavaScript, TypeScript, Spring, Angular, Protractor, Selenium / Webdriver, JUnit, TestNG, Jasmine, Jenkins, Spring Boot, Spring Data, Microservices

### ERD Diagram

![image](https://user-images.githubusercontent.com/50306571/119524721-e3fae680-bd4b-11eb-93b2-e71bbad25b74.png)

### Requirement Daigram
![image](https://user-images.githubusercontent.com/50306571/119524939-14db1b80-bd4c-11eb-81c4-021ea2623002.png)
