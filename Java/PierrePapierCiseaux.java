/*
 * Coded with MAHE BEAUD AND LOïC ROUZAUD
 */

import java.util.Random;
import java.util.Scanner;

public class PierrePapierCiseaux {

    private static int playerScore = 0; // initial score
    private static int computerScore = 0; // initial score

    private static void playRound(Scanner input, Random random, int round) {
        System.out.println("\n----- Round " + round + " -----");
        System.out.println("Score -> Player: " + playerScore + " - Computer: " + computerScore); // Initial print
        
        String playerMove = getPlayerMove(input); // Get player move
        String computerMove = getComputerMove(random); // Get computer move

        System.out.println("Computer chose " + computerMove);
        
        int result = determineWinner(playerMove, computerMove); // Determine winner
        displayRoundResult(result); // Display round result
    }

    private static String getPlayerMove(Scanner input) {
        while (true) { // Game loop
            System.out.print("Your move (r for Rock, p for Paper, s for Scissors): ");
            String move = input.next().toLowerCase(); // Convert to lowercase
            if (move.equals("r") || move.equals("p") || move.equals("s")) {
                return move;
            }
            System.out.println("Invalid input. Please try again."); // Error message in case of invalid input (Error handling)
        }
    }

    private static String getComputerMove(Random random) { // Random choice between Rock, Paper, Scissors
        int choice = random.nextInt(3);
        switch (choice) {
            case 0: return "r";
            case 1: return "p";
            default: return "s";
        }
    }

    private static int determineWinner(String playerMove, String computerMove) { // Determine the winner depending on the return of the function
        if (playerMove.equals(computerMove)) {
            return 0; // Tie
        } 
        if ((playerMove.equals("r") && computerMove.equals("s")) ||
            (playerMove.equals("s") && computerMove.equals("p")) ||
            (playerMove.equals("p") && computerMove.equals("r"))) {
            return 1; // Player wins
        }
        return -1; // Computer wins
    }

    private static void displayRoundResult(int result) {
        if (result == 0) {
            System.out.println("It is a tie");
        } else if (result == 1) {
            playerScore++;
            System.out.println("Yay! You won this round :)");
        } else {
            computerScore++;
            System.out.println("Womp womp! You lost this round :(");
        }
    }

    private static void equalityScores() { // Equality scores : in case of equality between player and computer in the last round
        Scanner input = new Scanner(System.in);
        Random random = new Random();
    
        System.out.println("Tie-breaker round: Play until one of you wins! Let's start!"); // Case of equality in the last round 
        String playerMove = getPlayerMove(input);
        String computerMove = getComputerMove(random);

        int result = determineWinner(playerMove, computerMove);
        displayRoundResult(result); 
        input.close();
    }

    private static void announceWinner() {
        if (playerScore == computerScore) {
            System.out.println("\nIt's a tie! Thanks for playing!");
        } else if (playerScore > computerScore) {
            System.out.println("\nCongratulations! You won the game :)");  
        } else {
            System.out.println("\nThe computer wins! Better luck next time!");
        }
    }

    private static int getNumberOfRounds(Scanner input) {
        while (true) {
            System.out.print("Please enter the number of rounds (positive integer): ");
            if (input.hasNextInt()) {
                int numRounds = input.nextInt();
                input.nextLine(); // Consume newline character
                if (numRounds > 0) {
                    return numRounds;
                } else {
                    System.out.println("Number of rounds must be positive. Please try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer.");
                input.nextLine(); // Consume invalid input
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("---------- ROCK, PAPER, SCISSORS ----------");
        int numRounds = getNumberOfRounds(input); // Get valid number of rounds

        System.out.println("NUMERO DE ROUND : " + numRounds);

        for (int round = 1; round <= numRounds || playerScore == computerScore; round++) {
            playRound(input, random, round);
        }

        announceWinner();
        if (playerScore == computerScore) {
            equalityScores();
        }
        input.close();
    }
}

/**
 * The bug was due to the code placement. The java compilator reads the code from top to bottom.
 * So If the code is badly placed, the program will not work as expected.
 */