package calendar;


import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"setTitle","setRecurrence"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
	public static int RandomSelectRecur(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return the value of the  appointments to recur
	}
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
	public static int RandomSelectRecurForEverNever(Random random){
		int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

		int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
		return RecurArray[n] ; // return appointments to recur forever or Never recur
	}
	/**
	 * Generate Random Tests that tests Appt Class.
	 */

    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {


		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 //test invalid values
				 int startHour=ValuesGenerator.getRandomIntBetween(random, -1, 27);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, -1, 65);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, -1, 50);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				 int startYear=ValuesGenerator.RandInt(random);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 // System.out.println("Random day is " + startDay2);
				 Appt appt = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						 description);

				 int startHour2=ValuesGenerator.RandInt(random);
				 int startMinute2=ValuesGenerator.RandInt(random);
				 int startDay2=ValuesGenerator.RandInt(random);
				 int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear2=ValuesGenerator.RandInt(random);
				 String title2="Birthday Party";
				 String description2="This is my birthday party.";
				 //Construct a new Appointment object with the initial data
				 Appt appt2 = new Appt(startHour2,
						 startMinute2 ,
						 startDay2 ,
						 startMonth2 ,
						 startYear2 ,
						 title2,
						 description2);
				 Appt appt3 = new Appt(100,
						 100 ,
						 startDay2 ,
						 startMonth2 ,
						 startYear2 ,
						 title2,
						 description2);
				 int year=ValuesGenerator.RandInt(random);
				 int month = ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int day = ValuesGenerator.getRandomIntBetween(random, 1, 28);
				 //int month2 = ValuesGenerator.getRandomIntBetween(random, 1, 11);

				 LinkedList<Appt> listAppts = new LinkedList<Appt>();
				 LinkedList<Appt> nullAppts = null;
				 TimeTable timetable = new TimeTable();

				 listAppts.add(appt);
				 listAppts.add(appt);
				 listAppts.add(appt3);

				 GregorianCalendar today = new GregorianCalendar(startYear, month, day);
				 GregorianCalendar tomorrow = new GregorianCalendar(startYear, month, day+5);

				 timetable.getApptRange(listAppts, today, tomorrow);

				 timetable.deleteAppt(listAppts, null);
				 timetable.deleteAppt(listAppts, appt);
				 timetable.deleteAppt(listAppts, appt3);
				 timetable.deleteAppt(listAppts, appt2);
				 timetable.deleteAppt(nullAppts, null);
				 timetable.deleteAppt(nullAppts, appt);



				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if((iteration%10000)==0 && iteration!=0 )
					 System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			 }
		 }catch(NullPointerException e){

		 }

		 System.out.println("Done testing...");

	 }



}
