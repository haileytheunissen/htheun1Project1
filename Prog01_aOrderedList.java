package Prog01_aOrderedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

/**
* Prog01_aOrderedList is the main class that gets file input and stores the cars data in an organized list on an output file
* 
* CSC 1351 Programming Project No 1
7
* Section 2
* 
* @author Hailey Theunissen
* @since 3/17/24
*
*/
public class Prog01_aOrderedList {
	static aOrderedList<Car> orderedList; // declaring static ordered list of type Car
	/**
	* Main method
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public static void main(String[] args) throws FileNotFoundException{
		
		// Step 1: Get input file from the user
        Scanner inputScanner = GetInputFile("Enter input filename: ");
        orderedList = new aOrderedList<>(); // creating new instance
        
        // Step 2: Read input from input file
        while (inputScanner.hasNextLine()) {
            String line = inputScanner.nextLine();
            String[] tokens = line.split(",");
            // Adds or deletes cars
            if (tokens[0].equals("A")) {
                // Add a car to the ordered list
                if (tokens.length == 4) {
                    String make = tokens[1];
                    int year = Integer.parseInt(tokens[2]);
                    int price = Integer.parseInt(tokens[3]);
                    Car newCar = new Car(make, year, price);
                    orderedList.add(newCar);
                }
            } else if (tokens[0].equals("D")) {
                // Delete a car from the ordered list
                if (tokens.length == 3) {
                    String make = tokens[1];
                    int year = Integer.parseInt(tokens[2]);
                    // Implements the delete logic
                }
            }
        }

        // Step 3: Get output file from the user
        PrintWriter outputWriter = GetOutputFile("Enter output filename: ");
        printOutputFile(outputWriter);

        // Close resources
        inputScanner.close();
        outputWriter.close();
    }     
    
	
	/**
	* Gets filename of input file and returns the scanner pointing to the file name
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public static Scanner GetInputFile(String userPrompt) throws FileNotFoundException {
		 Scanner inputScanner = new Scanner(System.in);
		 boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(userPrompt);
                String filename = inputScanner.next();
                File file = new File(filename);

                if (file.exists()) {
                    inputScanner = new Scanner(file);
                    validInput = true;
                } else {
                    System.out.println("File specified <" + filename + "> does not exist. Would you like to continue? <Y/N> ");
                    String response = inputScanner.next();

                    if (response.equalsIgnoreCase("N")) {
                        throw new FileNotFoundException("File not found.");
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("Program execution canceled.");
                System.exit(1);
            }
        }

        return inputScanner;
    }

	/**
	* Gets filename of output file and returns printwriter pointing to file name or null
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public static PrintWriter GetOutputFile(String userPrompt) throws FileNotFoundException{
		Scanner scan = new Scanner(System.in);
        File outputFile;
        String fileName;
        String response;
        PrintWriter pw;
        if (userPrompt.equals("Enter output filename: ")) {
            System.out.println("Enter output filename:");
            fileName = scan.next();
            outputFile = new File(fileName);
            if (!outputFile.exists()) {
                System.out.println("File specified" + fileName + "does not exist. Would you like to ocntinue ? <Y/N>");
                response = scan.next();
                GetOutputFile(response);

            } else {
                pw = new PrintWriter(new File(fileName));// if file exists this will return printwriter
                return pw;
            }
        } else
            throw new FileNotFoundException();
        return null;

    }
	
	/**
	* prints to the output file
	* 
	* CSC 1351 Programming Project No 1
	* Section 2
	* 
	* @author Hailey Theunissen
	* @since 3/17/24
	*
	*/
	public static void printOutputFile(PrintWriter pw) {
		int listSize = orderedList.size(); // initialized parameters with methods that return values to use printf
        pw.printf("Number of cars :%10d\n", listSize);
        pw.println();
        for (int i = 0; i < orderedList.size(); i++) {
        	String carMake = orderedList.get(i).getMake();
        	int carYear = orderedList.get(i).getYear();
        	int carPrice = orderedList.get(i).getPrice();
            pw.printf("Make  :%10s\n",carMake);
            pw.printf("Year  :%10d\n",carYear);
            pw.printf("Price :%,10d\n",carPrice);
            pw.println();
        }

    }
}
