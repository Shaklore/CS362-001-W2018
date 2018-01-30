package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
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

		 if (diagnose) {


			 System.out.println("The number of appointments between "+ todatDate +" and " + tomorrowDate);
			 calDays = new LinkedList<CalDay>();
			 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			 for (int i = 0; i < calDays.size(); i++)
				 System.out.println(calDays.get(i).toString());
		 }
		 //delete a particular appointment from the list
		 if(diagnose){
			 System.out.println("Delete  "+ listAppts.get(2) );
		 }
		 LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(2));
		 if(diagnose){
			 System.out.println("The number of appointments:  "+ listDeletedAppts.size() );

		 }
		 if (diagnose) {
			 System.out.println("The number of appointments between "+ todatDate +" and " + tomorrowDate);

			 calDays = new LinkedList<CalDay>();
			 calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			 for (int i = 0; i < calDays.size(); i++)
				 System.out.println(calDays.get(i).toString());
		 }
		 System.exit(0);
	 }
	 @Test
	  public void test02()  throws Throwable  {
		 
	 }
//add more unit tests as you needed
}
