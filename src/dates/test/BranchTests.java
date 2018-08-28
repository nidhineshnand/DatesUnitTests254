package dates.test;

import dates.Dates;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;


public class BranchTests {


    //Non leap year test
    @Test
    public void simpleInput(){
        assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(2011, 7, 21));

    }

    //Leap year test that is divisible by 400
    @Test
    public void leapYeardivisible400(){
        assertEquals(Dates.Day.Sunday, Dates.dayOfWeek(2000, 5, 21));

    }

    //Leap year test that is not divisible by 400 and 100 but is divisible by 4
    @Test
    public void leapYeardivisible4(){
        assertEquals(Dates.Day.Friday, Dates.dayOfWeek(2004, 5, 21));

    }

    //Non leap year that is divisible by 100
    @Test
    public void nonLeapYeardivisible100(){
        assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1900, 3, 5));

    }

    //Invalid year that is before 1753
    @Test
    public void yearBefore1753(){
        try {
            assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(1752, 12, 18));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //Invalid month where month is 0
    @Test
    public void invalidMonthLessThan0(){
        try {
            assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1876, 0, 18));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //Invalid month where month value is greater than 12
    @Test
    public void invalidMonthMoreThan12(){
        try {
            assertEquals(Dates.Day.Monday, Dates.dayOfWeek(1876, 13, 18));
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
            assertEquals(Dates.Day.Thursday, Dates.dayOfWeek(2000, 2, 30));
            fail("Exception was not passed");
        }catch(IllegalArgumentException e){}
    }

    //Checking if the program produces handles a valid february input with a leap year
    @Test
    public void checkValidFebruaryWithLeapYear(){
            assertEquals(Dates.Day.Tuesday, Dates.dayOfWeek(2000, 2, 29));
    }

    //Checking if the program produces handles a valid february input with a leap year
    @Test
    public void checkDoomsdayDate(){
        assertEquals(Dates.Day.Wednesday, Dates.dayOfWeek(2001, 1, 10));
    }





}
