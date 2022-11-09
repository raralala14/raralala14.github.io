import javax.sound.sampled.Line;
import java.util.Random;

/**
 * The driver program that should have three (the third one is optional)
 * command-line arguments with the following usage:
 * <p>
 * <p>
 * Usage: java HashtableTest <dataType> <loadFactor> [<debugLevel>]
 * <dataSource>: 1 ==> random numbers
 * 2 ==> date value as a long
 * 3 ==> word list
 * <loadFactor>: The ratio of objects to table size,
 * denoted by alpha = n/m
 * <debugLevel>: 0 ==> print summary of experiment
 * 1 ==> save the two hash tables to a file at the end
 * 2 ==> print debugging output for each insert
 */

public class HashtableTest {
    private static int debugLevel = 0;
    private String dataType1;
    private static int twinPrime;
    private static double loadFactor;




    public static void main(String[] args) {
        HashtableTest hashTableTest = new HashtableTest();
        if (args.length < 2 || args.length > 3) {
            hashTableTest.showUsage();
        }
        hashTableTest.processArguments(args);
        testTwinPrime();
        int hashTableSize = (int)Math.ceil((double)twinPrime / 2);
        hashTableTest.defaultOutput();
//      hashTableTest.testTheHashTable();

       // start linear probing
        LinearProbing linProbe = new LinearProbing(hashTableSize);

        // generate a random # for integer type
        Random rand = new Random();
        int upperbound = 96000;
        int int_random = rand.nextInt(upperbound);

        Object hashRand = int_random;
            // create new hash object using the rand integer
        HashObject randInt = new HashObject(hashRand);
        linProbe;

        String test = randInt.toString();
        System.out.println(test);
            // add the random #('s) to the hash table



        // generate longs from date for date type
            // add the random longs to the hash table


        // read in words from the word list for the word list type


        System.out.println("HashtableTest: size of hash table is " + hashTableSize);
        System.out.println("        Inserted XXXXXXXX elements of which XXXXXXX were duplicates");
        System.out.println("        Avg. no. of probes = X.XX");
        if (debugLevel > 0 ){
           System.out.println("HashtableTest: Saved dump of hash table");
        // TODO: SAVE DUMP OF HASH TABLE
        }

        // start double hashing
        DoubleHashing dubHash = new DoubleHashing(hashTableSize);
        System.out.println("HashtableTest: size of hash table is " + hashTableSize);
        System.out.println("        Inserted XXXXXXXX elements of which XXXXXXX were duplicates");
        System.out.println("        Avg. no. of probes = X.XX");
        if (debugLevel > 0 ){
            System.out.println("HashtableTest: Saved dump of hash table");
            // TODO: SAVE DUMP OF HASH TABLE
        }











    }

    /**
     * Show usage for the program.
     */
    public void showUsage() {
        System.out.println("java HashtableTest " + "<data-type> " +
                "<load-factor> " + "[<debug-level = 0, 1, 2>]");
        System.exit(1);
    }
    public void defaultOutput(){
        System.out.println("HashtableTest: Found a twin prime for table capacity: " + twinPrime);
        System.out.println("HashtableTest: Input: " + dataType1 + "     " + "Loadfactor: " + loadFactor);


    }


    /**
     * Processes the command line arguments
     *
     * @param args - String arguments:
     *             args[0]: <data-type>
     *             args[1]: <load-factor>
     *             args[2]: <debug-level>
     */
    private void processArguments(String[] args) {


        int dataType = Integer.parseInt(args[0]);
        if (dataType < 1 || dataType > 3) {
            throw new IllegalArgumentException("Illegal argument: data-type must be between 1 and 3");
        } else if (dataType == 1) {
           dataType1 = "Integer";
        } else if (dataType == 2) {
            dataType1 = "Date";
        } else {
            dataType1 = "Word-list";
        }


        loadFactor = Double.parseDouble(args[1]);
        if (args.length > 2) {
            debugLevel = Integer.parseInt(args[2]);
        }


    }

    private void testTheHashTable() {
        testTwinPrime();
        HashObject hashObject1 = getHashObject();
        HashObject hashObject2 = getHashObject();
        testEquals(hashObject1, hashObject2);
        testProbeCount(hashObject1);
        testFrequencyCount(hashObject1);
        testGetKey(hashObject1);
        testToString(hashObject1);
        testPositiveMod();
        //LinearProbing linearTable2 = new LinearProbing();




    }

    private static void testPositiveMod() {
        LinearProbing linearTable1 = new LinearProbing(5);
        int resultOfZero = linearTable1.positiveMod(12, 4);
        //System.out.println("this result should be 0: " + resultOfZero);
        int positiveResult = linearTable1.positiveMod(12, 5);
       // System.out.println("this result should be 2: " + positiveResult);
        int negativeResult = linearTable1.positiveMod(12, -3);
        //System.out.println("this result should be 0: " + negativeResult);


    }

    private static void testTwinPrime() {
        twinPrime = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
    }

    private static void testToString(HashObject hashObject1) {
        String stringOfObject = hashObject1.toString();
        //System.out.println("This is the object as a string with " +
                //"key, probe count, and frequency count in order: " + stringOfObject);
    }

    private static void testGetKey(HashObject hashObject1) {
        Object key = hashObject1.getKey();
       // System.out.println("The key is " + key);
    }

    private static void testFrequencyCount(HashObject hashObject1) {
        hashObject1.setFrequencyCount(1);
        int frequencyCount = hashObject1.getFrequencyCount();
      //  System.out.println("The frequency count is: " + frequencyCount);
    }

    private static void testProbeCount(HashObject hashObject1) {
        hashObject1.setProbeCount(2);
        int probeCount = hashObject1.getProbeCount();
       // System.out.println("The probe count is: " + probeCount);
    }

    private static void testEquals(HashObject hashObject1, HashObject hashObject2) {
        if (hashObject1.equals(hashObject2)) {
           // System.out.println("The objects are equal");
        } else {
           // System.out.println("the objects are not equal");
        }
    }

    private static HashObject getHashObject() {
        Object obj = new Object();
        HashObject hashObject = new HashObject(obj);
        return hashObject;
    }

}
