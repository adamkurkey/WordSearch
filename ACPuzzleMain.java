



package puzzleAssignmentbyAdam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACPuzzleMain {
    public static void main(String[] args) {

        System.out.printf("Hello and welcome!\n");
        System.out.println("Enter words to be placed in the word search. Enter at least 5 words.");

        Scanner scanner = new Scanner(System.in);
        String line = "";
        List<String> userWords = new ArrayList<>();

        // Collect user input
        for (int i = 1; i <= 5; i++) {
            System.out.print("Word " + i + ": ");
            line = scanner.nextLine().trim();
            userWords.add(line.toUpperCase());
        } // end for 1-5

        // Assign user words to the words list
        List<String> words = new ArrayList<>(userWords);

        // Create a 12x18 grid for the solution
        char[][] solutionGrid = new char[12][18];

        // Fill the solution grid with empty spaces
        for (int i = 0; i < solutionGrid.length; i++) {
            for (int j = 0; j < solutionGrid[i].length; j++) {
                solutionGrid[i][j] = '-';
            } // end inner for
        } // end outer for

        // Place words in the solution grid with possible overlap
        for (String word : words) {
            boolean placed = false;

            while (!placed) {
                // Generate a random starting position
                int row = (int) (Math.random() * (solutionGrid.length - word.length() + 1));
                int col = (int) (Math.random() * (solutionGrid[0].length - word.length() + 1));

                // Generate a random orientation
                int orientation = (int) (Math.random() * 3);

                // Check if the word can be placed at the starting position
                boolean canPlace = true;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (orientation == 0) { // horizontal
                        if (solutionGrid[row][col + i] != '-' && solutionGrid[row][col + i] != c) {
                            canPlace = false;
                            break;
                        }
                    } else if (orientation == 1) { // vertical
                        if (solutionGrid[row + i][col] != '-' && solutionGrid[row + i][col] != c) {
                            canPlace = false;
                            break;
                        }
                    } else { // diagonal
                        if (solutionGrid[row + i][col + i] != '-' && solutionGrid[row + i][col + i] != c) {
                            canPlace = false;
                            break;
                        }
                    }
                }

                // Place the word in the solution grid if it can be placed
                if (canPlace) {
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        if (orientation == 0) { // horizontal
                            solutionGrid[row][col + i] = c;
                        } else if (orientation == 1) { // vertical
                            solutionGrid[row + i][col] = c;
                        } else { // diagonal
                            solutionGrid[row + i][col + i] = c;
                        }
                    }
                    placed = true;
                }
            }
        }

        // Create another grid for random letters
        char[][] randomGrid = new char[12][18];

        // Copy the solution grid to the random grid
        for (int i = 0; i < solutionGrid.length; i++) {
            System.arraycopy(solutionGrid[i], 0, randomGrid[i], 0, solutionGrid[i].length);
        }

        // Fill the remaining empty cells with random letters
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                if (randomGrid[i][j] == '-') { // Check if the cell is empty
                    randomGrid[i][j] = (char) ('A' + (int) (Math.random() * 26));
                }
            }
        }

        // Print the random grid
        System.out.println("Puzzle:");
        printGridWithSolution(randomGrid, solutionGrid);

        // Print the solution grid
        System.out.println("Solution:");
        printGrid(solutionGrid);

        scanner.close();
    } // end main method

    // Method to print the grid
    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Method to print the grid with solution
    public static void printGridWithSolution(char[][] randomGrid, char[][] solutionGrid) {
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                // Modify the condition here
                if (randomGrid[i][j] == '-') { // Check if the cell is empty
                    System.out.print(solutionGrid[i][j] + " ");
                } else {
                    System.out.print(randomGrid[i][j] + " ");
                }
            }
            System.out.println();
        }
    } // end main method
} // end ACPuzzleMain

	
	
	

