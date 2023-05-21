package assignment1WordSearch;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ManagerWordSearch {

	 private WordSearch wordSearch;
	 private Scanner scanner;

	    // Constructor
	    public ManagerWordSearch() {
	        wordSearch = new WordSearch(12, 18);
	        scanner = new Scanner(System.in);
	    }	    
	    
	    // Menu. Generate, Print, Solve.
	    public void runWordSearch() {
        
	    while (true) {
	    	System.out.printf("Hello and welcome!\n");
	    	System.out.println("Choose an option:");
	    	System.out.println("G - Generate a new puzzle");
	    	System.out.println("P - Print the puzzle");
	    	System.out.println("S - Show the solution");

	    	String choice = scanner.nextLine().trim().toLowerCase();
	        
            switch (choice) {
                case "generate":
                case "g":
                case "new":
                case "n":
                	wordSearch.generate();
                    wordSearch.printPuzzle();

                    System.out.print("Do you want to see the solution? (Y/N): ");
                    String seeSolution = scanner.nextLine().trim().toLowerCase();
                    if (seeSolution.equalsIgnoreCase("y")) {
                        wordSearch.printSolution();
                    } // end if
                    break;
                case "print":
                case "p":
                    wordSearch.printPuzzle();
                    break;
                case "solve":
                case "s":
                	wordSearch.printSolution();
                	break;
                default:
                	 System.out.println("Invalid choice, please try again.");
                	 continue; // prompt the user again
	    	} // end switch case
	         
	    } // end while loop
	    
        } // end runWordSearch
} // end Manager Class


