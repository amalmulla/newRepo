/**
 * Represents the shared data between threads used for the subset sum problem.
 * It holds the input array, the target sum, and synchronization flags for the solution.
 */
public class SharedData 
{
	private int [] array;
	private boolean [] winArray;
	private boolean flag;
	private final int b;
	private String winnerThread;
	
	/**
	 * Constructor to initialize the shared data object.
	 * @param array The integer array to search.
	 * @param b The target sum.
	 */
	public SharedData(int[] array, int b) {
		
		this.array = array;
		this.b = b;
	}
	
	/**
	 * Gets the name of the thread that found the solution first.
	 * @return The name of the winning thread.
	 */
	 public synchronized String getWinnerThread() {
        return winnerThread;
	 }

	 /**
	  * Sets the name of the winning thread.
	  * Only the first thread to call this method will set the name.
	  * @param name The name of the thread that found the solution.
	  */
    public synchronized void setWinnerThread(String name) {
        // Set winner only once (first finder)
        if (this.winnerThread == null)
            this.winnerThread = name;
    }

    /**
     * Gets the boolean array representing the solution subset.
     * @return A boolean array where true indices correspond to the elements used in the sum.
     */
	public boolean[] getWinArray() 
	{
		return winArray;
	}

	/**
	 * Sets the boolean array representing the solution subset.
	 * @param winArray The boolean array to set.
	 */
	public void setWinArray(boolean [] winArray) 
	{
		this.winArray = winArray;
	}

	/**
	 * Gets the input integer array.
	 * @return The integer array.
	 */
	public int[] getArray() 
	{
		return array;
	}

	/**
	 * Gets the target sum 'b'.
	 * @return The target integer value.
	 */
	public int getB() 
	{
		return b;
	}

	/**
	 * Checks if a solution has been found by any thread.
	 * @return True if a solution is found, false otherwise.
	 */
	public boolean getFlag() 
	{
		return flag;
	}

	/**
	 * Sets the flag indicating a solution has been found.
	 * @param flag The boolean value to set.
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}