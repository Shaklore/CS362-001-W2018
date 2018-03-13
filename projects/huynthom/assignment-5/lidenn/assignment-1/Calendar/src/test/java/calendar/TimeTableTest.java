package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {

	 @Test
	  public void test01()  throws Throwable  {
		 TimeTable timeTable=new TimeTable();
		 boolean diagnose = true;
		 int thisYear = 2014;
		 int thisMonth = 11;
		 int thisDay = 30;
		 GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
		 GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
		 tomorrow.add(Calendar.DAY_OF_MONTH,1);
		 String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
		 String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);
		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 timeTable.getApptRange(listAppts, today, tomorrow);



			 calDays = new LinkedList<CalDay>();
			 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			 for (int i = 0; i < calDays.size(); i++){
				 //System.out.println(calDays.get(i).toString());
		 }
		 //System.exit(0);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		TimeTable timetable = new TimeTable();

		GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
		GregorianCalendar day2 = new GregorianCalendar(2018, 2, 2);
		GregorianCalendar day3 = new GregorianCalendar(2018, 3, 3);
		GregorianCalendar day4 = new GregorianCalendar(2018, 4, 4);

		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		CalDay calday = new CalDay(day1);
		CalDay calday2 = new CalDay(day2);
		CalDay calday3 = new CalDay(day3);
		CalDay calday4 = new CalDay(day4);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt = new Appt(01, 01, 03, 03, 2018,  "Seattle Trip", "Seattle Great Wheel");
		 Appt appt2 = new Appt(02,02, 05, 05, 2019, "New York Trip", "One World Trade Center");
		 Appt appt3 = new Appt(10,30, 21, 07, 2020, "Vietnam Trip", "Mekong Delta");

		LinkedList<CalDay> appRangeList= timetable.getApptRange(listAppts, day1, day2);
		listAppts.add(appt);
		listAppts.add(appt2);
		listAppts.add(appt3);

		 calDays=timetable.getApptRange(listAppts, day1, day4);

		 assertNotEquals("Second date specified is not before the first date specified.", timetable.getApptRange(listAppts, day1, day4));

		 LinkedList<Appt> nullAppts = null;
		 assertEquals(null, timetable.deleteAppt(nullAppts, appt));

		 assertEquals(true, appt3.getValid());
		 assertEquals(true, appt2.getValid());
		 assertEquals(true, appt.getValid());
		 timetable.deleteAppt(listAppts,appt3);
		 assertEquals(true, appt3.getValid());
		 assertEquals(null, timetable.deleteAppt(listAppts, appt3));
		 timetable.deleteAppt(listAppts,appt2);
		 assertEquals(null, timetable.deleteAppt(listAppts,appt2));
		 timetable.deleteAppt(listAppts,appt);
		 assertEquals(null, timetable.deleteAppt(listAppts, appt));
		 timetable.deleteAppt(nullAppts, appt);
		 assertEquals(null, timetable.deleteAppt(listAppts, null));
		 assertEquals(null, timetable.deleteAppt(nullAppts, null));
		 assertEquals(true, appt.getValid());

		 LinkedList<Appt> deleteList = timetable.deleteAppt(listAppts,appt);
		 deleteList = timetable.deleteAppt(listAppts, appt3);
		 deleteList = timetable.deleteAppt(nullAppts, appt);
		 Appt blank_appt = null;
		 listAppts.add(blank_appt);
		 deleteList = timetable.deleteAppt(listAppts, blank_appt);

		 LinkedList<Appt> blankApptslist = new LinkedList<Appt>();
		 TimeTable blank_table = new TimeTable();
		 int[] pv = new int [0];
		 assertNotNull(timetable.permute(blankApptslist, pv));
		 assertEquals(null, blank_table.deleteAppt(listAppts,null));

	 }
	 @Test
	public void test03() throws Throwable{
		 TimeTable timetable = new TimeTable();

		 GregorianCalendar day1 = new GregorianCalendar(2018, 1, 1);
		 GregorianCalendar day2 = new GregorianCalendar(2018, 2, 2);
		 GregorianCalendar day3 = new GregorianCalendar(2018, 3, 3);
		 GregorianCalendar day4 = new GregorianCalendar(2018, 4, 4);

		 LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		 CalDay calday = new CalDay(day1);
		 CalDay calday2 = new CalDay(day2);
		 CalDay calday3 = new CalDay(day3);
		 CalDay calday4 = new CalDay(day4);

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();
		 Appt appt = new Appt(01, 01, 03, 03, 2018,  "Seattle Trip", "Seattle Great Wheel");
		 Appt appt2 = new Appt(02,02, 05, 05, 2019, "New York Trip", "One World Trade Center");
		 Appt appt3 = new Appt(10,30, 21, 07, 2020, "Vietnam Trip", "Mekong Delta");

		 int [] pv = {};
		 timetable.permute(listAppts, pv);

		 LinkedList<CalDay> appRangeList= timetable.getApptRange(listAppts, day1, day2);
		 listAppts.add(appt);
		 listAppts.add(appt2);
		 listAppts.add(appt3);


	 }

	 @Test
	public void test04() throws Throwable{
		 TimeTable timetable = new TimeTable();

		 LinkedList<Appt> listAppts = new LinkedList<Appt>();

		 Appt appt = new Appt(01, 10, 03, 03, 2018,  "Seattle Trip", "Seattle Great Wheel");
		 Appt appt2 = new Appt(02,10, 05, 05, 2019, "New York Trip", "One World Trade Center");
		 Appt appt3 = new Appt(10,30, 21, 07, 2020, "Vietnam Trip", "Mekong Delta");


		 listAppts.add(appt);
		 listAppts.add(appt2);
		 //listAppts.add(appt3);
		 int[] pv = {0, 1};
		 timetable.permute(listAppts, pv);

		 assertEquals("[	3/3/2018 at 1:10am ,Seattle Trip, Seattle Great Wheel\n" +
				 ", 	5/5/2019 at 2:10am ,New York Trip, One World Trade Center\n" +
				 "]", timetable.permute(listAppts, pv).toString());
		 timetable.deleteAppt(listAppts, appt2);


	 }
//add more unit tests as you needed
}
