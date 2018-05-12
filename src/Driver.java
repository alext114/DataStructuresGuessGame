
import java.util.*;
public class Driver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		ArrayBagWithCQS<Integer> arrayGame = new ArrayBagWithCQS<Integer>(4, 10, 5);// initialize the game bag
		LinkedListBagWithCQS<Integer> linkedGame= new LinkedListBagWithCQS<Integer>(4, 10, 5);//initialize game bag for linked list
	
		
 
		System.out.println("Welcome to the Guesing Game! \nPlease choose your method of playing the game (1 for Array | 2 for Linked List)");
		if (scan.nextInt()==1){
			System.out.println("This is the array version of the Guessing Game");
			AbstractGuessingGame<Integer> game = arrayGame;
			game.setGuessBag(arrayGame);// set the users guess
			ArrayBagWithCQS<Integer> answerBag = new ArrayBagWithCQS<Integer>(4, 10, 5);// make a new bag to hold the answer
			game.setAnswerBag(answerBag);
			
			game.createGame();
			
			
			System.out.println("Enter your guesses for the " + game.getNumOfValues() + " integers in the range of 1 to " + game.getMaxValue()+" that have been selected:");
			scan.nextLine();
			String[] line= scan.nextLine().split(" ");
						
			game.recordGuess(convertToGuess(line));
			
			while (game.reportNumOfGuessesLeft() > 1){

				if (game.reportNumCorrectInGuess()==game.getNumOfValues()){
					System.out.println("You are correct! Play again? (yes or no)");
					if(scan.nextLine().toLowerCase()=="yes"){
						game.setNumOfGuessesAllowed(arrayGame.getNumOfGuessesAllowed());//resets num of guesses back to original state
						game.createGame();
					}
					else{
						game.setNumOfGuessesAllowed(-1);
						System.out.println("Good-bye!");//ends game
					}
				}
				else{
					game.setNumOfGuessesAllowed(game.getNumOfGuessesAllowed()-1);
					System.out.println(game.reportNumCorrectInGuess()+ " of your guesses are correct. " + game.getNumOfGuessesAllowed()+ " Guesses remaining.");
					System.out.println("Enter your guesses for the " + game.getNumOfValues() + " integers in the range of 1 to " + game.getMaxValue()+" that have been selected: ");
					game.recordGuess(convertToGuess(scan.nextLine().split(" ")));
						
				}


				}

				gameOver();
				
				
				
			}
			
			
			
			
			

		
		
		else{
			System.out.println("This is the linked list version of the Guessing Game");
			AbstractGuessingGame<Integer> game =linkedGame;
			game.setGuessBag(linkedGame);// set the users guess
			LinkedListBagWithCQS<Integer> answerBag = new LinkedListBagWithCQS<Integer>(4, 10, 5);// make a new bag to hold the answer
			game.setAnswerBag(answerBag);
			
			game.createGame();
			
			
			System.out.println("Enter your guesses for the " + game.getNumOfValues() + " integers in the range of 1 to " + game.getMaxValue()+" that have been selected:");
			scan.nextLine();
			String[] line= scan.nextLine().split(" ");
						
			game.recordGuess(convertToGuess(line));
			
			while (game.reportNumOfGuessesLeft() > 1){

				if (game.reportNumCorrectInGuess()==game.getNumOfValues()){
					System.out.println("You are correct! Play again? (yes or no)");
					if(scan.nextLine().toLowerCase()=="yes"){
						game.setNumOfGuessesAllowed(linkedGame.getNumOfGuessesAllowed());//resets num of guesses back to original state
						game.createGame();
					}
					else{
						game.setNumOfGuessesAllowed(-1);
						System.out.println("Good-bye!");//ends game
					}
				}
				else{
					game.setNumOfGuessesAllowed(game.getNumOfGuessesAllowed()-1);
					System.out.println(game.reportNumCorrectInGuess()+ " of your guesses are correct. " + game.getNumOfGuessesAllowed()+ " Guesses remaining.");
					System.out.println("Enter your guesses for the " + game.getNumOfValues() + " integers in the range of 1 to " + game.getMaxValue()+" that have been selected: ");
					game.recordGuess(convertToGuess(scan.nextLine().split(" ")));
						
				}


				}
			
		
			gameOver();

			
				
				
				
			
		}
		scan.close();

	}
	public static Integer[] convertToGuess(String[] stringGuess){
	
		Integer[] guess= new Integer[stringGuess.length];
		for(int i = 0;i < guess.length;i++)//break the scan.nextline into an array and convert it into integers
		{
		   // Note that this is assuming valid input
		   guess[i] = Integer.parseInt(stringGuess[i]);
		}
		
	
		return guess;
	}
	
	public static void gameOver(){

		System.out.println("GAME OVER");
		
	}

}
