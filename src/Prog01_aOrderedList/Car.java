package Prog01_aOrderedList;

/**
* Car holds the data for car object and then compares the different car objects
* 
* CSC 1351 Programming Project No 1
7
* Section 2
* 
* @author Hailey Theunissen
* @since 3/17/24
*
*/
public class Car implements Comparable<Car>{
	private String make;
	private int year;
	private int price;
	
	/**
	* car constructor that sets the values of make, year, and price
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public Car (String make, int year, int price) {
		this.make = make;
		this.year = year;
		this.price = price;
	}
	
	/**
	* returns the make of the car
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public String getMake() {
		return make;
	}
	
	/**
	* returns year of car
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public int getYear() {
		return year;
	}
	
	/**
	* returns price of car
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public int getPrice() {
		return price;
	}
	
	/**
	* compares the cars by make then year if the make is the same
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public int compareTo(Car other) {
		if(make.compareTo(other.make) != 0) {
			 return make.compareTo(other.make);
		}
		else {
        return Integer.compare(year,other.year);
		}
	}
	
	/**
	* returns string
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public String toString() {
		return String.format("Make: %s, Year: %d, Price: %d ;", this.make, this.year, this.price);

	}
}
