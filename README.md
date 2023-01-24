# API Test Automation

Automation Framework to test hotel booking apis

[API Documentation](https://restful-booker.herokuapp.com/apidoc/index.html#api-Booking-GetBookings)

# Description

Tech Stack used for the framework:
* Programming Language - Java
* Build tool - Maven
* Test framework and assertion - JUnit
* API automation tool - RestAssured
* BDD - Cucumber

# Prerequisite to run
* Java
* Maven

# Usage
* Download the project by cloning from github - git clone https://github.com/sharmamayur89/hotel-api-test.git

# Installation
* Import the maven project in and IDE like IntelliJ
* Build Maven Dependency either from IDE or terminal
    - mvn clean
    - mvn install

# Run
Automation suite can be trigerred in following ways:
* Use IDE integrated maven runner
* Using JUnit runner in IDE
* Using Cucumber runner in IDE - only the selected feature file would run
* Execution from Terminal:
    - Open Terminal/CommandPrompt
    - Use command to trigger test cases -> mvn test


# Configuration:
* Cucumber configuration can be done in file - TestRunner.java -> Tags can be provided to execute specific test cases to the suite;
  Report generation can also be configured here;
* Test Scenarios in BDD format are present under - booking-api-feature and tags can be provided for each feature file
* Endpoints can be configured from config.properties file
* Parallel execution can be configured from pom.xml plugin - maven-surefire-plugin

# Reports:
* Default cucumber reports are generated inside folder TestReports/cucumber-reports/
* Customized Readable html reports are generated inside folder TestReports/cucumber/


# Author: Mayur Sharma