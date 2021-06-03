## Bug Bounty
#### Brief Description
Bug Bounty is application like our own Stack Overflow application, where users/admin can submit Bugs. Admins will be approving, rejecting, or resolving bugs. Users and admins can post solutions for bugs reported by other users/admins and get points for the first correct solution. The solution will be accepted by the user/admin who posted the bug, and resolved by a different admin. The admin who posted a bug cannot approve, reject, you or resolve the bug. 

#### Score Rule
All the bugs will be treated equally and users/admins who offer correct solutions will receive 5 points. When there are multiple solutions for a bug, the solution offered first will receive the score.

#### Bug Status
A bug will change from different statuses. When reported by a user/admin, it will be ‘pending’ until an admin ‘accepts’ or ‘rejects’ it. Users can only view accepted bugs, but admins can view all bugs. A bug can be ‘rejected’ by an admin and will be invisible to all users.

#### Solution, and Bug Resolving Standards
The status of a solution to a bug will be ‘false’ or ‘true’. When a solution is offered by a user/admin, it will be false until the relevant user/admin accepts the solution and updates it to be ‘true’. After a solution is updated true, an admin will mark the relevant bug as ‘resolved’ and the relevant user/admin as a resolver. Then the leadership score board will update automatically when the user/admin is marked as a resolver.

#### What is a Bug? 
"A bug is a code snippet that has errors or is not running as intended." 

#### Roles
User & Admin.

#### Features
* As a user or admin, I should be able to submit a new bug report.
* As an admin, I should be able to accept or deny a bug submitted by other admins or users.
* As a user, I should be able to see all bug reports that have been accepted.
* As an admin, I should be able to see all bug reports.
* As a user/admin, I should be able to accept a solution offered for my bug.
* As a user/admin, I should be able to sort and filter bugs and solutions.

#### Getting Started
Execute the following command in git to import the project locally.
-	https://github.com/bug-bounty-iteration-1/bugservice.git

To run backend login microservice, execute the following commands:
-	./consul.exe agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind= (your computer IPv4
-	Then go to the browser and navigate to  http://localhost:8500/ui to check if the consul is up and running

After the consul is up and running, run the following apps in your IDE.
-	Run ‘loginservice’
-	Run ‘bug-gateway’
-	Run ‘bugservice’  

To run frontend, execute the following commands:
-	Open your preferred IDE and navigate to the folder of the frontend app you have already cloned.
-	Run ‘npm -I’ to install required dependencies.
-	Run ‘ng serve’ from a dev server. 
-	Navigate to http://localhost:4200/. The app will automatically reload if you change any of the source files.

#### Environment and Technologies
* Java, JavaScript, TypeScript, Spring, Angular, Protractor, JUnit, TestNG, Jasmine, Jenkins, Spring Boot, Spring Data, Microservices
Architecture
* In the backend, the Bug Bounty application will be a pseudo Microservice Architecture. There will be a ‘loginservice’ Spring Boot Application as a microservice architecture and a ‘bugservice’ Spring Boot Application as a monolithic architecture.
* In the frontend, Angular framework will be used along with Angular Material for a design.

#### Version Control
The GitHub version control will be used to manage source codes. Three repos named ‘frontend’, ‘loginservice’ and ‘bugservice’ will be created.

### Use Cases Combined with Bug Bounty
![image](https://user-images.githubusercontent.com/50306571/120672801-9fb0ca00-c460-11eb-83f0-77fcd54fde17.png)

### Screenshots of Application
#### Signup
![image](https://user-images.githubusercontent.com/50306571/120669506-85c1b800-c45d-11eb-87fb-8d54ff469b03.png)

#### Login
![image](https://user-images.githubusercontent.com/50306571/120669590-95410100-c45d-11eb-8171-1378a65228a6.png)

#### Bug Feed
![image](https://user-images.githubusercontent.com/50306571/120669661-a853d100-c45d-11eb-8b7d-27dea00b2b32.png)

#### Report a  Bug
![image](https://user-images.githubusercontent.com/50306571/120669733-b7d31a00-c45d-11eb-8d0c-a4884749db4e.png)

#### Offer a Bug Solution
![image](https://user-images.githubusercontent.com/50306571/120669804-c8839000-c45d-11eb-803f-d0653c067720.png)

#### Accept or Reject a Bug By Admin
![image](https://user-images.githubusercontent.com/50306571/120672531-637d6980-c460-11eb-8bd2-e004c0fe0a1a.png)

#### User Profile
![image](https://user-images.githubusercontent.com/50306571/120669871-dc2ef680-c45d-11eb-8dc0-36a370d77d40.png)
