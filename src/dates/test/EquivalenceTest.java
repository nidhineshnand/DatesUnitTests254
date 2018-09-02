package dates.test;


/*There are multiple classes of data that go as input in this method. The following classes are the ones that I have
* identified for each input to the dayOfWeek method.
* Year: Invalid year (before 1783), valid year above 1783, leap year (divisible only 4 or 400), non leap year (not
* not divisible by 4 or 400), special non leap year (divisible by 100)
* Month: invalid month (less than 1), valid month (between 1 and 12 inclusive) and invalid month (greater than 13)
* Day: Invalid day (less than 0), valid day (between 0 and highest specified day of the month), invalid day ( day higher
* then specified for that month)
*The non leap year divisible by 100 test was covered in branch coverage but that code exited with a exception. So a
*good equivalence test would be to test if a year divisible by 100 is correctly identified as a non leap year and if the
* the program can give the right day for those years*/

import dates.Dates;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class EquivalenceTest {


    //This test checks if the method can identify that years divisible by 100 and not by 400 are non leap years. This
    //checks if the right day for 28 of February is specified and it also checks if the next day (1st March) is indeed
    //the next day.
    @Test
    public void nonLeapYeardivisible100() {

        assertEquals(Dates.Day.Wednesday, Dates.dayOfWeek(1900, 2, 28));
        assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(1900, 3, 1));
    }

}