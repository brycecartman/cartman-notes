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
			
	private String name; // The name of the counter.
	private int count; // The current count of the counter.
	private static CounterFunctions onCurrentCounter; // What counter am I on?	
	
	Date date = new Date();
	static Calendar calendar = Calendar.getInstance();
	
	private int[] hourlyCount = new int[24]; // 24 hours in a day count.
	private int[] dailyCount = new int[31]; // 31 avg days in a month count.
	private int[][] weeklyCount = new int[5][12]; // 5 avg weeks in a month count plus months.
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
	
	// Sets the current counter's date.
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
			this.monthlyCount = null;
			this.weeklyCount = null;
			this.dailyCount = null;
			this.hourlyCount = null;
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
		if(calendar.get(calendar.MONTH) == 0){
			onCurrentCounter.monthlyCount[0]++;
		}
		//February
		if(calendar.get(calendar.MONTH) == 1){
			onCurrentCounter.monthlyCount[1]++;
		}
		//March
		if(calendar.get(calendar.MONTH) == 2){
			onCurrentCounter.monthlyCount[2]++;
		}
		//April
		if(calendar.get(calendar.MONTH) == 3){
			onCurrentCounter.monthlyCount[3]++;
		}
		//May
		if(calendar.get(calendar.MONTH) == 4){
			onCurrentCounter.monthlyCount[4]++;
		}
		//June
		if(calendar.get(calendar.MONTH) == 5){
			onCurrentCounter.monthlyCount[5]++;
		}
		//July
		if(calendar.get(calendar.MONTH) == 6){
			onCurrentCounter.monthlyCount[6]++;
		}
		//August
		if(calendar.get(calendar.MONTH) == 7){
			onCurrentCounter.monthlyCount[7]++;
		}
		//September
		if(calendar.get(calendar.MONTH) == 8){
			onCurrentCounter.monthlyCount[8]++;
		}
		//October
		if(calendar.get(calendar.MONTH) == 9){
			onCurrentCounter.monthlyCount[9]++;
		}
		//November
		if(calendar.get(calendar.MONTH) == 10){
			onCurrentCounter.monthlyCount[10]++;
		}
		//December
		if(calendar.get(calendar.MONTH) == 11){
			onCurrentCounter.monthlyCount[11]++;
		}
	}
	
	
	// This function will deal with the weeky statistics for the counter.
	public static void weeklyStats(){
			
		//January
		if(calendar.get(calendar.MONTH) == 0){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][0]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][0]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][0]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][0]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][0]++;
		}
		//February
		if(calendar.get(calendar.MONTH) == 1){

			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][1]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][1]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][1]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][1]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][1]++;
		}
		//March
		if(calendar.get(calendar.MONTH) == 2){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][2]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][2]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][2]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][2]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][2]++;
		}
		//April
		if(calendar.get(calendar.MONTH) == 3){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][3]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][3]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][3]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][3]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][3]++;
		}
		//May
		if(calendar.get(calendar.MONTH) == 4){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][4]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][4]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][4]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][4]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][4]++;
		}
		//June
		if(calendar.get(calendar.MONTH) == 5){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][5]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][5]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][5]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][5]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][5]++;
		}
		//July
		if(calendar.get(calendar.MONTH) == 6){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][6]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][6]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][6]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][6]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][6]++;
		}
		//August
		if(calendar.get(calendar.MONTH) == 7){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][7]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][7]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][7]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][7]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][7]++;
		}
		//September
		if(calendar.get(calendar.MONTH) == 8){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][8]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][8]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][8]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][8]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][8]++;
		}
		//October
		if(calendar.get(calendar.MONTH) == 9){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][9]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][9]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][9]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][9]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][9]++;
		}
		//November
		if(calendar.get(calendar.MONTH) == 10){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][10]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][10]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][10]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][10]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][10]++;
		}
		//December
		if(calendar.get(calendar.MONTH) == 11){
			if(calendar.get(calendar.WEEK_OF_MONTH) == 1)
				onCurrentCounter.weeklyCount[0][11]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 2)
				onCurrentCounter.weeklyCount[1][11]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 3)
				onCurrentCounter.weeklyCount[2][11]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 4)
				onCurrentCounter.weeklyCount[3][11]++;
			if(calendar.get(calendar.WEEK_OF_MONTH) == 5)
				onCurrentCounter.weeklyCount[4][11]++;
		}
	}

}



