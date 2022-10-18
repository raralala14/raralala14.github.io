import java.util.Random;

public class TaskGenerator implements TaskGeneratorInterface {

	int currentEnergyStorage = 200;//declare, not initial to 0
	double probability;
	long randomSeed;//not needed
	double probabilityOne;//not needed
	private Random rand;
	boolean  seeded = false;//not needed

	public TaskGenerator(double taskGenerationProbability) {
		probability = taskGenerationProbability;
		//use resetCurrentEnergyStorage()
		rand = new Random();

	}

	public TaskGenerator(double taskGenerationProbability, long seed) {
		// use probability and seed to determine if need to call getNewTask()
		probability = taskGenerationProbability;
		//use resetCurrentEnergyStorage()
		randomSeed = seed;
		rand = new Random(seed);
		
		
	}

	@Override
	public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		 
//		if (seeded == true) {
//             randomSeed = randomSeed << 2; //allows for different lucks and unfortunate probabilities
//             rand = new Random(randomSeed);
//         } else {
//             rand = new Random();
//         }
//        double createATask = rand.nextDouble();
//        
//        if (createATask > probability) {
//        	Task newTask = new Task(taskType, 0, hourCreated, taskDescription);
//        	return newTask;
//        }
		return new Task(hourCreated, taskType, taskDescription);

		

	}

	@Override
	public void decrementEnergyStorage(TaskInterface.TaskType taskType) {

		currentEnergyStorage = currentEnergyStorage - taskType.getEnergyPerHour();
	}

	@Override
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
				currentEnergyStorage = (int) (currentEnergyStorage * (.25));
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
