package assignment1WordSearch;

import java.util.*;

public class WordSearch {

	private char[][] grid;
    private List<String> words;
    private int numRows;
    private int numColumns;

    // Constructor
    public WordSearch(int numRows, int numColumns) {
        grid = new char[numRows][numColumns];
        words = new ArrayList<>();
        this.numRows = numRows;
        this.numColumns = numColumns;
    }
    
    // Method to fill the grid with random letters
    public void fillGrid() {   
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Generate a random upper-case letter
                grid[i][j] = (char) ('A' + (int) (Math.random() * 26));
            } // end inner for
        } // end outer for
    } // end fillGrid
    
 // Method to place the words in the grid
    public void placeWords() {
        for (String word : words) {
            boolean placed = false;

            while (!placed) {
                // Generate a random orientation (horizontal, vertical, or diagonal)
                int orientation = (int) (Math.random() * 3);

                // Generate a random starting position
                int row = (int) (Math.random() * (grid.length - word.length()));
                int col = (int) (Math.random() * (grid[0].length - word.length()));

                // Check if the word can be placed at the starting position
                boolean canPlace = true;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (orientation == 0) { // horizontal
                    	// "-" signifies empty cell.
                        if (grid[row][col + i] != '-' && grid[row][col + i] != c) {
                            canPlace = false;
                            break;
                        }
                    } else if (orientation == 1) { // vertical
                    	// "-" signifies empty cell.
                        if (grid[row + i][col] != '-' && grid[row + i][col] != c) {
                            canPlace = false;
                            break;
                        }
                    } else { // diagonal
                    	// "-" signifies empty cell.
                        if (grid[row + i][col + i] != '-' && grid[row + i][col + i] != c) {
                            canPlace = false;
                            break;
                        }
                    }
                }

                // Place the word in the grid if it can be placed
                // if 0 = Horizontal. else if 1 = vertical. else diagonal
                if (canPlace) {
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        if (orientation == 0) { // horizontal
                            grid[row][col + i] = c;
                        } else if (orientation == 1) { // vertical
                            grid[row + i][col] = c;
                        } else { // diagonal
                            grid[row + i][col + i] = c;
                        } // end else diagonal
                    } // end for
                    placed = true;
                } // end if canPlace
            } // end while !placed
        } // end for each word in string
    } // end placeWords method
    
    public void generate() {
        Scanner scanner = new Scanner(System.in);
        
        int numRows;
        int numColumns;
        
        System.out.println("Choose a puzzle size:");
        System.out.println("1. Small (10x12)");
        System.out.println("2. Medium (12x18)");
        System.out.println("3. Large (18x25)");
        
        int option = scanner.nextInt();
        
        switch (option) {
        	case 1:
        		numRows = 10;
        		numColumns = 12;
        		break;
        	case 2:
        		numRows = 12;
        		numColumns = 18;
        		break;
        	case 3:
        		numRows = 18;
        		numColumns = 25;
        		break;
        	default:
        		System.out.println("Invalid option. Generating a medium puzzle.");
        		numRows = 12;
        		numColumns = 18;
        		break;
        } // end switch case
        
        grid = new char[numRows][numColumns];
        words.clear();
        
        // Prompt user for self made or auto generated puzzle
        System.out.print("Enter how many words you want to input: ");
        int numWords;
        while (true) {
            String input = scanner.nextLine(); // Consume the newline character
            try {
                numWords = Integer.parseInt(input);
                if (numWords > 0) {
                    break; // valid input, exit loop
                } else {
                    System.out.println("Number of words must be more than 0. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value");
            }
        }
        
        for (int i = 0; i < numWords; i++) {
            System.out.print("Enter word " + (i + 1) + ": ");
            String word = scanner.nextLine();
            if (word.trim().isEmpty()) {
                System.out.println("Empty word is not allowed. Please enter a valid word");
                i--; // Decrement i to repeat the current iteration
                continue; // Skip adding the empty word to the list
            }
            words.add(word.toUpperCase());
        }
        
        fillGrid();
        placeWords();
        
        scanner.close();
    }
    
    // Method to print out the completed puzzle
    public void printPuzzle() {
    	// for each row i and each column j
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
            	// print letter followed by space
                System.out.print(grid[i][j] + " ");
            } // end inner for
            System.out.println();
        } // end outer for
    } // end printPuzzle
    
    public void printSolution() {
    	// for each row i and column j
    	for (int i = 0; i < grid.length; i++) {
    	    for (int j = 0; j < grid[i].length; j++) {
    	        if (grid[i][j] != '-') {
    	            System.out.print('X');
    	        } else {
    	            System.out.print('-');
    	        } // end else
    	        System.out.print(" ");
    	        } // end inner for
    	    System.out.println();
    	    } // end outer for
    } // end printSolution
}


