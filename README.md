# Test-Automation-Framework

## Instruction
The purpose of this repository is to provide a comprehensive test automation framework that can be used to automate testing processes across various applications and environments. The framework is designed to be flexible, scalable, and easy to use, allowing teams to quickly implement automated tests and improve their testing efficiency for:
- Web applications
- Mobile applications

## Table of Contents
1. [Purpose](#purpose)
2. [Installation](#installation)
3. [Structure](#structure)
4. [Execution](#execution)
5. [CI/CD Integration](#cicd-integration)
6. [Reporting](#reporting)

## Purpose
The purpose of this repository is to provide a comprehensive test automation framework that can be used to automate testing processes across various applications and environments. The framework is designed to be flexible, scalable, and easy to use, allowing teams to quickly implement automated tests and improve their testing efficiency for:
- Web applications
- IOS applications
- Android applications

## Installation

clone the repository:

```bash
git clone https://github.com/phuoctoanit/Test-Automation-Framework.git
cd Test-Automation-Framework
```
Install dependencies using Maven:

```bash
mvn clean install
```

Ensure you have the following prerequisites installed:
- Java Development Kit (JDK) 17 or higher
- Maven 3.6 or higher
- Selenium Server (download the latest version from [Selenium](https://www.selenium.dev/downloads/))
- Allure Commandline (for reporting)
- Appium (for mobile testing)
- Android SDK (for Android testing, optional)
- Xcode (for iOS testing)
- Node.js and npm (for running the web application)


## Structure
The structure of the test automation framework is organized to facilitate easy navigation and management of test cases, configurations, and resources. The main components include:

<pre>
├── README.md
├── drivers
│   └── selenium-server-4.33.0.jar
├── pom.xml
├── setups
│   ├── start-appium-android.sh
│   ├── start-appium-ios.sh
│   └── start-selenium-server.sh
├── src
│   ├── main
│   │   ├── java
│   │   │   └── org
│   │   │       └── demo
│   │   │           ├── base
│   │   │           │   ├── AndroidBasePage.java
│   │   │           │   ├── IOSBasePage.java
│   │   │           │   └── WebBasePage.java
│   │   │           ├── constants
│   │   │           │   └── Constants.java
│   │   │           ├── drivers
│   │   │           │   ├── mobile
│   │   │           │   │   ├── MobileDriverFactory.java
│   │   │           │   │   ├── PlatformType.java
│   │   │           │   │   ├── implement
│   │   │           │   │   │   └── MobileDriverImplement.java
│   │   │           │   │   └── managers
│   │   │           │   │       ├── AndroidDriverManager.java
│   │   │           │   │       └── IOSDriverManager.java
│   │   │           │   └── web
│   │   │           │       ├── BrowserType.java
│   │   │           │       ├── WebDriverFactory.java
│   │   │           │       └── WebDriverSession.java
│   │   │           ├── listeners
│   │   │           │   ├── MobileReportingListener.java
│   │   │           │   └── WebReportingListener.java
│   │   │           ├── managers
│   │   │           │   ├── AndroidPageManager.java
│   │   │           │   ├── IOSPageManager.java
│   │   │           │   └── WebPageManager.java
│   │   │           ├── models
│   │   │           │   └── Challenge.java
│   │   │           ├── pages
│   │   │           │   ├── mobile
│   │   │           │   │   ├── android
│   │   │           │   │   │   └── AndroidHomePage.java
│   │   │           │   │   └── ios
│   │   │           │   │       └── IOSWelcomePage.java
│   │   │           │   └── webapp
│   │   │           │       ├── DashboardPage.java
│   │   │           │       ├── HomePage.java
│   │   │           │       ├── LoginPage.java
│   │   │           │       └── challenge
│   │   │           │           ├── ChallengeCreationPage.java
│   │   │           │           ├── ChallengeDetailPage.java
│   │   │           │           └── MyChallengePage.java
│   │   │           └── utils
│   │   │               ├── CapabilitiesLoader.java
│   │   │               ├── CredentialLoader.java
│   │   │               ├── EnvLoader.java
│   │   │               ├── Logger.java
│   │   │               └── ScreenshotUtil.java
│   │   └── resources
│   │       ├── capabilities
│   │       │   ├── android_capabilities.xml
│   │       │   └── ios_capabilities.xml
│   │       ├── env
│   │       │   ├── credentials.properties
│   │       │   ├── dev.properties
│   │       │   ├── qa.properties
│   │       │   └── staging.properties
│   │       └── log4j2.xml
│   └── test
│       ├── java
│       │   ├── providers
│       │   │   └── ChallengeDataProvider.java
│       │   └── tests
│       │       ├── mobile
│       │       │   ├── android
│       │       │   │   ├── BaseTest.java
│       │       │   │   └── HomePageTest.java
│       │       │   └── ios
│       │       │       ├── BaseTest.java
│       │       │       └── HomePageTest.java
│       │       └── web
│       │           ├── BaseTest.java
│       │           ├── ChallengeTest.java
│       │           ├── DashboardTest.java
│       │           └── LoginTest.java
│       └── resources
│           └── apps
│               └── ApiDemos-debug.apk
├── testng.xml
├── testng_android.xml
├── testng_ios.xml
├── testng_mobile.xml
└── testng_web.xml
</pre>

## Execution
### On local

#### 1. For web testing, ensure you have the Selenium server running. You can start it by running the following command in the terminal:
```bash 
./setups/start-selenium-server.sh
```
Then run the tests using Maven:
```bash
mvn clean test -DsuiteXmlFile=testng_web.xml -Dbrowser=chrome -Denv=staging -Dheadless=true
```
or
```bash
mvn clean test -DsuiteXmlFile=testng_web.xml
```
With the following default parameters:
- `browser`: chrome
- `env`: staging
- `headless`: true
#### 2. For mobile testing, ensure you have Appium server running. You can start it by running the following command in the terminal:
##### a. Android testing
```bash
./setups/start-appium-server-android.sh
```
Then run the tests using Maven:
```bash
mvn clean test -DsuiteXmlFile=testng_android.xml
```
##### b. iOS testing
```bash
./setups/start-appium-server-ios.sh
```
Then run the tests using Maven:
```bash
mvn clean test -DsuiteXmlFile=testng_ios.xml
```

#### c. For mobile testing, you can also run the tests using the following command:
```bash
mvn clean test -DsuiteXmlFile=testng_mobile.xml
```

#### d. To run tests with specific parameters, you can use the following command:
```bash
mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=chrome -Denv=staging -Dheadless=true
```
Where:
- `suiteXmlFile`: the TestNG XML file to run (e.g., `testng_web.xml`, `testng_android.xml`, `testng_ios.xml`, or `testng_mobile.xml`)
- `browser`: the browser to use for web testing (default is `chrome`)
- `env`: the environment to use (default is `staging`)
- `headless`: whether to run the browser in headless mode (default is `true`)


## CI/CD Integration

Refer GitHub actions for CI/CD integration.

`/.github/workflows/test.yml`

## Reporting

Integration with Allure for reporting is included. To generate reports, run the following command after executing tests:

```bash
allure generate allure-results --clean -o allure-report
```
then open the report in a browser:

```bash
allure open allure-report
```
or review the report in the direct once generated by the CI/CD pipeline.

https://phuoctoanit.github.io/Test-Automation-Framework/

**Note**: CI/CD pipelines for mobile testing are not yet implemented. The current focus is on web testing.
