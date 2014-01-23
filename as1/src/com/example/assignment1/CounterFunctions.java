package com.example.assignment1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.content.Context;

// This class will hold all the counter functions such as setting up the
// counter, viewing it, modifying it, etc. This is a very important function.

// James Hodgson gave me the idea of using ArrayList and moving some of my functions
// as I was using a fixed array[] at first to hold the data and it had a long list
// of problems. After studying ArrayList I finally fixed my previous errors. Thanks.

public class CounterFunctions implements Serializable{

	// This creates the ArrayList that will hold the "counters".
	public static ArrayList<CounterFunctions> counters = new ArrayList<CounterFunctions>();
			
	/**
	 * @uml.property  name="name"
	 */
	private String name; // The name of the counter.
	/**
	 * @uml.property  name="count"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="java.util.ArrayList"
	 */
	private int count; // The current count of the counter.
	private static CounterFunctions onCurrentCounter; // What counter am I on?	
	
	/**
	 * @uml.property  name="date"
	 */
	Date date = new Date();
	static Calendar calendar = Calendar.getInstance();
	
	/**
	 * @uml.property  name="hourlyCount" multiplicity="(0 -1)" dimension="3"
	 */
	private int[][][] hourlyCount = new int[12][32][25]; // Hourly count per month and day.
	/**
	 * @uml.property  name="dailyCount" multiplicity="(0 -1)" dimension="2"
	 */
	private int[][] dailyCount = new int[12][32]; // 12 months and 31 average days.
	/**
	 * @uml.property  name="weeklyCount" multiplicity="(0 -1)" dimension="2"
	 */
	private int[][] weeklyCount = new int[5][12]; // 5 average weeks in a month count plus months.
	/**
	 * @uml.property  name="monthlyCount" multiplicity="(0 -1)" dimension="1"
	 */
	private int[] monthlyCount = new int[12]; // 12 months in a year count.
	
	
	// This creates the counter with a given "counterName", default count (0).
	public CounterFunctions(String counterName){
		onCurrentCounter = null;
		this.name = counterName;
		this.count = 0;
	}

	// Gets the counters' ArrayList. For saving and restoring the counter.
	public static ArrayList<CounterFunctions> getCounters(){
		return counters;
	}
	
	// Returns the current counter.s date
	/**
	 * @return
	 * @uml.property  name="date"
	 */
	public static Date getDate(){
		return onCurrentCounter.date;
	}
	
	// Returns the monthly statistics.
	public static int[] getMonthlyStats(){
		return onCurrentCounter.monthlyCount;
	}
	
	// Returns the weekly statistics.
	public static int[][] getWeeklyStats(){
		return onCurrentCounter.weeklyCount;
	}
	
	// Returns the daily statistics.
	public static int[][] getDailyStats(){
		return onCurrentCounter.dailyCount;
	}
	
	// Returns the daily statistics.
	public static int[][][] getHourlyStats(){
		return onCurrentCounter.hourlyCount;
	}
	
	// Sets the current counter's date.
	/**
	 * @param date
	 * @uml.property  name="date"
	 */
	public void setDate(Date date){
		onCurrentCounter.date = date;
	}
	
	// Returns the count of the counter.
	private int count(){
		return this.count;
	}

	// Returns the name of the counter.
	public String name(){
		return this.name;
	}
		
	// Increments the counter.
	private void incrementCurrentCounter(){
		this.count = this.count + 1;
	}
	
	// Resets the counter.
	private void resetCurrentCounter(){
			this.count = 0;
			this.monthlyCount = new int[12];
			this.weeklyCount = new int[5][12];
			this.dailyCount = new int[12][32];
			this.hourlyCount = new int[12][32][25];
	}
	
	// Create a new counter with the name "counterName".
	public static void addCounter(String counterName){
		counters.add(new CounterFunctions(counterName));
	}
	
	// Returns the current value of count.
	public static int getCount(){
		return onCurrentCounter.count();
	}
	
	// Gets the name of the current counter.
	public static String getCurrentName(){
		return onCurrentCounter.name();
	}
	
	// Sets the counter to "null" making it deleted.
	public static void deleteCounter(){
		onCurrentCounter = null;
	}
	
	// Resets the counter back to count = 0.
	public static void resetCounter(){
		onCurrentCounter.resetCurrentCounter();
	}
	
	// Increments the counter my "1".
	public static void incrementCounter(){
		onCurrentCounter.incrementCurrentCounter();
	}
	
	
	// Sets the counter to the one you want to modify.
	public static void setCounter(int i){
		onCurrentCounter = counters.get(i);
	}
	
	// Renames the counter
	/**
	 * @param newName
	 * @uml.property  name="name"
	 */
	public static void setName(String newName){
		onCurrentCounter.name = newName;
	}
	
	// Saves the counter ArrayList file into "file.txt".
	public static void saveCounters(Context context){
		FileOutputStream fileOut;
		try {
			fileOut = context.openFileOutput("file.txt", Context.MODE_PRIVATE);
			ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(counters);
			objOut.close();
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	// Restores the counter ArrayList file from "file.txt".
	@SuppressWarnings("unchecked")
	public static void restoreCounters(Context context){
		FileInputStream fileIn;
		try {
			fileIn = context.openFileInput("file.txt");
			ObjectInputStream objIn = new ObjectInputStream(fileIn);
			counters = (ArrayList<CounterFunctions>) objIn.readObject();
			objIn.close();
		}catch (FileNotFoundException e){
			return;
		}catch (Exception e){
			e.printStackTrace();
		}		
	}
	
	// This function will deal with the monthly statistics for the counter.
	public static void monthlyStats(){
		
		//January
		if(calendar.get(Calendar.MONTH) == 0){
			onCurrentCounter.monthlyCount[0]++;
		}
		//February
		if(calendar.get(Calendar.MONTH) == 1){
			onCurrentCounter.monthlyCount[1]++;
		}
		//March
		if(calendar.get(Calendar.MONTH) == 2){
			onCurrentCounter.monthlyCount[2]++;
		}
		//April
		if(calendar.get(Calendar.MONTH) == 3){
			onCurrentCounter.monthlyCount[3]++;
		}
		//May
		if(calendar.get(Calendar.MONTH) == 4){
			onCurrentCounter.monthlyCount[4]++;
		}
		//June
		if(calendar.get(Calendar.MONTH) == 5){
			onCurrentCounter.monthlyCount[5]++;
		}
		//July
		if(calendar.get(Calendar.MONTH) == 6){
			onCurrentCounter.monthlyCount[6]++;
		}
		//August
		if(calendar.get(Calendar.MONTH) == 7){
			onCurrentCounter.monthlyCount[7]++;
		}
		//September
		if(calendar.get(Calendar.MONTH) == 8){
			onCurrentCounter.monthlyCount[8]++;
		}
		//October
		if(calendar.get(Calendar.MONTH) == 9){
			onCurrentCounter.monthlyCount[9]++;
		}
		//November
		if(calendar.get(Calendar.MONTH) == 10){
			onCurrentCounter.monthlyCount[10]++;
		}
		//December
		if(calendar.get(Calendar.MONTH) == 11){
			onCurrentCounter.monthlyCount[11]++;
		}
	}
	
	
	// This function will deal with the weeky statistics for the counter.
	public static void weeklyStats(){
			
		//January
		if(calendar.get(Calendar.MONTH) == 0){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][0]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][0]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][0]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][0]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][0]++;
		}
		//February
		if(calendar.get(Calendar.MONTH) == 1){

			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][1]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][1]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][1]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][1]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][1]++;
		}
		//March
		if(calendar.get(Calendar.MONTH) == 2){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][2]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][2]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][2]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][2]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][2]++;
		}
		//April
		if(calendar.get(Calendar.MONTH) == 3){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][3]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][3]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][3]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][3]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][3]++;
		}
		//May
		if(calendar.get(Calendar.MONTH) == 4){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][4]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][4]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][4]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][4]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][4]++;
		}
		//June
		if(calendar.get(Calendar.MONTH) == 5){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][5]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][5]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][5]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][5]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][5]++;
		}
		//July
		if(calendar.get(Calendar.MONTH) == 6){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][6]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][6]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][6]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][6]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][6]++;
		}
		//August
		if(calendar.get(Calendar.MONTH) == 7){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][7]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][7]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][7]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][7]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][7]++;
		}
		//September
		if(calendar.get(Calendar.MONTH) == 8){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][8]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][8]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][8]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][8]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][8]++;
		}
		//October
		if(calendar.get(Calendar.MONTH) == 9){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][9]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][9]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][9]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][9]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][9]++;
		}
		//November
		if(calendar.get(Calendar.MONTH) == 10){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][10]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][10]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][10]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][10]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][10]++;
		}
		//December
		if(calendar.get(Calendar.MONTH) == 11){
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][11]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][11]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][11]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][11]++;
			if(calendar.get(Calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][11]++;
		}
	}
	
	// This function will deal with the daily statistics for the counter.
	public static void dailyStats(){
		
		//January
		if(calendar.get(Calendar.MONTH) == 0){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[0][i]++;
			}
		}
		//February
		if(calendar.get(Calendar.MONTH) == 1){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[1][i]++;
			}
		}
		//March
		if(calendar.get(Calendar.MONTH) == 2){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[2][i]++;
			}
		}
		//April
		if(calendar.get(Calendar.MONTH) == 3){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[3][i]++;
			}
		}
		//May
		if(calendar.get(Calendar.MONTH) == 4){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[4][i]++;
			}
		}
		//June
		if(calendar.get(Calendar.MONTH) == 5){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[5][i]++;
			}
		}
		//July
		if(calendar.get(Calendar.MONTH) == 6){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[6][i]++;
			}	
		}
		//August
		if(calendar.get(Calendar.MONTH) == 7){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[7][i]++;
			}
		}
		//September
		if(calendar.get(Calendar.MONTH) == 8){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[8][i]++;
			}
		}
		//October
		if(calendar.get(Calendar.MONTH) == 9){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[9][i]++;
			}	
		}
		//November
		if(calendar.get(Calendar.MONTH) == 10){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[10][i]++;
			}
		}
		//December
		if(calendar.get(Calendar.MONTH) == 11){
			for(int i = 1; i < 32; i++){
				if(calendar.get(Calendar.DAY_OF_MONTH) == i)
					onCurrentCounter.dailyCount[11][i]++;
			}
		}
	}
	
	// This function will deal with the hourly statistics for the counter.
		public static void hourlyStats(){
			
			//January
			if(calendar.get(Calendar.MONTH) == 0){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[0][i][x]++;
							break;
							}
						}
					}
				}
			}
			//February
			if(calendar.get(Calendar.MONTH) == 1){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[1][i][x]++;
							break;
							}
						}
					}
				}
			}
			//March
			if(calendar.get(Calendar.MONTH) == 2){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[2][i][x]++;
							break;
							}
						}
					}
				}
			}
			//April
			if(calendar.get(Calendar.MONTH) == 3){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[3][i][x]++;
							break;
							}
						}
					}
				}
			}
			//May
			if(calendar.get(Calendar.MONTH) == 4){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[4][i][x]++;
							break;
							}
						}
					}
				}
			}
			//June
			if(calendar.get(Calendar.MONTH) == 5){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[5][i][x]++;
							break;
							}
						}
					}
				}
			}
			//January
			if(calendar.get(Calendar.MONTH) == 6){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[6][i][x]++;
							break;
							}
						}
					}
				}
			}
			//August
			if(calendar.get(Calendar.MONTH) == 7){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[7][i][x]++;
							break;
							}
						}
					}
				}
			}
			//September
			if(calendar.get(Calendar.MONTH) == 8){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[8][i][x]++;
							break;
							}
						}
					}
				}
			}
			//October
			if(calendar.get(Calendar.MONTH) == 9){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[9][i][x]++;
							break;
							}
						}
					}
				}
			}
			//November
			if(calendar.get(Calendar.MONTH) == 10){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[10][i][x]++;
							break;
							}
						}
					}
				}
			}
			//January
			if(calendar.get(Calendar.MONTH) == 11){
				for(int i = 1; i < 32; i++){
					if(calendar.get(Calendar.DAY_OF_MONTH) == i){
						for(int x = 1; x < 25; x++){
						if(calendar.get(Calendar.HOUR_OF_DAY) == x){
							onCurrentCounter.hourlyCount[11][i][x]++;
							break;
							}
						}
					}
				}
			}
		}
		
		// This function will sort the counters from highest count to lowest.
		public static void sort(){
			for(int i = 0; i < CounterFunctions.counters.size(); i++){
				for(int j = i + 1; j < CounterFunctions.counters.size(); j++){
				    if(CounterFunctions.counters.get(i).count < CounterFunctions.counters.get(j).count){
				    	CounterFunctions temp = CounterFunctions.counters.get(i);
				    	CounterFunctions.counters.set(i, CounterFunctions.counters.get(j));
				    	CounterFunctions.counters.set(j, temp);
					}
				}
			}
		}

		
}
	




