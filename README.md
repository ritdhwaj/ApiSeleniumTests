# ApiSeleniumTests
# Single Test Suite to execute APi and Selenium Test Cases Using Seleium testng and restassured
Project created to run some sample test cases

Dependency
Java
Maven

###libraries used
Selenium
TestNG
log4j
Extent Reports
Rest Assured

### Some information Regarding Tests:
* Created two pages for elements in com.crm.qa.pages package using page factory , common methods related to page are present their with method usage javadoc as comment
* config contains properties file to read selenium test url, browser name and api en point details
* Base contains base class that is extened with all test cases.
* test data is sample folder in case of data needs
* util contains classes related to login
* inside testfolder added couple of test classes for UI and services testing
* For more information related to test cases you can refer java oc comments

### Steps to clone execute the tests
```
git clone {repo_url}}
move to folder
run testng.xml pr run mvn command 
```
