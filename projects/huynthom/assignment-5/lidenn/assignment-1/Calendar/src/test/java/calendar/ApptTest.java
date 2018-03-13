package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
    @Test
    public void test01() throws Throwable {
        int startHour = 21;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);
        // assertions
        assertTrue(appt.getValid());
        assertEquals(21, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(01, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());
    }

    @Test
    public void test02() throws Throwable {
        int[] recurDays = null;
        int recurBy = 5;
        int recurIncrement = 1;
        int recurNumber = -1;
        int startHour = 23;
        int startMinute = 50;
        int startDay = 10;
        int startMonth = 10;
        int startYear = 2018;
        String title = null;
        String description = null;
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        appt.setStartHour(21);
        appt.setStartMinute(50);
        appt.setStartDay(10);
        appt.setStartMonth(10);
        appt.setStartYear(2018);
        String new_title ="Wedding";
        String new_description="This is my wedding.";
        appt.setTitle(new_title);
        appt.setDescription(new_description);

        assertTrue(appt.getValid());
        assertEquals("Wedding", appt.getTitle());
        assertEquals("This is my wedding.", appt.getDescription());
        assertEquals(0, appt.compareTo(appt));
        assertEquals(0, appt.getRecurNumber());
        assertEquals(2, appt.getRecurBy());
        assertFalse(appt.isRecurring());
        String check = "Check";
        assertNotEquals(check, appt.toString());
        assertEquals(1, appt.RECUR_BY_WEEKLY);


        Appt appt2 = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        assertNotEquals(null, appt.toString());
        appt.setTitle(title);
        appt.setDescription(description);
        assertEquals("", appt.getDescription());
        assertEquals("", appt.getDescription());
    }

//add more unit tests as you needed

    @Test
    public void test03()  throws Throwable  {
        int startHour=21;
        int startMinute=30;
        int startDay=15;
        int startMonth=01;
        int startYear=2018;
        String title="Birthday Party";
        String description="This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description);

        appt.setStartHour(21);
        appt.setStartMinute(50);
        appt.setStartDay(10);
        appt.setStartMonth(10);
        appt.setStartYear(2018);
        String new_title ="Wedding";
        String new_description="This is my wedding.";
        appt.setTitle(new_title);
        appt.setDescription(new_description);


        appt.setStartHour(-80);
        assertFalse(appt.getValid());
        appt.setStartHour(80);
        assertFalse(appt.getValid());
        appt.setStartHour(24);
        assertTrue(appt.getValid());
        appt.setStartHour(23);
        assertTrue(appt.getValid());
        appt.setStartHour(0);
        assertTrue(appt.getValid());
        appt.setStartHour(15);
        assertTrue(appt.getValid());
        appt.setStartHour(21);

        appt.setStartMinute(-80);
        assertFalse(appt.getValid());
        appt.setStartMinute(80);
        assertFalse(appt.getValid());
        appt.setStartMinute(61);
        assertFalse(appt.getValid());
        appt.setStartMinute(0);
        assertTrue(appt.getValid());
        appt.setStartMinute(15);
        assertTrue(appt.getValid());
        appt.setStartMinute(60);
        assertTrue(appt.getValid());
        appt.setStartMinute(50);

        appt.setStartDay(-80);
        assertFalse(appt.getValid());
        appt.setStartDay(80);
        assertFalse(appt.getValid());
        appt.setStartDay(2);
        assertTrue(appt.getValid());
        appt.setStartDay(10);

        /*appt.setStartMonth(-10);
        assertFalse(appt.getValid());
        appt.setStartMonth(15);
        assertFalse(appt.getValid());*/
        appt.setStartMonth(12);
        assertTrue(appt.getValid());

        appt.setStartDay(80);
        appt.setStartYear(-15);
        assertFalse(appt.getValid());
        appt.setStartMonth(11);
        assertFalse(appt.getValid());
        appt.setStartMonth(10);
        assertFalse(appt.getValid());

    }


    @Test
    public void test04()  throws Throwable {
        int startHour = 10;
        int startMinute = 15;
        int startDay = 21;
        int startMonth = 10;
        int startYear = 2018;
        String title = "Trip to Seattle";
        String description = "Going to visit the Seattle Great Wheel!";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        assertTrue(appt.getValid());
        assertEquals(0, appt.compareTo(appt));

        int[] recurDaysArray = null;
        assertEquals(0, appt.getRecurIncrement());
        assertEquals(0, appt.getRecurDays().length);
        appt.setRecurrence( recurDaysArray, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
        assertEquals(2, appt.getRecurIncrement());
        assertEquals(0, appt.getRecurDays().length);
        assertEquals(1, appt.getRecurBy());

        int [] recurDaysArray2 = {1, 2, 3};
        appt.setRecurrence( recurDaysArray2, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
        assertTrue(appt.isRecurring());
        assertEquals(Appt.RECUR_BY_WEEKLY,appt.getRecurBy());
        assertEquals(2,appt.getRecurIncrement());
        assertEquals(Appt.RECUR_NUMBER_FOREVER,appt.getRecurNumber());
        assertEquals(recurDaysArray2,appt.getRecurDays());

        assertEquals("\t10/21/2018 at 10:15am ,Trip to Seattle, Going to visit the Seattle Great Wheel!\n", appt.toString());


    }


}
