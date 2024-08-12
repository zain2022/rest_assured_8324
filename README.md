Resy Assured Session Sub Topics:

Rest Assured instalation, setup, add required dependencies in pon.xml.
Defining Routes and its usage for the testing feature.
Creating Getter and Setter for the testing feature.
Sequential and Parallel test execution.
Reporting and CI/CD pipelines for jenkins.

Framework Development

Pre-Requisites:
--------------
Step 1: Create Maven Project
Step 2: Update pom.xml with required dependencies
Step 3: Create Folder Structure
-------------------------------

Step 4: Create Routes.java -> contains URL's
Step 5: Create UserEndPoints.java -> CRUD method implementation
Step 6: Create Test Cases

Step 7: Create Data Driven Test
	Excel Sheet Data
	Add Excel Utility in pom.xml
	Dataprovider -> annotation methods that provide the data from the excell sheet to another test method/case by storing the data in the form of 2D array.

Step 8: Generate Extent Report
	Extent report Utility
	testng.xml file

Srep 9: Add logs
	log4j2 dependency
	log4j2.xml file -> src/test/resources

Step 10: Creating properties file -> just like a noramal text file -> we do not need to follow any syntax for the creation of this file
	 Added plugins in pom.xml for running the project from pom.xml
	 Executing tests using pom.xml within intellij
	 Executing tests using pom.xml in cmd by hitting mcn clean test / mvn test
	 Commit code in local repository (git)
	 Push code to remote repository (github)
	 Run project in jenkins (from git github)

********************************************************** Github FLow and Commands **********************************************************

CI Process:
Pre-Requisites:

1. Install git software
2. Create an github account and create empty reporitory.
   Repo URL: https://github.com/zain2022/rest_assured_8324.git


Working repo (Add command) -> Staging area -> Git repo (Commit command) -> Remote repo (Push command)

1. git init -> create local repo
2. git config --global user.name "Zain Ul Abideen"
   git config --global user.email "zainulabideenkhan094@gmail.com"
3. git status
4. git add . or git add -A or git add file.txt or git add *.java or git add foldername -> will add untracked files in staging area to files to be tracked
5. (use "git rm --cached <file>..." to unstage)
6. git commit -m "This is my first commit" -> will add in the local repo to be pushed on Remote repo
7. git remote add origin "https://github.com/zain2022/rest_assured_8324.git" -> will connect locat repo to the remote repo and this is one time command
8. git push -u origin main -> push the code to the remote repo from local repo

