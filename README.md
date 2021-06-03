# Bug Bounty
### Brief Description
Bug Bounty is application like our own Stack Overflow application, where users/admin can submit Bugs. Admins will be approving, rejecting, or resolving bugs. Users and admins can post solutions for bugs reported by other users/admins and get points for the first correct solution. The solution will be accepted by the user/admin who posted the bug, and resolved by a different admin. The admin who posted a bug cannot approve, reject, you or resolve the bug. 

### Score Rule
All the bugs will be treated equally and users/admins who offer correct solutions will receive 5 points. When there are multiple solutions for a bug, the solution offered first will receive the score.

### Bug Status
A bug will change from different statuses. When reported by a user/admin, it will be ‘pending’ until an admin ‘accepts’ or ‘rejects’ it. Users can only view accepted bugs, but admins can view all bugs. A bug can be ‘rejected’ by an admin and will be invisible to all users.

### Solution, and Bug Resolving Standards
The status of a solution to a bug will be ‘false’ or ‘true’. When a solution is offered by a user/admin, it will be false until the relevant user/admin accepts the solution and updates it to be ‘true’. After a solution is updated true, an admin will mark the relevant bug as ‘resolved’ and the relevant user/admin as a resolver. Then the leadership score board will update automatically when the user/admin is marked as a resolver.

### What is a Bug? 
"A bug is a code snippet that has errors or is not running as intended." 

### Roles
User & Admin.

### Features
	As a user or admin, I should be able to submit a new bug report.
	As an admin, I should be able to accept or deny a bug submitted by other admins or users.
	As a user, I should be able to see all bug reports that have been accepted.
	As an admin, I should be able to see all bug reports.
	As a user/admin, I should be able to accept a solution offered for my bug.
	As a user/admin, I should be able to sort and filter bugs and solutions.

### Getting Started
*	Execute the following commands in git to import the project locally.
-	Bug Service Clone: git clone https://github.com/bug-bounty-iteration-1/bugservice.git
-	Login Service Clone: git clone https://github.com/bug-bounty-iteration-1/loginservice.git
-	Front End Clone: git clone https://github.com/bug-bounty-iteration-1/frontend.git
-	Bug Gateway Clone: ?????????????????

*	To run backend login microservice, execute the following commands:
-	./consul.exe agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind= (your computer IPv4
-	Then go to the browser and navigate to  http://localhost:8500/ui to check if the consul is up and running.

*	After the consul is up and running, run the following apps in your IDE.
-	Run ‘loginservice’
-	Run ‘bug-gateway’
-	Run ‘bugservice’  

*	To run frontend, execute the following commands:
-	Open your preferred IDE and navigate to the folder of the frontend app you have already cloned.
-	Run ‘npm -I’ to install required dependencies.
-	Run ‘ng serve’ from a dev server. 
-	Navigate to http://localhost:4200/. The app will automatically reload if you change any of the source files.

