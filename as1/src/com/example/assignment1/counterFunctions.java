package com.example.assignment1;

import java.util.ArrayList;

// This class will hold all the counter functions such as setting up the
// counter, viewing it, modifying it, etc. This is a very important function.

public class counterFunctions {

	// This creates the ArrayList that will hold the "counters".
	public static ArrayList<counterFunctions> counters = new ArrayList<counterFunctions>();
	
	private String name; // The name of the counter.
	private int count; // The current count of the counter.
	private static counterFunctions onCurrentCounter; // What counter am I on?
	
	// This creates the counter with a given "counterName", default count (0).
	public counterFunctions(String counterName){
		onCurrentCounter = null;
		this.name = counterName;
		this.count = 0;
	}
	
	// Gets the counters' ArrayList.
	public static ArrayList<counterFunctions> getCounters(){
		return counters;
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
		}
	
	// Create a new counter with the name "counterName".
	public static void addCounter(String counterName){
		counters.add(new counterFunctions(counterName));
	}
	
	// Returns the current value of count.
	public static int getCount(){
		return onCurrentCounter.count();
	}
	
	// Gets the name of the current counter.
	public static String getCurrentName(){
		return onCurrentCounter.name();
	}
	
	// Sets the counter to "null" making it default.
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
	
	
	// Checks to see if the counter is empty or not. TRUE/FALSE notation.
	public static boolean isEmpty(){
		if(onCurrentCounter == null)
			return true;
		else{
			return false;
		}
		}
	
	}



