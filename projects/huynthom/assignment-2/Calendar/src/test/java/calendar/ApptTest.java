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

        appt.setStartHour(23);
        appt.setStartMinute(50);
        appt.setStartDay(10);
        appt.setStartMonth(10);
        appt.setStartYear(2018);

        assertEquals(0, appt.compareTo(appt));
        assertEquals(-1, appt.getRecurNumber());
        assertEquals(5, appt.getRecurBy());
        assertTrue(appt.isRecurring());
        String check = "Check";
        assertNotEquals(check, appt.toString());
        assertEquals(1, appt.RECUR_BY_WEEKLY);
        assertEquals(15, appt.compareTo(appt));
    }

//add more unit tests as you needed

}
