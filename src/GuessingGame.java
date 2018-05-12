
public interface GuessingGame<T> {
public boolean verifyGuess(T[] guess);
/**
 * Set up a game by creating and saving n random values between 1 and m
 * pre condition: none
 * post_condition:  guess.length==numValues
 * @return true
 */
public void createGame();
/**
 * Verify that a guess – given as an array of ints or an ArrayList<Integer> – has
the correct form (exactly n integers between 1 and the maximum value)
 */
public void recordGuess(T[] guess);
/**
 * record a the player's guess
 */
public int reportNumCorrectInGuess();
/**
 * reports the number of correct values in the players guess
 * 
 * pre-condition:
 * post-condition: getNumOfGuessesAllowed()>=1
 * 
 * @return numCorrect
 */
public int reportNumOfGuessesLeft();
/**
 * reports the number of guesses remaining
 */
public boolean reportIsCorrect();
/**
 * reports the whether or not the users guess is correct
 * 
 * pre-condition:
 * post-condition: reportNumCorrectInGuess()==getNumOfValues() 
 * 
 * @return true
 * 
 */
public T[] reportCorrectAns();
/**
 * reports the correct answer
 * 
 * @return array
 */



	
}
