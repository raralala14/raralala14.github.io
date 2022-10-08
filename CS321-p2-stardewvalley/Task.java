
/**
 * @author rachellawrence
 *
 */

	// TODO PASTE IN JAVADOCS
	// if priorities equal then go to hour created

public class Task implements TaskInterface, Comparable<Object> {

	int priorityLevel;
	int waitingTime;
	int hourCreated;
	String description;
	Integer number;
	
	public Task() {
		
		
	}

	/**
	 * returns the priority level
	 */
	
	public int getPriority() {

		return priorityLevel;

	}

	/**
	 * @param priority sets the priority level
	 */
	@Override
	public void setPriority(int priority) {

		priorityLevel = priority;

	}

	/**
	 * 
	 */
	@Override
	public TaskInterface.TaskType getTaskType() {

		return null;

	}

	/**
	 * 
	 */
	@Override
	public void incrementWaitingTime() {

		waitingTime++;

	}

	@Override
	public void resetWaitingTime() {

		waitingTime = 0;

	}
	@Override
	public int getWaitingTime() {

		return waitingTime;

	}

	@Override
	public int compareTo(Object o) {
		
		// compares the priorities of this task
		// and the other task (Object o)
		// if tied, compare hourCreated (who has smallest #)
		
		System.out.println(o.toString());
		int leftChild = 1;
		int rightChild = 3;
		
		if (this.priorityLevel < rightChild)
			return -1;
		
		if (this.priorityLevel > leftChild)
			return 1;
		
		if (rightChild == leftChild)
			return 0;
		
		return 0;
		
		
	}
	public void setHourCreated(int hour) {
		hourCreated = hour;
		
	}
	public int getHourCreated() {
		return hourCreated;
		
	}
	public String getTaskDescription() {
		
		return description;
	}
	
	public void setTaskDescription(String taskDescription) {
		
		description = taskDescription;
		
	}

}
