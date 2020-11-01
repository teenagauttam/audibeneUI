# audibeneUI Automation

This is the sample test automation task in which below test scenario is included:

Scenario 1 : Login Test<br />
● Go to the login page.<br />
● Verify the login page.<br />
● Enter login credentials for the user.<br />
● Click on login button.<br />
● Verify message on Login page for user.<br />
● Logout after successful login for.<br />

Scenario 2 : Make sure exit intent is shown<br />
● Go to the exit_intent page.<br />
● Move the mouse outside of the viewport.<br />
● Verify and click on close button.<br />
    
Scenario 3 : Verify sorting of table names<br />
● Go to the tables page.<br />
● Check the length of tables.<br />
● Click on last name on table 1.<br />
● Verify the alphabet order of lastName in table 1.<br />
● Click on first name on table 2.<br />
● Verify the alphabet order of firstName in table 2.<br />

Scenario 4 : Verify New Window<br />
● Go to the windows page.<br />
● Click on click here button.<br />
● Verify that user is redirected to new window.<br />

Scenario 5 : Verify Enable/disable input field<br />
● Go to the dynamic_controls page.<br />
● Click on Enable button and Verify the input field.<br />
● Verify success message for Enable.<br />
● Enter value in the input.<br />
● Click on Disable button and Verify the input field.<br />
● Verify success message for Disable.<br />
● Verify that string is available in the input.<br />

# Getting Started

Please follow below instruction to copy the project and running on your local machine for testing purpose

#### Prerequisites

Maven home: apache-maven-3.5.3

Java version: 1.8.0_201, vendor: Oracle Corporation

Chrome version: Version 84.0.4147.125 (Official Build) (64-bit)

Git Bash

This test was done on MAC but if you are running this code in windows then please update OS name in Config.properties like below : <br />
OS=WINDOWS


# Running the tests

Given scenario is automated using selenium cucumber.
Gherkin language is used in cucumber for these scenario.

#### Below is the work flow of calling methods in this framework

Feature File >>>> Step Definition File >>>> Main File

For example: Feature file is created for Automation demo in which scenario is written in gherkin language.
This feature file calls step difinition file through glue code.
Then step definition file calls main page file in which all methods are defined.

# Installation

### Linux Machine

If you’re on Fedora for example (or any closely-related RPM-based distro such as RHEL or CentOS), you can use below command to install Git:
##### $ sudo dnf install git-all

If you’re on a Debian-based distribution like Ubuntu, try apt-get:
##### $ sudo apt-get install git-all

Install Maven
#### $ sudo apt-get install maven

1. Clone the project from below location:

git@github.com:teenagauttam/audibeneUI.git

2. Go to source folder in local machine

audibeneUI

3. Run " mvn test " command in source folder " audibeneUI " from your maven or git bash
mvn test

## Check Report

1. After running the test, Target folder will be generated in root folder and extent.html file will be generated in target folder.

2. Click on extent.html to see the report of the execution.