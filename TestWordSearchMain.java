// Programmer: Adam Curtin
// Course: CS 145 Java
// Project: Assignment 1 - word search
// Date: 5/15/2023
// Purpose: Testing class for word search. 

package assignment1WordSearch;

//import java.util.*;

//public class TestWordSearchMain {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//
////		        ManagerWordSearch manager = new ManagerWordSearch();
////		        manager.run();
////		    }
////		}
//		
////		public static void testFillGrid() {
////	        // Code to test WordSearch fillGrid() method
////	    }
////
////	    public static void testPlaceWords() {
////	        // Code to test WordSearch placeWords() method
////	    }
////
////	    public static void testCreateWordSearch() {
////	        // Code to test WordSearchManager createWordSearch() method
////	    }
////
////	    public static void testDisplayPuzzle() {
////	        // Code to test WordSearchManager displayPuzzle() method
////	    }
//		
//		System.out.printf("Hello and welcome!\n");
//        System.out.println("Enter words to be placed in the word \nsearch. 5 words please.");
//
//        Scanner scanner = new Scanner(System.in);
//        // initialize variable 'line' to hold user input
//        String line = "";
//        List<String> userWords = new ArrayList<>();
//        while (!(line = scanner.nextLine().trim()).isEmpty()) {
//            userWords.add(line.toUpperCase());
//        } // end while
//        
//        // Print out the Word, number, and the word, so user knows what they've chosen
//        for (int i = 1; i <= 5; i++) {
//            System.out.println("Word " + i + ":");
//        } // end for 1-5
//        System.out.println();
//        char[][] grid = new char[12][18];
//
//        // Fill the grid with random letters
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                // Generate a random uppercase letter
//                grid[i][j] = (char)('A' + (int)(Math.random() * 26));
//            } // end inner for
//        } // end outer for
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                System.out.print(grid[i][j] + " ");
//            } // end inner for
//            System.out.println();
//        } // end outer for
//		
//	} // end main
//
//} // end TestWordSearchMain



import java.util.*;

public class TestWordSearchMain {

    public static void main(String[] args) {

        System.out.printf("Hello and welcome!\n");
        System.out.println("Enter words to be placed in the word search. 5 words, please.");

        Scanner scanner = new Scanner(System.in);
        String line = "";
        List<String> userWords = new ArrayList<>();

        // Collect user input
        for (int i = 1; i <= 5; i++) {
            System.out.print("Word " + i + ": ");
            line = scanner.nextLine().trim();
            userWords.add(line.toUpperCase());
        } // end for 1-5

        // create a 12x18 grid
        char[][] grid = new char[12][18];

        

        // Fill all of the cells with random letters
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Generate a random uppercase letter
                grid[i][j] = (char) ('A' + (int) (Math.random() * 26));
            } // end inner for
        } // end outer for

        // Put user words in the first 5 rows of the grid
        for (int i = 0; i < 5; i++) {
            String word = userWords.get(i);
            for (int j = 0; j < word.length(); j++) {
                grid[i][j] = word.charAt(j);
            } // end inner for
        } // end outer for
        
        // Print the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            } // end inner for
            System.out.println();
        } // end outer for
        
        scanner.close();
    }
}

