package dates.test;

import dates.Dates;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

/*It is not possible to get 100% branch coverage because there is a statement on line 92 that will be true reguardless of
* input. This is because the boolean that defines that the statement is in the form of a enhanced for loop that will be true
* as long as there are elements in the doomsdaysByMonth arraylist. Since the doomsdaysByMonth arraylist is set in the Dates
* class as private and final with 12 elements, no external tests can change the number of elements to 0 in order to
* make the statement false. Hence it cannot be covered by a branch test.*/

public class BranchTests {

    //Leap year test check if the program can handle leap years that is divisible by 400 and has a invalid month. This
    // covers the branch that tests for leap year that is divisible by 400 and also goes in the branch of a invalid month (0).
    @Test
    public void leapYeardivisible400InvalidMonth0(){
        try {
        assertEquals(Dates.Day.Sunday, Dates.dayOfWeek(2000, 0, 21));
        fail("Exception was not passed");
        }catch(IllegalArgumentException e){}

    }

    //This test checks if dayOfWeek can handle leap years divisible by 4. This results in the program going into the
    // edge that checks if a leap year is only divisible by 4. No other tests this prior to this explore this path.
    @Test
    public void leapYeardivisible4(){
        assertEquals(Dates.Day.Friday, Dates.dayOfWeek(2004, 5, 21));

    }

    //This tests checks if the method is able to handle non leap years that are divisible by 100 and contain an invalid month (13).
    //This test takes the path that covers the edge responsible for checking a non leap year and also responsible for checking
    //if the given month is above 12 (invalid).
    @Test
    public void nonLeapYeardivisible100InvalidMonth(){
        try {
        assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1900, 13, 5));
            fail("Exception was not thrown");
        }catch(IllegalArgumentException e){}
    }

    //This test checks if the method is able to handle invalid year that is before 1753. This increases the branch
    //coverage of the whole test suite because this test makes the program take the branch that carries out functions if
    // the year specified is before 1753 (throws exception).
    @Test
    public void yearBefore1753(){
        try {
            assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(1752, 12, 18));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //This test checks if the method is able to handle invalid day that is 0. This increases the branch
    //coverage of the whole test suite because this test makes the program take the branch that carries out functions if
    // the day specified is below 1 (throws exception).
    @Test
    public void invalidDay(){
        try {
            assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1876, 12, 0));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }


    //This test checks if the method is able to handle invalid day for the feburary (30th Feb). This increases the branch
    //coverage of the whole test suite because this test makes the program take the branch that carries out functions if
    //the day for February is invalid. It throws an exception
    @Test
    public void checkInvalidFebruary(){
        try {
            assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(2003, 2, 30));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //This test checks if the method is able to handle invalid day for the leap year February (30th Feb). This increases the branch
    //coverage of the whole test suite because this test makes the program take the branch that carries out functions if
    //the day for February is invalid and it is a leap year.
    @Test
    public void checkInvalidFebruaryWithLeapYear(){
        try {
            assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(1996, 2, 30));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }


    //This test checks if the method is able to handle valid day for the leap year February. This increases the branch
    //coverage of the whole test suite because this test makes the program take the branch that carries out functions if
    //the day for February is valid and it is a leap year.
    @Test
    public void checkValidFebruaryWithLeapYear(){
            assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(1996, 2, 29));
    }

    //This test checks if the method is able to handle valid day tha falls on Doomsday. This increases the branch
    //coverage of the whole test suite because this test makes the program take the branch that carries out functions if
    //the day specified falls on or before Doomsday
    @Test
    public void checkDoomsdayDate(){
        assertEquals(Dates.Day.Friday, Dates.dayOfWeek(1999, 1, 8));
    }





}
