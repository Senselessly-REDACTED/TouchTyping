//To Be Implemented
public class TimeTrack
{
	private long tStart;
	private long tEnd;
	
	/**
	 * initializes instance variables
	 */
	public TimeTrack()
	{
		tStart = 0;
		tEnd = 0;
	}
	
	/**
	 * sets tStart to current system time
	 */
	public void trackTimeStart()
	{
		tStart = System.nanoTime();
	}
	
	/**
	 * sets tEnd to current system time
	 * @return tEnd - tStart converted from nanoseconds to seconds
	 */
	public double trackTimeEnd()
	{
		tEnd = System.nanoTime();
		
		tEnd -= tStart;
			
		return tEnd / 1000000000.0;
	}
	
	
}
