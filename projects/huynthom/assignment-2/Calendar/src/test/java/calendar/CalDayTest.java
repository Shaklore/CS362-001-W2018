package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;


import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	 @Test
	  public void test01()  throws Throwable  {
	 	int year = 2018;
	 	int month = 7;
	 	int day = 21;
	 	GregorianCalendar cal = new GregorianCalendar(year, month, day);
		CalDay calday = new CalDay(cal);

		 int startHour = 21;
		 int startMinute = 30;
		 int startDay = 15;
		 int startMonth = 01;
		 int startYear = 2018;
		 String title = "Christmas";
		 String description = "Merry Christmas";

		 Appt appt = new Appt(startHour,
				 startMinute,
				 startDay,
				 startMonth,
				 startYear,
				 title,
				 description);
		 calday.addAppt(appt);

		assertEquals(2018, calday.getYear());
		assertEquals(7, calday.getMonth());
		assertEquals(21, calday.getDay());
		assertEquals(15, calday.getSizeAppts());


	 }
	 @Test
	  public void test02()  throws Throwable  {
		 int year = 2018;
		 int month = 7;
		 int day = 21;
		 GregorianCalendar cal = new GregorianCalendar(year, month, day);
		 CalDay calday = new CalDay(cal);
		assertNotEquals("Check", calday.toString());
	 }
//add more unit tests as you needed	
}
