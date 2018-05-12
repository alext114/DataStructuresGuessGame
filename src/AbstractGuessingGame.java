import java.util.*;

public abstract class AbstractGuessingGame<T> implements GuessingGame<T>, BagWithCQS<T>{
	private int numOfValues, maxValue, numOfGuessesAllowed;
	private BagWithCQS<T> guessBag, answerBag;

	public AbstractGuessingGame(int newNumOfValues, int newMaxValue, int newNumOfGuessesAllowed){
		numOfValues=newNumOfValues;
		maxValue=newMaxValue;
		numOfGuessesAllowed=newNumOfGuessesAllowed; 
//constructor initializes variables
	
		
		
	}
	public AbstractGuessingGame(){
		numOfValues=4;
		maxValue=10;
		numOfGuessesAllowed=10;
		
	}
	public boolean verifyGuess(T[] guess) {
		if (guess.length==numOfValues){ //checks to see if the guess is in its correct format
			T[] vGuess= guess;
			
			for (int i=0; i < numOfValues; i++){
				if ((int)vGuess[i] >= 1 && (int)vGuess[i] <=maxValue){}
				else{
					return false;
				}
			}
			return true;
			
		}
		return false;
		
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public void createGame() {
		// TODO Auto-generated method stub
		// creates the game by wiping the bag and starting new and then adds random ints 
		Random rand= new Random();
		
		answerBag.clear();
		
		for (int i=0; i < numOfValues; i++ ){
		Integer randomNum=rand.nextInt((maxValue - 1) + 1) + 1;
		answerBag.add((T) randomNum);
		
		}
		
		
		
 	}

	public void recordGuess(T[] guess) {
		if(verifyGuess(guess)){
			guessBag.clear(); // records the guess but verifies it first
			for(int i=0; i < guess.length; i++){
			
			guessBag.add(guess[i]);
			}
		}
		
		
	}
	@Override
	public int reportNumCorrectInGuess() {
		// TODO Auto-generated method stub
		int numCorrect=0;
	// checks how many are correct in the guess
		T[] gBag= guessBag.toArray();
		T[] aBag=reportCorrectAns();

		if(getNumOfGuessesAllowed()>=1){
			
		
			for(int i=0; i < numOfValues; i++){
				for(int j=0; j<numOfValues;j++){// 2 loops to check the values of the guess and answer
					if (gBag[i].equals(aBag[j])){
						numCorrect++;
					}
				}
			}
			return numCorrect;
		}
		else{
			return 0;
		}
		
		
		
	}
	@Override
	public int reportNumOfGuessesLeft() {
		return numOfGuessesAllowed;// returns guesses left
		
	}
	public boolean reportIsCorrect() {
	//reports if the guess is correct
		if (reportNumCorrectInGuess()==getNumOfValues()){
			return true;
			
			
		}
		else{
			
			return false;
		}
		
	}

	
	
	@Override
	public T[] reportCorrectAns() {
		//returns the array of the answer
		return answerBag.toArray();
		
	}
	
	
	
	// Getters and Setters
	public BagWithCQS<T> getGuessBag() {
		return guessBag;
	}
	public void setGuessBag(BagWithCQS<T> guessBag) {
		this.guessBag = guessBag;
	}
	public BagWithCQS<T> getAnswerBag() {
		return answerBag;
	}
	public void setAnswerBag(BagWithCQS<T> answerBag) {
		this.answerBag = answerBag;
	}

	
	public int getNumOfValues() {
		return numOfValues;
	}
	public void setNumOfValues(int numOfValues) {
		this.numOfValues = numOfValues;
	}
	public int getMaxValue() {
		return maxValue;
	}
	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}
	public int getNumOfGuessesAllowed() {
		return numOfGuessesAllowed;
	}
	public void setNumOfGuessesAllowed(int numOfGuessesAllowed) {
		this.numOfGuessesAllowed = numOfGuessesAllowed;
	}
	
	
	
	
}
