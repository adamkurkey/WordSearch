package assignment1WordSearch;

import java.util.Scanner;

public class ManagerWordSearch {

	 private WordSearch wordSearch;
	 private Scanner scanner;

	    // Constructor
	    public ManagerWordSearch() {
	        wordSearch = new WordSearch(12, 18);
	        scanner = new Scanner(System.in);
	    }

	    
	

	    public void run() {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("Choose an option:");
	            System.out.println("G - Generate a new puzzle");
	            System.out.println("P - Print the puzzle");
	            System.out.println("S - Show the solution");
	            String option = scanner.nextLine().trim().toUpperCase();

	            if (option.equals("G")) {
	                /* get words from user 
	                 * fill grid with random chars
	                 * place the words
	                 * print the puzzle
	                 * wordSearch.generatePuzzle();
	                wordSearch.placeWords();
	                wordSearch.printPuzzle();
	                */
	            } else if (option.equals("P")) {
	            	// if they haven't made a puzzle, have them make a puzzle
	                if (wordSearch.getWords().isEmpty()) {
	                    System.out.println("No puzzle available. Generate a puzzle first.");
	                    continue;
	                } // have a pre-made puzzle 
	                wordSearch.printPuzzle();
	            } else if (option.equals("S")) {
	                // Code to print the solution
	            } else {
	                System.out.println("Invalid option. Retry.");
	                continue;
	            }

	            System.out.println("Do you want to continue? (Y/N)");
	            String continueOption = scanner.nextLine().trim().toUpperCase();
	            if (!continueOption.equals("Y")) {
	                break;
	            }
	        }
	    }
	
	    
	    
	    /*
	    public void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("G - Generate a new puzzle");
	        System.out.println("P - Print the puzzle");
	        System.out.println("S - Show the solution");
	            
            String choice = scanner.next();
    
            switch (choice.toLowerCase()) {
                case "generate":
                case "g":
                case "new":
                case "n":
                     * get words from user 
	                 * fill grid with random chars
	                 * place the words
	                 * print the puzzle
                    break;
                case "print":
                case "p":
                    * check if user has created puzzle
                    * if not, say using generic puzzle
                    * print generic puzzle
                    * if yes, print user puzzle
                    break;
                case "solve":
                case "s":
                	* print the puzzle with the words as words
                	* and the random chars replaced with x's
                	break;
                default:
                	 System.out.println("Invalid choice, please try again.");
	    	}
	    */

public void generate() {
    Scanner scanner = new Scanner(System.in);
    
    System.out.print("Enter your choice (1: User input, 2: Pre-defined words): ");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character
    
    switch (choice) {
        case 1:
            generateWithUserInput(scanner);
            break;
        case 2:
            generateWithPredefinedWords();
            break;
        default:
            System.out.println("Invalid choice. Generating with user input.");
            generateWithUserInput(scanner);
            break;
    }
    
    scanner.close();
}

private void generateWithUserInput(Scanner scanner) {
    System.out.print("Enter the number of words: ");
    int numWords = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character
    
    words.clear();
    
    for (int i = 0; i < numWords; i++) {
        System.out.print("Enter word " + (i + 1) + ": ");
        String word = scanner.nextLine();
        words.add(word.toUpperCase());
    }
    
    initializeGrid();
    placeWords();
}

private void generateWithPredefinedWords() {
    words.clear();
    words.add("PROGRAM");
    words.add("ARRAY");
    words.add("DIMENSION");
    words.add("THUNDER");
    words.add("SUNNY");
    
    initializeGrid();
    placeWords();
}
}


