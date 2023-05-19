package assignment1WordSearch;

import java.util.*;

public class WordSearch {

	private char[][] grid;
    private List<String> words;

    // Constructor
    public WordSearch(int rows, int cols) {
        grid = new char[rows][cols];
        words = new ArrayList<>();
    }

    // method to generate the puzzle
    public void generatePuzzle() {
    	
    }
    
    // Method to fill the grid with random letters
    // Fill with random letters after the words are placed
    public void fillGrid() {
        // Code to fill grid with random letters
   
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // Generate a random uppercase letter
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

    
    
    // get words from the user
  
	
    
//    	// Prompt the user to enter words
//    	System.out.println("Enter words to add to the word search, one per line:");
//    	Scanner scanner = new Scanner(System.in);
//    	String line = "";
//    	List<String> words = new ArrayList<>();
//    		while (!(line = scanner.nextLine().trim()).isEmpty()) {
//    			words.add(line.toUpperCase());
//    		}
//    } // end getWords
//
//    // Fill the grid with the words
//    for (String word : words) {
//        // Generate a random orientation (horizontal, vertical, or diagonal)
//        int orientation = (int)(Math.random() * 3);
//
//        // Generate a random starting position
//        int row = (int)(Math.random() * (grid.length - word.length()));
//        int col = (int)(Math.random() * (grid[0].length - word.length()));
//
//        // Fill the word in the grid
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (orientation == 0) { // horizontal
//                grid[row][col + i] = c;
//            } else if (orientation == 1) { // vertical
//                grid[row + i][col] = c;
//            } else { // diagonal
//                grid[row + i][col + i] = c;
//            }
//        }
//    }

    
    



    // Method to print out the completed puzzle
    public void printPuzzle() {
        // Code to print out the completed puzzle
    }
}
