# Selenium Test Life Cycle

## Selenium Test Life Cycle Phases :
-   i) Test Planning
-   ii) Generating Basic Tests
-   iii) Enhancing Tests
-   iv) Running and Debugging Tests
-   v) Analyzing Test Results and Reporting Defects

## i) Test Planning
-   Get Application Environment (UI Design Technology, Database) Details from development team.
-   Analyze the AUT (Application Under Test) in terms of Object Identification.
    -   Using Recording feature in Selenium IDE
    -   Using Firebug and Firepath plug ins(Mozilla Firefox) we can inspect elements.
-   Select Test Cases for Automation
    -   Tests that we have to execute on every build (Sanity Tests)
    -   Tests that we have to execute on every modified build(Regression Tests)
    -   Tests that we have to execute with multiple sets of Test Data(Data Driven Tests).
-   Select Testing Framework(JUnit/TestNG) and Implement.

## ii) Generating Basic Tests
-   In UFT:
    -   1) Object Repository based Test Design (Recording, Keyword driven methodology)
    -   2) Descriptive Programming/Programmatic Descriptions
-   In Selenium:
    -   1) Selenium IDE
        -   a) Using Recording
        -   b) Type Test steps using Element locators and Selenium IDE/Selenese Commands.
    -   2) Selenium WebDriver
        -   Using Element Locators and WebDriver methods.

## iii) Enhancing Test cases
-   1) Inserting Verification Points
    -   UFT:
        -   Using UFT Checkpoints Or Using VBScript Conditional Statements
    -   Selenium IDE:
        -   Using Assert/Verify Commands
    -   Selenium WebDriver
        -   a) Using Java Conditional Statements
        -   b) Using TestNG Assertion Methods
-   2) Parameterization
    -   Replacing constant (fixed) values using Parameters(Variables/Function Parameter etc…)
    -   We use Parameterization in Data driven Testing.
    -   What is Data Driven Testing?
    -   Testing same Functionalities using multiple sets of Test Data.
    -   Why Data Driven Testing?
    -   For Positive and Negative Testing.
    -   Using Loop Statements and any files.
-   3) Synchronization
    -   What is Synchronization?
    -   How to Synchronize Selenium with AUT?
-   4) Error Handling
    -   Handling expected and unexpected errors.
-   5) Adding Comments (Optional)

## iv) Running and Debugging Tests
-   Running/Executing Tests (Mandatory)
-   Single Test Run
-   Test Batch Run/Batch Testing.
-   Using Testing Framework(JUnit/TestNG) we can conduct batch Testing.
-   Debugging Tests (Optional)
-   What is debugging?
-   Locating and isolating Errors thru Step by Step execution.
-   When Debugging is Required?
    -   Scenario 1: Test case is not showing any errors and providing correct output-Debugging is not required.
    -   Scenario 2: Test case is showing errors-Debugging is Optional.
    -   Scenario 3: Test case is not showing any errors and not providing correct output-Debugging is Required.
        x = a * b    

## v) Analyzing Test Results and Reporting Defects
-   Analyzing Test Results
-   Selenium doesn’t provide detailed Test Reports(Summary only).
-   Using either JUnit or TestNG we can get detailed Test Reports.
-   Status of Test Results in Functional Test Automation
    -   1) Pass (If expected = Actual)
    -   2) Fail (If expected Not equal Actual)
    -   3) Done (If there is no verification in a Test case)
    -   4) Warning (if any interruption during Test execution)
-  **Reporting Defects:**
-   Selenium doesn’t integrate with any tool for Test management /Defect management.
-   Functional Test Automation Vs. Defect management
    -   Selenium Manual
    -   Selenium Bugzilla/Jira etc…
    -   Selenium Tools – Open Source
    -   Eclipse IDE – Open Source
    -   Java – Open Source
    -   JUnit / TestNG Framework -Open Source
    -   Bugzilla for Defect management – Open Source.