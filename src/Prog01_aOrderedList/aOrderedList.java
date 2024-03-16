package Prog01_aOrderedList;

import java.util.Arrays;
import java.util.Comparator;

/**
* aOrderedList sorts the car list
* 
* CSC 1351 Programming Project No 1
7
* Section 2
* 
* @author Hailey Theunissen
* @since 3/17/24
*
*/
public class aOrderedList<Car extends Comparable<Car>> {
	final int SIZEINCREMENTS = 20;// size of increments for increasing ordered list
	private Car[] oList;// the ordered list
	private int listSize;// the size of the ordered list
	private int numObjects;// the number of objects in the ordered list
	private int curr;// index of current element accessed via iterator methods
	
	/**
	* aOrderedList constructor sets number of objects to 0, sets list size to
	* SIZEINCREMENTS, and instantiates the array oList to an array of the size
	* SIZEINCREMENTS
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public aOrderedList() {
		 listSize = SIZEINCREMENTS;
	        oList = (Car[]) new Comparable[listSize];
	        numObjects = 0;
	}
	
	/**
	* adds newCar object to the sorted array in the correct position
	* to maintain sorted order
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public void add(Car newObject) {
        if (numObjects == listSize) {
            listSize += SIZEINCREMENTS;
            Car[] newOList = (Car[]) new Comparable[listSize];
            System.arraycopy(oList,0,newOList,0,oList.length);
            oList = newOList;
        }
        int i = numObjects - 1;
        while (i >= 0 && oList[i].compareTo(newObject) > 0) {
            oList[i + 1] = oList[i];
            i--;
        }
        oList[i + 1] = newObject;
        numObjects++;
	}
	
	/**
	* returns toString values of the list objects, separated by commas,
	* and delimited by brackets
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public String toString() {
		if (oList.length > 0) {
            for (int i = 0; i < oList.length; i++) {
                return "[" + oList[i].toString() + "]";
            }
        }
		// calls to the toString of the Car objects in oList array to construct
		// the return value of the new method
        return "[]";
	}
	
	/**
	* returns array size/ number of elements in the list
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	 public int size() { 
		 return numObjects; 
	 }

	/**
	* returns element at the specified index in this list
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public Car get(int index){
		 if (index >= 0 && index < numObjects) {
	            return oList[index];
	        }
	        return null;
	}

	/**
	* checks if array is empty, true if empty, false otherwise
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public boolean isEmpty() {
		  if (numObjects == 0) return true;
	        return false;
	}

	/**
	* removes element at the specified position in the list
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public void remove(int index){
		  if (index <= numObjects) {
	           for (int i = index; i < numObjects; i++) {
	               oList[i] = oList[i + 1];
	            }
	        oList[numObjects] = null;
	        numObjects--;
		   }
	}
	
	/**
	* resets iterator parameters so that the "next" element is the first in the 
	* array, if any
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public void reset() {
		curr = 0;
	}
	
	/**
	* returns the next element in the iteration and increments the
	* iterator parameters
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public Car next() {
		return oList[curr +1];
	}
	
	/**
	* returns true if the iteration has more elements to iterate through
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public boolean hasNext() {
		return curr+1<=numObjects;
	}
	
	
}

