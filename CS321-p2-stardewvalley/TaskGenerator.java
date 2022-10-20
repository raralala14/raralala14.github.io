import java.util.Random;

public class TaskGenerator implements TaskGeneratorInterface {

	int currentEnergyStorage = 200;//declare, not initial to 0
	double probability;
	long randomSeed;//not needed
	private Random rand;

	public TaskGenerator(double taskGenerationProbability) {
		probability = taskGenerationProbability;
		resetCurrentEnergyStorage();
		rand = new Random();

	}

	public TaskGenerator(double taskGenerationProbability, long seed) {
		// use probability and seed to determine if need to call getNewTask()
		probability = taskGenerationProbability;
		resetCurrentEnergyStorage();
		randomSeed = seed;
		rand = new Random(seed);
		
		
	}

	@Override
	/**
	 * Returns the new task object
	 */
	public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		
		return new Task(hourCreated, taskType, taskDescription);

		

	}

	@Override
	/**
	 * Decrements the energy storage 
	 */
	public void decrementEnergyStorage(TaskInterface.TaskType taskType) {

		currentEnergyStorage = currentEnergyStorage - taskType.getEnergyPerHour();
	}

	@Override
	/**
	 * Resets the current energy storage 
	 */
	public void resetCurrentEnergyStorage() {
		currentEnergyStorage = 200;

	}

	@Override
	public int getCurrentEnergyStorage() {

		return currentEnergyStorage;
	}

	@Override
	public void setCurrentEnergyStorage(int newEnergyNum) {
		currentEnergyStorage = newEnergyNum;

	}

	@Override
	public boolean generateTask() {
		
		return rand.nextDouble() < probability;
	}

	@Override
	/**
     * Determines the likelihood of passing out or dying
     * based on the task and death probability.  Where
     * 0 is not dying or passing out, 1 is passing out,
     * and 2 is dying in the Mines.
     *
     * @param task - the Task
     * @returns  0, 1 or 2 depending on the unluckiness
     */
	public int getUnlucky(Task task, double unluckyProbability) {
		
		Task.TaskType taskType = task.getTaskType();
		if (unluckyProbability <= taskType.getPassingOutProbability()) {
			if ((unluckyProbability <= taskType.getDyingProbabilityProbability())
					&& (taskType == Task.TaskType.MINING)) {
				currentEnergyStorage = (int) (currentEnergyStorage / 4);
				task.setPriority(0);
				return 2;
				
			} else {
				currentEnergyStorage = (int) currentEnergyStorage / 2;
				return 1;
			}
			
		} else {
			return 0;

		}

	}

	/**
	 * Create a String containing the Task's information.
	 *
	 * @param task     - the Task
	 * @param taskType - the Task's type
	 */
	@Override
	public String toString(Task task, Task.TaskType taskType) {
		
		
		if (taskType == Task.TaskType.MINING) {
			return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage
					+ " energy points (Priority:" + task.getPriority() + ")";
		}
		if (taskType == Task.TaskType.FISHING) {
			return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage
					+ " energy points (Priority:" + task.getPriority() + ")";
		}
		if (taskType == Task.TaskType.FARM_MAINTENANCE) {
			return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage
					+ " energy points (Priority:" + task.getPriority() + ")";
		}
		if (taskType == Task.TaskType.FORAGING) {
			return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage
					+ " energy points (Priority:" + task.getPriority() + ")";
		}
		if (taskType == Task.TaskType.FEEDING) {
			return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage
					+ " energy points (Priority:" + task.getPriority() + ")";
		}
		if (taskType == Task.TaskType.SOCIALIZING) {
			return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage
					+ " energy points (Priority:" + task.getPriority() + ")";
		} else {
			return "nothing to see here...";
		}
	}

}