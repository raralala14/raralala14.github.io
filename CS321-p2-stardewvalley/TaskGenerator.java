import java.util.Random;

public class TaskGenerator implements TaskGeneratorInterface {

	int currentEnergyStorage = 0;
	double probability;
	long randomSeed;
	double probabilityOne;
	private Random rand;
	boolean  seeded = false;

	public TaskGenerator(double taskGenerationProbability) {
		probability = taskGenerationProbability;

	}

	public TaskGenerator(double taskGenerationProbability, long seed) {
		// use probability and seed to determine if need to call getNewTask()
		probability = taskGenerationProbability;
		randomSeed = seed;
		
		
	}

	@Override
	public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		 
		System.out.println("Called getNewTask()...");
		if (seeded == true) {
             randomSeed = randomSeed << 2; //allows for different lucks and unfortunate probabilities
             rand = new Random(randomSeed);
         } else {
             rand = new Random();
         }
        double createATask = rand.nextDouble();
        
        System.out.println("createATask double is:" + createATask);
        System.out.println("probability = " + probability);
        if (createATask > probability) {
        	System.out.println("Yep! Creating a new task "+ taskType);
        	Task newTask = new Task(taskType, 0, hourCreated, taskDescription);
    		System.out.println("The new task has been created as Task " + newTask);
        	return newTask;
        }
		return null;

		

	}

	@Override
	public void decrementEnergyStorage(TaskInterface.TaskType taskType) {

		currentEnergyStorage = currentEnergyStorage - taskType.getEnergyPerHour();
	}

	@Override
	public void resetCurrentEnergyStorage() {
		currentEnergyStorage = 0;

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
		rand = new Random();
		probabilityOne = rand.nextDouble();
		if (probabilityOne < probability) {
System.out.println("We are generating a task!");
			return true;
		} else {
System.out.println("We are NOT generating a task!");			
			return false;
		}

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
		//System.out.println("running getUnlucky");
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
		
		System.out.println("TaskGenerator.toString:task = " + task);
		
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
