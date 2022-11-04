/**
 * The driver program that should have three (the third one is optional)
 * command-line arguments with the following usage:
 *
 *
 *       Usage: java HashtableTest <dataType> <loadFactor> [<debugLevel>]
 *        <dataSource>: 1 ==> random numbers
 *                      2 ==> date value as a long
 *                      3 ==> word list
 *        <loadFactor>: The ratio of objects to table size,
 *                        denoted by alpha = n/m
 *        <debugLevel>: 0 ==> print summary of experiment
 *                      1 ==> save the two hash tables to a file at the end
 *                      2 ==> print debugging output for each insert
 */
import java.io.FileNotFoundException;
public class HashtableTest {
    private final int SHOW_NO_DEBUG_INFO = 0;
    private final int SHOW_PLAYERS = 1;
    private final int SHOW_DISTRIBUTION = 2;
    private int debugLevel = SHOW_NO_DEBUG_INFO;
    public static void main(String[] args) {
        HashtableTest hashTableTest = new HashtableTest();
        if (args.length < 2 || args.length > 3) {
            hashTableTest.showUsage();
        }
        hashTableTest.processArguments(args);

        hashTableTest.testTheHashTable();
        TwinPrimeGenerator.generateTwinPrime(95500, 96000);


    }
    /**
     * Show usage for the program.
     */
    public void showUsage() {
        System.out.println("java HashtableTest " + "<data-type> " +
                "<load-factor> " + "[<debug-level = 0, 1, 2>]");
        System.exit(1);
    }
    /**
     * Processes the command line arguments
     *
     * @param args
     *            - String arguments:
     *              args[0]: <data-type>
     *              args[1]: <load-factor>
     *              args[2]: <debug-level>
     */
    private void processArguments(String[] args) {

        int dataType = Integer.parseInt(args[0]);
        if (dataType < 1 || dataType > 3) {
            throw new IllegalArgumentException("Illegal argument: data-type must be between 1 and 3");
        }

        double loadFactor = Double.parseDouble(args[1]);
        if (args.length > 2){
            int debugLevel = Integer.parseInt(args[2]);
        }

    }
    private void testTheHashTable () {
    TwinP

     }

}
