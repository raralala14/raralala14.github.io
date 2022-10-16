
/**
 * @author rachellawrence
 *
 */

// TODO PASTE IN JAVADOCS
// if priorities equal then go to hour created

public class Task implements TaskInterface, Comparable<Task> {
	
	private int priorityLevel;
	private int waitingTime;
	private int hourCreated;
	private String description;
	private TaskInterface.TaskType theTaskType;
	
//	public Task() {
//		
//	}

	public Task(TaskInterface.TaskType theTaskType, int priorityLevel, int hourCreated2, String taskDescription) {
		setPriority(priorityLevel);
		setHourCreated(hourCreated2);
		setTaskDescription(taskDescription);
		this.theTaskType = theTaskType;
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
		
		return getTaskType();
		
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
	public int compareTo(Task task) {

		// compares the priorities of this task
		// and the other task (Object o)
		// if tied, compare hourCreated (who has smallest #)
		
		if (this.getPriority() < task.getPriority()) {
			return -1;
		} else if (this.getPriority() > task.getPriority()) {
			return 1;
		} else if (this.hourCreated < task.hourCreated) {
			return 1;
		} else if (this.hourCreated > task.hourCreated) {
			return -1;
		} else {
			return 0;
		}

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
