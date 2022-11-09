/**
 * Contains a generic key object, frequency count,
 * and probe count.  It needs to override both the
 * equals and the toString methods and should also
 * have a getKey method that returns an Object type.
 */
public class HashObject {

    private int frequencyCount;
    private int probeCount;
    private Object key;
    public HashObject(Object key) {
        this.key = key;
    }

    public int getFrequencyCount() {
        return frequencyCount;
    }
    /**
     * sets the frequency count
     * @param frequencyCount int
     */
    public void setFrequencyCount(int frequencyCount) {
        this.frequencyCount = frequencyCount;
    }

    /**
     * returns probe count as an integer
     * @return int probe count
     */
    public int getProbeCount() {
        return probeCount;
    }

    /**
     * sets the probe count
     * @param count int
     */
    public void setProbeCount(int count) {
        this.probeCount = count;
    }

    /**
     * returns the Object key
     * @return Object key
     */
    public Object getKey() {
        return key;
    }

    /**
     * sets the key
     * @param item
     */
    public void setKey(Object item) {
        this.key = item;
    }

    /**
     * returns a String representing an object
     * @return String
     */
    public String toString(){
        return key + " " + probeCount + " " + frequencyCount;
 //        String returnString = key.toString();
//        return returnString;
    }

    /**
     * returns true if objects are equal,
     * false if the objects are not equal
     * @param objectToCompare
     * @return boolean
     */
    public boolean equals(Object objectToCompare){
        HashObject obj = (HashObject) objectToCompare;
        return key.equals(obj.key);
    }
}

