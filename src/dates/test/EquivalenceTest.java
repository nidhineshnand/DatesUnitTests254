package dates.test;

/*The non leap year divisible by 100 test was covered in branch coverage but that code exited with a exception. So a
*good equivalence test would be to test if a year divisible by 100 is correctly identified as leap year and if the
* the program can give the right day for those years*/

import dates.Dates;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class EquivalenceTest {


    //Non leap year that is divisible by 100
    @Test
    public void nonLeapYeardivisible100() {
        assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1900, 11, 5));
    }

}