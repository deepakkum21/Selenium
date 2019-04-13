#Introduction to Selenium Part 1

## 1) What is Selenium?
-   • Selenium is a suite of software tools to automate Web Browsers.
-   • It is an Open source suite of tools mainly used for Functional and Regression Test Automation.
-   • Selenium supports various Operating environments.
    -   MS Windows
    -   Linux
    -   Macintosh etc…
-   • Selenium supports various Browsers.
    -   Mozilla Firefox
    -   IE
    -   Google Chrome
    -   Safari
    -   Opera etc…
    -   Note: Selenium IDE supports Mozilla Firefox only.
-   • Selenium supports various programming environments to write programs (Test scripts)
    -   Java
    -   C#
    -   Python
    -   Perl
    -   Ruby
    -   PHP

## 2. History of the Selenium Project
-   • Selenium first came to life in 2004.
-   • In 2006, Selenium WebDriver was launched at Google.
-   • In 2008, the whole Selenium team decided to merge Selenium WebDriver with Selenium RC in order to form more powerful tool called Selenium 2.0

**Selenium 1**
(Selenium IDE + Selenium RC + Selenium Grid)

**Selenium 2**
(Selenium IDE + Selenium RC + Selenium WebDriver + Selenium Grid)

## 3) Selenium’s Tools Suite
### i) Selenium IDE
-   It is a Firefox browser plug in, used to create and execute Test cases.
-   Selenium IDE Features:
    -   • Create Test Cases, Test suites (We can Record test cases or type Test steps using element locators and Selenese commands)
    -   • Edit Test Cases
    -   • Execute Test cases, Test suites
    -   • Debug Test Cases.
    -   • Enhance Test Cases
    -   • Export Test cases to other formats (java, ruby etc…)                          
**Note: selenium IDE Test case default format is .html**

-   **Drawbacks of Selenium IDE**
    -   • It supports Mozilla Firefox browser only.
    -   • It doesn’t support Programming logic/features to enhance Test cases.
    -   • It doesn’t support Data Driven Testing.
    -   • It is not suitable for complex test case design.
    -   • No centralized maintenance of Objects/Elements
### ii) Selenium RC (* Out dated)

### iii) Selenium WebDriver
-   • It is a Programming interface to create and execute Test cases.
    -   Selenium IDE has IDE but doesn’t have Programming interface
    -   Selenium WebDriver has Programming interface but doesn’t have IDE
    -   UFT/QTP has both IDE as well as Programming interface
-   • Selenium WebDriver supports various programming environments to write programs.
    -   Java,
    -   C#
    -   Perl
    -   Python
    -   Ruby
    -   PHP
-   • Using Element/Object locators/properties and Webdriver Methods we can create and execute Test cases.
-   • Selenium Webdriver supports various browsers to create and execute test case/test script/test
Note: Browser driver varies from one browser to another.
-   • Selenium WebDriver supports various operating environments
    -   MS Windows
    -   Linux
    -   Macintosh etc…

**Drawback of Selenium WebDriver**
-   • It doesn’t generate detailed Test Reports.
-   • No centralized maintenance of Object/elements

### iv) Selenium Grid
-   • Selenium Grid is used to execute tests across multiple browsers, operating environments and machines in parallel.
-   • Selenium Grid 2 supports Selenium RC Tests as well as Selenium WebDriver Tests.