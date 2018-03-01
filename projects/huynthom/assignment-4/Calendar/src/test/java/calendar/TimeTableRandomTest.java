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

				int startHour=ValuesGenerator.RandInt(random);
				int startMinute=ValuesGenerator.RandInt(random);
				int startDay=ValuesGenerator.RandInt(random);;
				int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int startYear=ValuesGenerator.RandInt(random);
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

				int startHour2=ValuesGenerator.getRandomIntBetween(random, -20, 80);
				int startMinute2=ValuesGenerator.getRandomIntBetween(random, -20, 80);
				int startDay2=ValuesGenerator.getRandomIntBetween(random, -20, 60);
				int startMonth2=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear2=ValuesGenerator.RandInt(random);
				String title2="Birthday Party";
				String description2="This is my birthday party.";
				// System.out.println("Random day is " + startDay2);
				Appt appt2 = new Appt(startHour2,
						startMinute2 ,
						startDay2 ,
						startMonth2 ,
						startYear2 ,
						title2,
						description2);

				int startHour3=ValuesGenerator.getRandomIntBetween(random, -20, 80);
				int startMinute3=ValuesGenerator.getRandomIntBetween(random, -20, 80);
				int startDay3=ValuesGenerator.getRandomIntBetween(random, -20, 60);
				int startMonth3=ValuesGenerator.getRandomIntBetween(random, 1, 12);
				int startYear3=ValuesGenerator.RandInt(random);
				String title3="Birthday Party";
				String description3="This is my birthday party.";
				// System.out.println("Random day is " + startDay2);
				Appt appt3 = new Appt(startHour2,
						startMinute2 ,
						startDay2 ,
						startMonth2 ,
						startYear2 ,
						title2,
						description2);
				//System.out.println("Made it out");
				if(!appt.getValid())continue;
				LinkedList<Appt> appts = new LinkedList<Appt>();
				TimeTable tt = new TimeTable();

				appts.add(appt);
				appts.add(appt2);
				appts.add(appt3);

				int thisDay=ValuesGenerator.RandInt(random);
				int thisMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				int thisYear=ValuesGenerator.RandInt(random);
				GregorianCalendar today = new GregorianCalendar(thisYear, thisMonth, thisDay);
				GregorianCalendar tomorrow = new GregorianCalendar(thisYear, thisMonth, thisDay+3);


				tt.getApptRange(appts, today, tomorrow);
				//tt.getApptRange(appts, tomorrow, today);
				tt.deleteAppt(appts, appt3);
				if ((startHour < 0) && (startHour2 < 0) && (startHour3 < 0)) {
					appts = null;
				}
				tt.deleteAppt(appts, appt2);
				//assertEquals(null, tt.deleteAppt(appts, null));
				//assertEquals(null, tt.deleteAppt(null, appt));
				tt.deleteAppt(appts, null);
				tt.deleteAppt(null, appt);
				tt.deleteAppt(appts, appt);
				//reach the null condition
				tt.deleteAppt(appts, appt);


				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");
	}



}