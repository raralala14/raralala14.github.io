import java.util.Random;

public class TaskGenerator implements TaskGeneratorInterface {
	
	
	int currentEnergyStorage = 0;
	double probability;
	int randomSeed;
	double probabilityOne;
    private  Random rand;

	public TaskGenerator (double taskGenerationProbability) {
		probability = taskGenerationProbability;
		
	}
	
	
	public TaskGenerator (double taskGenerationProbability, long seed) {
		// use probability and seed to determine if need to call getNewTask()
	}
	
	
	@Override
	public Task getNewTask(int hourCreated, TaskInterface.TaskType taskType, String taskDescription) {
		Task task = new Task();
		task.setPriority(0);
		task.setHourCreated(hourCreated);
		task.setTaskDescription("this is a task description ");
		System.out.println("getting task description " + task.getTaskDescription());
		return task;
	}

	@Override
	public void decrementEnergyStorage(TaskInterface.TaskType taskType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetCurrentEnergyStorage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getCurrentEnergyStorage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCurrentEnergyStorage(int newEnergyNum) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean generateTask() {
		// do we generate a task or not???
		
		rand = new Random();
		probabilityOne = rand.nextDouble();
		if (probabilityOne > probability) {
			return true;
		}
		else {
			return false;
		}
		
	}

	@Override
	public int getUnlucky(Task task, double unluckyProbability) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Create a String containing the Task's information.
	 *
	 * @param task - the Task
	 * @param taskType - the Task's type
	 */
	@Override
	public String toString(Task task, Task.TaskType taskType) {
	        if(taskType == Task.TaskType.MINING) {
	            return "     Mining " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        if(taskType == Task.TaskType.FISHING) {
	            return "     Fishing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
	        }
	        if(taskType == Task.TaskType.FARM_MAINTENANCE) {
	            return "     Farm Maintenance " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        if(taskType == Task.TaskType.FORAGING) {
	            return "     Foraging " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")" ;
	        }
	        if(taskType == Task.TaskType.FEEDING) {
	            return "     Feeding " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        if(taskType == Task.TaskType.SOCIALIZING) {
	            return "     Socializing " + task.getTaskDescription() + " at " + currentEnergyStorage + " energy points (Priority:" + task.getPriority() +")";
	        }
	        else { return "nothing to see here..."; }
	}


}
