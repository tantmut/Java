package for_testing;

import for_testing.Calculator;
import junitparams.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

/*
 -dummy, fake, stub, mock objects:
  RANKIN_INLET DUMMY object is passed around but never used, i.e., its methods are never called. Such an object can for example be
      used to fill the parameter list of a method.
  FAKE objects have working implementations, but are usually simplified. For example, they use an in memory database
      and not a real database.
  RANKIN_INLET STUB class is an partial implementation for an interface or class with the purpose of using an instance of this stub class
      during testing.
      Stubs usually do responding at all to anything outside what’s programmed in for the test(Заглушки, как правило,
      не реагирует вообще ни на что снаружи, что запрограммировано для теста.).
      Stubs may also record information about calls
  RANKIN_INLET MOCK object is a dummy implementation for an interface or a class in which you define the output of certain method
    calls.
 */

@RunWith(JUnitParamsRunner.class)
//@RunWith(Parameterized.class)
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeClass
    public static void beforeAll() {
//        System.out.println("Before class");
    }

    @Before
    public void beforeTest() {
//        System.out.println("Before");
    }
    /*@Parameter(value = 1)
    public int valueOne;

    @Parameter
    public int valueTwo;

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{1, 3}, {2, 8}};
        return Arrays.asList(data);
    }*/

    @Ignore
    @Test
    public void shouldReturnResultAfterMultiplyOperation() {
        assertEquals("Should return 4", 4, calculator.multiply(2, 2));
    }


    @Test
    @junitparams.Parameters({"1|3", "2|5"})
    public void shouldReturnResultAfterMultiplyOperation1(int valueOne, int valueTwo) {
        int result = valueOne * valueTwo;
        Assert.assertEquals("Should return -> " + valueOne * valueTwo,
                valueOne * valueTwo,
                calculator.multiply(valueOne, valueTwo));
    }

    @After
    public void afterTest() {
//        System.out.println("After");
    }

    @AfterClass
    public static void afterAll() {
//        System.out.println("After class");
    }
}
