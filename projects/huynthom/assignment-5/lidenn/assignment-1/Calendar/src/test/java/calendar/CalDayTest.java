package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

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
		assertTrue(calday.isValid());

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

		 assertEquals(0, calday.getSizeAppts());
		 calday.addAppt(appt);
		 calday.iterator();

		 StringBuilder sb = new StringBuilder();
		 String todayDate = (month + "/" + day + "/" + year);
		 sb.append("\t --- " + todayDate + " --- \n");
		 sb.append(" --- -------- Appointments ------------ --- \n");
		 Iterator<Appt> itr = calday.appts.iterator();
		 while(itr.hasNext()) {
			 Object element = itr.next();
			 sb.append(element + " ");
		 }
		 sb.append("\n");

		 assertEquals( sb.toString(), calday.toString());

		assertEquals(2018, calday.getYear());
		assertEquals(7, calday.getMonth());
		assertEquals(21, calday.getDay());
		assertEquals(1, calday.getSizeAppts());

		CalDay blank = new CalDay();
		//blank.iterator();
		assertEquals("", blank.toString());
		assertEquals(null, blank.iterator());

		assertEquals(21, calday.getDay());
		assertEquals(2018, calday.getYear());
		assertEquals(7, calday.getMonth());
		assertEquals(1, calday.getSizeAppts());
		assertNotEquals(null, calday.toString());
		assertNotEquals(null, blank.toString());

		 GregorianCalendar cal2 = new GregorianCalendar(year, month, day);
		 CalDay calday2 = new CalDay(cal2);
		 calday2.addAppt(appt);
		 assertEquals(calday2.getAppts(), calday.getAppts());

		 Appt appt2 = new Appt(15,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 calday.addAppt(appt2);
		 assertEquals(2, calday.getSizeAppts());
		 assertEquals(	"\t1/15/2018 at 9:30pm ,Christmas, Merry Christmas\n", calday.getAppts().getFirst().toString());
		 assertNotEquals(null, calday.iterator());

		 Appt appt3 = new Appt(9,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 calday.addAppt(appt3);
		 assertEquals(	"\t1/15/2018 at 9:30am ,Christmas, Merry Christmas\n", calday.getAppts().getFirst().toString());
		 assertEquals(3, calday.getSizeAppts());

		 Appt appt4 = new Appt(7,
				 startMinute ,
				 startDay ,
				 startMonth ,
				 startYear ,
				 title,
				 description);
		 calday.addAppt(appt3);
		 assertEquals(	"\t1/15/2018 at 9:30am ,Christmas, Merry Christmas\n", calday.getAppts().getFirst().toString());
		 assertEquals(4, calday.getSizeAppts());


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

	@Test
	public void test03()  throws Throwable  {


	}
//add more unit tests as you needed	
}
