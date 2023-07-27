import org.testng.Assert;
import org.testng.annotations.*;
public class Main
{
        private Calculator calculator;

        @BeforeClass
        public void setup() {
            calculator = new Calculator();
        }
    @AfterClass
    public void cleanup() {
        // Close the browser and perform cleanup tasks
        System.out.println("All test are excited");
    }

    @BeforeMethod
    public void beforeEachTest() {
        // Login to the website before each test method
        System.out.println("method started");
    }

    @AfterMethod
    public void afterEachTest() {
        // Logout from the website after each test method
        System.out.println("method end");
    }

        @Test(priority = 1)
        public void testAddition() {
            int result = calculator.add(5, 10);
            Assert.assertEquals(result, 15, "Addition failed");
        }

        @Test(priority = 2)
        public void testSubtraction() {
            int result = calculator.subtract(10, 5);
            Assert.assertEquals(result, 5, "Subtraction failed");
        }

        @Test(priority = 3)
        public void testMultiplication() {
            int result = calculator.multiply(5, 10);
            Assert.assertEquals(result, 50, "Multiplication failed");
        }

        @Test(priority = 4)
        public void testDivision() {
            int result = calculator.divide(10, 5);
            Assert.assertEquals(result, 2, "Division failed");
        }

        @Test(expectedExceptions = ArithmeticException.class)
        public void testDivisionByZero() {
            calculator.divide(10, 0);
        }

        @DataProvider(name = "testData")
        public Object[][] testData() {
            return new Object[][] { { 5, 2, 7 }, { 10, 3, 13 }, { 8, 4, 12 } };
        }

        @Test(dataProvider = "testData")
        public void testAdditionWithDataProvider(int num1, int num2, int expected) {
            int result = calculator.add(num1, num2);
            Assert.assertEquals(result, expected, "Addition failed");
        }

        @Test(enabled = false)
        public void testDisabledMethod() {
            // This test method will not be executed
            Assert.fail("This test should not be executed");
        }

        @Test(timeOut = 1000)
        public void testTimeout() throws InterruptedException {
            Thread.sleep(2000);
        }

        @Test(groups = "smoke")
        public void testGroupSmoke() {
            Assert.assertTrue(true);
        }

    @Test(groups = "regression", dependsOnMethods = "testAddition")
    public void testGroupRegression() {
        Assert.assertTrue(true);
    }


}
