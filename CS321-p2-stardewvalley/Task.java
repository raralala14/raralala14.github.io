/**
 * 
 * @author rachellawrence
 *
 */
public class Task implements TaskInterface, Comparable<Task> {

	private int priorityLevel;
	private int waitingTime;
	private int hourCreated;
	private String description;
	private TaskInterface.TaskType theTaskType;

	public Task(TaskInterface.TaskType theTaskType, int priorityLevel, int hourCreated2, String taskDescription) {
		setPriority(priorityLevel);
		setHourCreated(hourCreated2);
		setTaskDescription(taskDescription);
		this.theTaskType = theTaskType;
	}
	public String toString() {
		return theTaskType + " " + description + " " + "at Hour " + hourCreated + ":00";
		
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
	 * return The tasks task type
	 */
	@Override
	public TaskInterface.TaskType getTaskType() {

		return theTaskType;

	}

	/**
	 * Increment the waiting time one the task
	 */
	@Override
	public void incrementWaitingTime() {

		waitingTime++;

	}

	/**
	 * Set waiting time to zero
	 */
	@Override
	public void resetWaitingTime() {

		waitingTime = 0;

	}

	/**
	 * Returns the current waiting time on the task
	 */
	@Override
	public int getWaitingTime() {

		return waitingTime;

	}

	@Override
	/**
	 * compares the priorities of this task and the other task (Object o) if tied,
	 * compare hourCreated (who has smallest #)
	 * 
	 * @param task The task to compare this task to
	 */
	public int compareTo(Task task) {

//		System.out.println("Task is " + task);
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

	/**
	 * Set the hour for the task
	 * 
	 * @param hour
	 */
	public void setHourCreated(int hour) {
		hourCreated = hour;

	}

	/**
	 * 
	 * @return hourCreated The hour created
	 */
	public int getHourCreated() {
		return hourCreated;

	}

	/**
	 * 
	 * @return description The description of the task
	 */
	public String getTaskDescription() {

		return description;
	}

	/**
	 * Set the description for the current task
	 * 
	 * @param taskDescription
	 */
	public void setTaskDescription(String taskDescription) {

		description = taskDescription;

	}

}
