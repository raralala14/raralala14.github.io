
/**
 * @author rachellawrence
 *
 */

	// TODO PASTE IN JAVADOCS

public class Task implements TaskInterface, Comparable<Object> {

	int priorityLevel;
	int waitingTime;
	int hourCreated;
	String description;

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
		// TODO Auto-generated method stub
		return 0;
	}

	public String getTaskDescription() {
		
		return description;
	}
	
	public void setTaskDescription(String taskDescription) {
		
		description = taskDescription;
		
	}

}
