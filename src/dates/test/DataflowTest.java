package dates.test;

import dates.Dates;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*This test tests the leap year that is divisible by 400 but does not result in an invalid input.
Variable - year
Definition - line 1 method parameter
Use - Line 84 (used to get the doomsday fro the year)
Path - 46-47-48-49-58-59-61-63-65-69-70-74-79-80-81-84
This test increases the probability of failure because it goes through a path that was not covered by the branch tests.
It it true in the condition if a year divisible by 400 is a leap year and then later it does not exit with an exception
(Unlike the only test in the branch coverage that checks a 400 divisible leap year then exists with an exception).
It then goes on to be used on line 84 where the year is used to determine determine doomsday for that year. If there was
an error in determining the doomsday year with leap years divisible by 400 then this test would have been able to find that
but the branch tests would not have.
 */
public class DataflowTest {
    //Checking if the program produces handles a valid february input with a leap year
    @Test
    public void checkYearDataFlow(){
        assertEquals(Dates.Day.Wednesday, Dates.dayOfWeek(2000, 6, 7));
    }
}
