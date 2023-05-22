



package puzzleAssignmentbyAdam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ACPuzzleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] randomGrid = null;
        char[][] solutionGrid = null;
        //List<String> userWords = getUserWords(scanner);
        //char[][] solutionGrid = generateSolutionGrid(userWords);
        //char[][] randomGrid = generateRandomGrid(solutionGrid);

        //printPuzzle(randomGrid);
        //printSolution(solutionGrid);
        instructions();

        boolean running = true;
        while (running) {
            printMenu();
            char choice = scanner.nextLine().toUpperCase().charAt(0);
            switch (choice) {
            case 'G':
                System.out.println("\nGenerating puzzle...");
                List<String> userWords = getUserWords(scanner);
                solutionGrid = generateSolutionGrid(userWords);
                randomGrid = generateRandomGrid(solutionGrid);
                break;
            case 'P':
                if (randomGrid != null) {
                    System.out.println("\nPrinting puzzle...");
                    printPuzzle(randomGrid);
                } else {
                    System.out.println("\nPlease generate a puzzle first.");
                }
                break;
            case 'S':
                if (solutionGrid != null) {
                    System.out.println("\nPrinting solution...");
                    printSolution(solutionGrid);
                } else {
                    System.out.println("\nPlease generate a puzzle first.");
                }
                break;
            case 'Q':
                running = false;
                break;
            default:
                System.out.println("\nInvalid choice. Please try again.");
                break;
            }
        }
        scanner.close();
        System.out.println("\nThank you for playing!");
    }

    public static List<String> getUserWords(Scanner scanner) {
        System.out.println("Enter words to be placed in the word search. Enter at least 5 words.");

        List<String> userWords = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            System.out.print("Word " + i + ": ");
            String line = scanner.nextLine().trim();
            
            if (line.length() > 18) { // Adjust the maximum word length as needed
                System.out.println("Word is too long. Please enter a word with fewer than 18 characters.");
                i--; // Decrement i to repeat the loop for the same word index
                continue; // Skip to the next iteration of the loop
            }
            
            //Validate user input
            while (line.isEmpty() || !line.matches("[a-zA-Z]+")) {
            	System.out.println("Invalid input. Please enter a valid word.");
            	System.out.print("Word " + i + ": ");
            	line = scanner.nextLine().trim();
            }
            userWords.add(line.toUpperCase());
        }
        return userWords;
    }

    public static char[][] generateSolutionGrid(List<String> words) {
        char[][] solutionGrid = new char[12][18];
        for (int i = 0; i < solutionGrid.length; i++) {
            for (int j = 0; j < solutionGrid[i].length; j++) {
                solutionGrid[i][j] = '-';
            }
        }
        for (String word : words) {
            boolean placed = false;
            while (!placed) {
                int row = (int) (Math.random() * (solutionGrid.length - word.length() + 1));
                int col = (int) (Math.random() * (solutionGrid[0].length - word.length() + 1));
                int orientation = (int) (Math.random() * 3);
                boolean canPlace = true;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (orientation == 0) {
                        if (solutionGrid[row][col + i] != '-' && solutionGrid[row][col + i] != c) {
                            canPlace = false;
                            break;
                        }
                    } else if (orientation == 1) {
                        if (solutionGrid[row + i][col] != '-' && solutionGrid[row + i][col] != c) {
                            canPlace = false;
                            break;
                        }
                    } else {
                        if (solutionGrid[row + i][col + i] != '-' && solutionGrid[row + i][col + i] != c) {
                            canPlace = false;
                            break;
                        }
                    }
                }
                if (canPlace) {
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        if (orientation == 0) {
                            solutionGrid[row][col + i] = c;
                        } else if (orientation == 1) {
                            solutionGrid[row + i][col] = c;
                        } else {
                            solutionGrid[row + i][col + i] = c;
                        }
                    }
                    placed = true;
                }
            }
        }
        return solutionGrid;
    }

    public static char[][] generateRandomGrid(char[][] solutionGrid) {
        char[][] randomGrid = new char[12][18];
        for (int i = 0; i < solutionGrid.length; i++) {
            System.arraycopy(solutionGrid[i], 0, randomGrid[i], 0, solutionGrid[i].length);
        }
        for (int i = 0; i < randomGrid.length; i++) {
            for (int j = 0; j < randomGrid[i].length; j++) {
                if (randomGrid[i][j] == '-') {
                    randomGrid[i][j] = (char) ('A' + (int) (Math.random() * 26));
                }
            }
        }
        return randomGrid;
    }

    public static void printPuzzle(char[][] grid) {
        System.out.println("Puzzle:");
        printGridWithSolution(grid);
    }

    public static void printSolution(char[][] grid) {
        System.out.println("Solution:");
        printGrid(grid);
    }

    public static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    public static void printMenu() {
        System.out.println("\nMENU:");
        System.out.println("G - Generate a puzzle");
        System.out.println("P - Print the puzzle");
        System.out.println("S - See the solution");
        System.out.println("Q - Quit");
        System.out.print("Enter your choice: ");
    }
    
    public static void instructions() {
    	System.out.println("Hello and welcome to my word search generator");
    	System.out.println("You may choose from these options.");
    	System.out.println("Please Generate puzzle before trying to print");
    }

    // Menu: Generate, Print, Solve.
    public void runWordSearch() {
        while (true) {
            System.out.println("G - Generate a new puzzle");
            System.out.println("P - Print the puzzle");
            System.out.println("S - Show the solution");
        } // end while
    } // end runWordSearch
    
    
    public static void printGridWithSolution(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

	
	

