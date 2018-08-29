package dates.test;

import dates.Dates;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/*It is not possible to get 100% branch coverage because there is a statement on line 92 that will be true reguardless of
* input. This is because the boolean that defines that the statement is in the form of a enhanced for loop that will be true
* as long as there are elements in the doomsdaysByMonth arraylist. Since the doomsdaysByMonth arraylist is set in the Dates
* class as static private and final with 12 elements, no external tests can change the number of elemets to 0 in order to
* make the statement false. Hence it cannot be covered by a branch test.*/

public class BranchTests {

    //Leap year test that is divisible by 400 and an invalid month. This covers the branch that tests for leap year that
    //is divisible by 400 and also goes in the branch of a invalid month (0).
    @Test
    public void leapYeardivisible400InvalidMonth0(){
        try {
        assertEquals(Dates.Day.Sunday, Dates.dayOfWeek(2000, 0, 21));
        fail("Exception was not passed");
        }catch(IllegalArgumentException e){}

    }

    //Leap year test that is not divisible by 400 and 100 but is divisible by 4
    @Test
    public void leapYeardivisible4(){
        assertEquals(Dates.Day.Friday, Dates.dayOfWeek(2004, 5, 21));

    }

    //Non leap year that is divisible by 100 and invalid month
    @Test
    public void nonLeapYeardivisible100InvalidMonth(){
        try {
        assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1900, 13, 5));
            fail("Exception was not thrown");
        }catch(IllegalArgumentException e){}
    }

    //Invalid year that is before 1753
    @Test
    public void yearBefore1753(){
        try {
            assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(1752, 12, 18));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //Invalid day that is 0
    @Test
    public void invalidDay(){
        try {
            assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1876, 12, 0));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }


    //Checking if the program produces an exception if a invalid february is given
    @Test
    public void checkInvalidFebruary(){
        try {
            assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(2003, 2, 30));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //Checking if the program produces an exception if a invalid february is given with a leap year
    @Test
    public void checkInvalidFebruaryWithLeapYear(){
        try {
            assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(1996, 2, 30));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //Checking if the program produces handles a valid february input with a leap year
    @Test
    public void checkValidFebruaryWithLeapYear(){
            assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(1996, 2, 29));
    }

    //Checking if the program can handle a date falling on the doomsday date.
    @Test
    public void checkDoomsdayDate(){
        assertEquals(Dates.Day.Friday, Dates.dayOfWeek(1999, 1, 8));
    }





}
