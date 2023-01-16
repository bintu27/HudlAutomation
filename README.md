# Hudl Automation

## About Project
Purpose of this project is to automate Hudl Coach login for "https://www.hudl.com" using Selenium with Java as a programming language and BDD Cucumber framework.
It generates an HTML report, using extend spark report.
Screenshots are attached for web application test steps (pass and failed both) in reports after each step

It covers 3 type of testing: 
1. Functional
2. Security
3. Performance.

It is a maven project, meaning all the dependencies are in the pom.xml file, allowing anyone to easily install the dependencies of the project on their local.
It makes use of Page Object model design pattern, using Page Factory to make it simpler and easier to maintain.
(Page factory instantiates an instance of the given class and sets a lazy proxy for each of the WebElement and List<WebElement> fields that have been declared).

*The project is structured in 4 main parts:*
- Page Objects (one java class for each screen of the application containing the declared elements and actions / methods).
- Step Definitions (one java class for each screen of the application containing the Given / When / Then steps).
- Feature files (one feature file for each screen of the application containing the actual gherkin scenarios).
- Resources folder (.properties files contain data variable values)

***This project supports cross-browser functionality and could be run with following browsers:***
1. Chrome
2. Firefox
3. IE EDge
4. Safari

***This project supports multi-device testing and could be run with following device :***
1. Desktop
2. Mobile
3. Tablet

***This project covers following features:***

1) User should be able to log in with valid credentials only via API
   - Valid user login
   - Error message for invalid credentials
2) User should be able to log in with valid credentials only via web application
   - Valid user login
   - Error message for invalid credentials
3) User should be able to reset password with valid credentials web application & API
   - Valid user login
   - Error message for invalid credentials
4) Application security test against XSS & SQL Injection vulnerabilities for client & server side

# How do set up the project? ##

### Summary of set up

Fork / Clone repository from [here](https://github.com/bintu27/HudlAutomation.git)
or download zip and set it up in your local workspace.

### Dependencies

**Pre-requisite**
1. JDK  (make sure Java class path is set)
2. Maven & Maven CLI plugin(make sure .m2 class path is set)
3. Eclipse, Intelli J, VS Code, etc
4. Plugin for Cucumber based on your IDE
   [Eclipse](https://marketplace.eclipse.org/content/cucumber-eclipse-plugin), [Intelli J](https://www.jetbrains.com/help/idea/enabling-cucumber-support-in-project.html), [VS Code](https://marketplace.visualstudio.com/items?itemName=alexkrechik.cucumberautocomplete)

#### With an IDE

1. Clone the repository;
2. Open your IDE (Eclipse, Intelli J, VS Code, etc);
3. Import the project into IDE (for Eclipse: File -> Import -> Maven -> Existing maven projects);
4. Wait until all dependencies are downloaded and installed;
5. Install Cucumber IDE plugin for IDE to view the feature files better and be able to navigate to the step definition from the feature file.

#### Without an IDE

In order to run tests from the Command Line, download Maven and set it up properly.

### Execution

#### With an IDE

1. Open the TestRunner java class in the IDE (located here: src/test/java/Runner/TestRunner.java);
2. Update the 'tags' option with the tag for which tests you want to run (e.g. the tags = `”@Regression or @Smoke”` will run all scenarios
3. Right-click on the root folder and select Run
4. On the right panel of Run, select Run As TestNG

#### Before running tests, Update browser drivers same as browser version in your system with following steps
(Project is already setup for Chrome version 109)
**For e.g. For chrome driver**
 Step 1. Check your Chrome browser version 
 Step 2. Download same version of chrome driver and replace in "./Drivers" folder
   [Chrome Driver can be found here](https://chromedriver.chromium.org/downloads)
   
**Steps to follow to execute the tests:**

#### Without an IDE via command line

The command to run tests from the Command Line (Terminal) is: `mvn clean test`.
You can pass the various arguments

For Eg: `mvn clean test -DbrowserName=Safari -DdeviceType=Mobile`


### Reporting

**View reports**
Generated reports can be viewed from below path:
1) /test-output/SparkReport/Spark.html 
   (recommend to open in browser like chrome or safari)

### Arguments

**For Cross Browser testing**
Default browser is set as Chrome, to update browser type use any one option from below: 
1. Update config.properties
   - Navigate to /src/test/resources/config.properties
2. Update browserName=Chrome to browserName=Edge or browserName=Firefox or browserName=Safari
   (choose the browser you want to run your test suite)

**OR**

   `-DbrowserName=<nameOfBrowser> ` in arguments from command line

**For Cross Device testing**
Default device is set as desktop, to update device type use any one option from below:
1. Update config.properties 
   - Navigate to /src/test/resources/config.properties
2. Update deviceType=Desktop to deviceType=Mobile or deviceType=Tablet
   (choose the device type you want to run your test suite)

   **OR**

   `-DdeviceType=<typeOfDevice>` in arguments from command line

**to Update user data** 

Update login user details in user.properties
   - Navigate to /src/test/resources/user.properties
     (To run same script with any user to just update following details) 
     - validEmail=<> 
     - validPassword=<>
     - userName=<>

**Scope of improvement for this project**
  - Verification of SSO login API
  - Http to Https reroute verifications
  - Verify Data in password field is invisible in form of bullet signs
  - ‘Enter’ key press is working as expected on the login page 
  - Verify Remember Me functionality
  - "Log In with Email and Password" button functionality test on SSO screen
  - Website back button functionality

***Bugs in Login functionality***
1. Once user you logs out, he is navigated back to home page by pressing ‘Back button’ of the browser : **Client side validation missing** 
2. Null is allowed input in reset password email field : **Client side & Server side validation missing** 
3. There is no character limit on login Email and Password : **Client side & Server side validation missing**

Report at Scenario level
![Screenshot](https://github.com/bintu27/HudlAutomation/blob/main/Screenshorts/Scenario.png)

Report at Step level
![Screenshot](https://github.com/bintu27/HudlAutomation/blob/main/Screenshorts/Step.png)
