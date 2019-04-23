# TestNG

## What is TestNG?
-   TestNG is an automation testing framework in which NG stands for "Next Generation". 
-   TestNG is inspired from JUnit which uses the annotations (@).
-   **Advantages**
    -   Using TestNG you can generate a proper report, and you can easily come to know how many test cases are passed, failed and skipped.
    -   You can execute failed test case separately. For example.
        Suppose, you have five test cases, one method is written for each test case (Assume that the program is written using the main method without using testNG). When you run this program first, three methods are executed successfully, and the fourth method is failed. Then correct the errors present in the fourth method, now you want to run only fourth method because first three methods are anyway executed successfully. This is not possible without using TestNG.
    -   The TestNG provides an option, i.e., testng-failed.xml file in test-output folder. If you want to run only failed test cases means you run this XML file. It will execute only failed test cases.

## Why Use TestNG with Selenium?
-   Generate the report in a proper format including a number of test cases runs, the number of test cases passed, the number of test cases failed, and the number of test cases skipped.
-   Multiple test cases can be grouped more easily by converting them into testng.xml file. In which you can make priorities which test case should be executed first.
-   The same test case can be executed multiple times without loops just by using keyword called 'invocation count.'
-   Using testng, you can execute multiple test cases on multiple browsers, i.e., cross browser testing.
-   The testing framework can be easily integrated with tools like Maven, Jenkins, etc.
-   Annotations used in the testing are very easy to understand ex: @BeforeMethod, @AfterMethod, @BeforeTest, @AfterTest
-   WebDriver has no native mechanism for generating reports. TestNG can generate the report in a readable format like the one shown below.
-   TestNG simplifies the way the tests are coded. There is no more need for a static main method in our tests. The sequence of actions is regulated by easy-to-understand annotations that do not require methods to be static.
-   Uncaught exceptions are automatically handled by TestNG without terminating the test prematurely. These exceptions are reported as failed steps in the report.

## TestNG Annotations
-    Annotations hierarchy or Annotations levels in TestNG.

            <suite> --> (@BeforeSuite)
                    <test>  --> (@BeforeTest)
                            <classes> --> (@BeforeClass)
                                    <method> --> (@BeforeMethod)
                                        <test> --> (@Test)
                                    </method> --> (@AfterMethod)
                            </classes> --> (@AfterClass)
                    </test> --> (@AfterTest)
            </suite> --> (@AfterSuite)

- List of annotations

| **Sr.No.**|	**Annotation** | **Description**|
| --------- | ---------------- | -------------- |
| 1	| @BeforeSuite| The annotated method will be run only once before all tests in this suite have run.|
| 2	| @AfterSuite| The annotated method will be run only once after all tests in this suite have run.|
| 3	| @BeforeClass| The annotated method will be run only once before the first test method in the current class is invoked.|
| 4	| @AfterClass| The annotated method will be run only once after all the test methods in the current class have run.|
| 5	| @BeforeTest| The annotated method will be run before any test method belonging to the classes inside the <test> tag is run.|
| 6	| @AfterTest| The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run.|
| 7	| @BeforeGroups| The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked.|
| 8	| @AfterGroups| The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked.|
| 9	| @BeforeMethod| The annotated method will be run before each test method.|
| 10	| @AfterMethod| The annotated method will be run after each test method.|
| 11	| @DataProvider| Marks a method as supplying data for a test method. The annotated method must return an Object[ ][ ], where each Object[ ] can be assigned the parameter list of the test method. The @Test method that wants to receive data from this DataProvider needs to use a dataProvider name equals to the name of this annotation.|
| 12	| @Factory| Marks a method as a factory that returns objects that will be used by TestNG as Test classes. The method must return Object[ ].|
| 13	| @Listeners| Defines listeners on a test class.|
| 14	| @Parameters| Describes how to pass parameters to a @Test method.|
| 15	| @Test| Marks a class or a method as a part of the test. has (priority=value[0...] as parameters) to specify which @test to run first|      

## Multiple Test Cases
-   We can use multiple @Test annotations in a single TestNG file. By default, methods annotated by @Test are executed alphabetically. See the code below. 
-   Though the methods c_test, a_test, and b_test are not arranged alphabetically in the code, they will be executed as such.

            import org.testng.Assert;
            import org.testng.SkipException;
            import org.testng.annotations.Test;

            public class ChronologicalTest {
                @Test
                public void c_test() {
                    Assert.fail();
                }
                
                @Test
                public void a_test() {
                    Assert.assertTrue(true);
                }
                
                @Test
                public void b_test() {
                    throw new SkipException("Test case skipped");
                }
            }

## Parameters
-   If you want the methods to be **executed in a different order, use the parameter "priority"**. 
-   Parameters are keywords that modify the annotation's function.
-   Parameters require you to assign a value to them. You do.this by placing a "=" next to them, and then followed by the value.
-   Parameters are enclosed in a pair of parentheses which are placed right after the annotation like the code snippet shown below.
-   **syntax**
    `@test(priority = 1)`
-   TestNG will execute the @Test annotation with the lowest priority value up to the largest. There is no need for your priority values to be consecutive.

## Multiple Parameters:-
-   A side from "priority," @Test has another parameter called "alwaysRun" which can only be set to either "true" or "false." 
-   To use two or more parameters in a single annotation, separate them with a comma such as the one shown below.
    `@Test(priority = 0, alwaysRun = true)`

## The flow of our test would be:
-   Go to the homepage and verify its title.
-   Click REGISTER and verify the title of its target page.
-   Go back to the homepage and verify if it still has the correct title.
-   Click SUPPORT and verify the title of its target page.
-   Go back to the homepage and verify if it still has the correct title

            import org.openqa.selenium.By;
            import org.openqa.selenium.WebDriver;
            import org.openqa.selenium.firefox.FirefoxDriver;
            import org.testng.Assert;
            import org.testng.annotations.AfterMethod;
            import org.testng.annotations.AfterTest;
            import org.testng.annotations.BeforeMethod;
            import org.testng.annotations.BeforeTest;
            import org.testng.annotations.Test;

            public class TestNgDemo {
                public String baseUrl = "http://demo.guru99.com/test/newtours/";
                String driverPath = "src\\test\\resources\\geckodriver.exe";
                public WebDriver driver; 
                public String expected = null;
                public String actual = null;
                    @BeforeTest
                public void launchBrowser() {
                    System.out.println("launching firefox browser"); 
                    System.setProperty("webdriver.gecko.driver", driverPath);
                    driver= new FirefoxDriver();
                    driver.get(baseUrl);
                }
                
                @BeforeMethod
                public void verifyHomepageTitle() {
                    String expectedTitle = "Welcome: Mercury Tours";
                    String actualTitle = driver.getTitle();
                    Assert.assertEquals(actualTitle, expectedTitle);
                }
                    @Test(priority = 0)
                public void register(){
                    driver.findElement(By.linkText("REGISTER")).click() ;
                    expected = "Register: Mercury Tours";
                    actual = driver.getTitle();
                    Assert.assertEquals(actual, expected);
                }
                    @Test(priority = 1)
                public void support() {
                        driver.findElement(By.linkText("SUPPORT")).click() ;
                        expected = "Under Construction: Mercury Tours";
                        actual = driver.getTitle();
                        Assert.assertEquals(actual, expected);
                }
                @AfterMethod
                public void goBackToHomepage ( ) {
                        driver.findElement(By.linkText("Home")).click() ;
                }
                
                @AfterTest
                public void terminateBrowser(){
                    driver.close();
                }
            }

## IGNORING A TEST
-   `@Test(enabled = false)`

## Grouping A Test

            public class MessageUtil {
                private String message;

                // Constructor
                // @param message to be printed
                public MessageUtil(String message) {
                    this.message = message;
                }

                // prints the message
                public String printMessage() {
                    System.out.println(message);
                    return message;
                }

                // add "tutorialspoint" to the message
                public String salutationMessage() {
                    message = "tutorialspoint" + message;
                    System.out.println(message);
                    return message;
                }

                // add "www." to the message
                public String exitMessage() {
                    message = "www." + message;
                    System.out.println(message);
                    return message;
                }
            }

            import org.testng.Assert;
            import org.testng.annotations.Test;

            public class GroupTestExample {
                String message = ".com";
                MessageUtil messageUtil = new MessageUtil(message);

                @Test(groups = { "functest", "checkintest" })
                
                public void testPrintMessage() {
                    System.out.println("Inside testPrintMessage()");
                    message = ".com";
                    Assert.assertEquals(message, messageUtil.printMessage());
                }

                @Test(groups = { "checkintest" })
                
                public void testSalutationMessage() {
                    System.out.println("Inside testSalutationMessage()");
                    message = "tutorialspoint" + ".com";
                    Assert.assertEquals(message, messageUtil.salutationMessage());
                }

                @Test(groups = { "functest" })
                
                public void testingExitMessage() {
                    System.out.println("Inside testExitMessage()");
                    message = "www." + "tutorialspoint"+".com";
                    Assert.assertEquals(message, messageUtil.exitMessage());
                }  
            }

            <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
            <suite name = "Suite1">
                <test name = "test1">

                    <groups>
                        <run>
                            <include name = "functest" />
                        </run>
                    </groups>

                    <classes>
                        <class name = "GroupTestExample" />
                    </classes>
                
                </test>
            </suite>


## Group of Groups

            <?xml version = "1.0" encoding = "UTF-8"?>
            <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
            <suite name = "Suite1">
                <test name = "test1">
                
                    <groups>
                    
                        <define name = "all">
                            <include name = "functest"/>
                            <include name = "checkintest"/>
                        </define>
                        
                        <run>
                            <include name = "all"/>
                        </run>
                        
                    </groups>
                    
                    <classes>
                        <class name = "GroupTestExample" />
                    </classes>
                    
                </test>
            </suite>

## Exclusion Groups
-   can ignore a group by using the <exclude> tag

            <?xml version = "1.0" encoding = "UTF-8"?>
            <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
            <suite name = "Suite1">
                <test name = "test1">

                    <groups>
                        <define name = "all">
                            <exclude name = "functest"/>
                            <include name = "checkintest"/>
                        </define>

                        <run>
                            <include name = "all"/>
                        </run>
                    </groups>

                    <classes>
                        <class name = "GroupTestExample" />
                    </classes>

                </test>
            </suite>    

## Exception Test
-   TestNG provides an option of tracing the exception handling of code. 
-   You can test whether a code throws a desired exception or not. 
-   Here the **expectedExceptions parameter is used** along with the @Test annotation. Now, let's see @Test(expectedExceptions) in action.           

## Dependency Test
- Sometimes, you may need to invoke methods in a test case in a particular order, or you may want to share some data and state between methods. 
-   This kind of dependency is supported by TestNG, as it supports the declaration of explicit dependencies between test methods.
-   TestNG allows you to specify dependencies either with −
    -   Using attribute **dependsOnMethods** in @Test annotations, OR.
    -   Using attribute **dependsOnGroups** in @Test annotations.


## Parameterized Test
-   Parameterized tests allow developers to run the same test over and over again using different values.
-   TestNG lets you pass parameters directly to your test methods in two different ways −
    -   With testng.xml
    -   With Data Providers

### Passing Parameters with testng.xml
-   With this technique, you define the simple parameters in the testng.xml file and then reference those parameters in the source files.
-   e.g.

        import org.testng.annotations.Parameters;
        import org.testng.annotations.Test;

        public class ParameterizedTest1 {
            @Test
            @Parameters("myName")
            public void parameterTest(String myName) {
                System.out.println("Parameterized value is : " + myName);
            }
        }


        <?xml version = "1.0" encoding = "UTF-8"?>
        <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
        <suite name = "Suite1">
            <test name = "test1">
            
                <parameter name = "myName" value="manisha"/> 
                
                <classes>
                    <class name = "ParameterizedTest1" />
                </classes>
                
            </test>
        </suite>

-   We can also define the parameters at the <suite> level. 
-   Suppose we have defined myName at both <suite> and <test> levels. 
-   In such cases, regular scoping rules apply. It means that any class inside <test> tag will see the value of parameter defined in <test>, while the classes in the rest of the testng.xml file will see the value defined in <suite>.

### Passing Parameters with Dataproviders
- When you *need to pass complex parameters* or **parameters that need to be created from Java (complex objects, objects read from a property file or a database, etc.)**, parameters can be passed using Dataproviders.
-   A Data Provider is a method annotated with **@DataProvider**.
-   This annotation **has only one string attribute: its name**. 
-   If the name is **not supplied, the data provider’s name automatically defaults to the method’s name**. 
-   A data provider **returns an array of objects**.

**Example 1**
-   Here, the @DataProvider passes Integer and Boolean as parameter.

            public class PrimeNumberChecker {
                public Boolean validate(final Integer primeNumber) {
                
                    for (int i = 2; i < (primeNumber / 2); i++) {
                        if (primeNumber % i == 0) {
                            return false;
                        }
                    }
                    return true;
                }
            }

            import org.testng.Assert;
            import org.testng.annotations.BeforeMethod;
            import org.testng.annotations.DataProvider;
            import org.testng.annotations.Test;

            public class ParamTestWithDataProvider1 {
                private PrimeNumberChecker primeNumberChecker;

                @BeforeMethod
                public void initialize() {
                    primeNumberChecker = new PrimeNumberChecker();
                }

                @DataProvider(name = "test1")
                public static Object[][] primeNumbers() {
                    return new Object[][] {{2, true}, {6, false}, {19, true}, {22, false}, {23, true}};
                }

                // This test will run 4 times since we have 5 parameters defined
                @Test(dataProvider = "test1")
                public void testPrimeNumberChecker(Integer inputNumber, Boolean expectedResult) {
                    System.out.println(inputNumber + " " + expectedResult);
                    Assert.assertEquals(expectedResult, primeNumberChecker.validate(inputNumber));
                }
            }

            <?xml version = "1.0" encoding = "UTF-8"?>
            <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
            <suite name = "Suite1">
                <test name = "test1">
                    <classes>
                        <class name = "ParamTestWithDataProvider1" />
                    </classes>
                </test>
            </suite>

**Example 2**
-   Here, the @DataProvider passes Object as parameter.

            public class Bean {
                private String val;
                private int i;

                public Bean(String val, int i) {
                    this.val = val;
                    this.i = i;
                }

                public String getVal() {
                    return val;
                }

                public void setVal(String val) {
                    this.val = val;
                }

                public int getI() {
                    return i;
                }

                public void setI(int i) {
                    this.i = i;
                }
            }


            import org.testng.annotations.DataProvider;
            import org.testng.annotations.Test;

            public class ParamTestWithDataProvider2 {
                @DataProvider(name = "test1")
                public static Object[][] primeNumbers() {
                    return new Object[][] { { new Bean("hi I am the bean", 111) } };
                }

                @Test(dataProvider = "test1")
                public void testMethod(Bean myBean) {
                    System.out.println(myBean.getVal() + " " + myBean.getI());
                }
            }

            <?xml version="1.0" encoding="UTF-8"?>
            <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
            <suite name = "Suite1">
                <test name = "test1">
                    <classes>
                        <class name = "com.stpl.deepak.testng.parameter.ParamTestWithDataProvider2" />
                    </classes>
                </test>
            </suite>