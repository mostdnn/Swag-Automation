# Selenium Test Automation Framework

## Overview
This is a **Selenium Test Automation Framework** designed to automate web application testing using the **Page Object Model (POM)** design pattern, **TestNG** for test management, **Allure Report** for test reporting, and **Data-Driven Testing** for parameterized test cases. The framework is compatible with **IntelliJ IDEA** as the primary IDE.

## Key Features:
- **TestNG** for test execution and reporting
- **Page Object Model (POM)** for better maintainability
- **Data-Driven Testing** using **Excel** or **CSV**
- **Allure Reports** for detailed visual reports
- **Selenium WebDriver** for cross-browser testing
- **JUnit** for assertions and running tests (optional)
- Configuration files for different environments (optional)

![Test Framework Architecture](assets/framework-architecture.png)

## Prerequisites
Before you begin, ensure that you have the following installed:
- **Java JDK 8+**
- **Maven** (dependency management)
- **IntelliJ IDEA** (IDE)
- **Allure Commandline** (for generating reports)

## Project Structure
```bash
├── pom.xml               # Maven project file
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── yourcompany
│   │               └── testautomation
│   │                   ├── pages       # Page Object classes
│   │                   ├── tests       # TestNG classes
│   │                   └── utils       # Utility classes
│   └── resources
│       └── config.properties  # Configuration file
├── target                # Allure and test output
└── README.md             # Project documentation



How to Run Tests
Run from IntelliJ:
Right-click on the Test class or TestNG.xml file and select Run.
Run from Command Line:
bash

mvn test
Allure Reports
After running the tests, generate the Allure report by using the following command:

bash

allure serve target/allure-results


"Conclusion"

This framework provides a reliable and maintainable approach to web automation testing using Selenium, TestNG, and Allure Reporting. It follows the Page Object Model (POM) design pattern for better separation of concerns.
