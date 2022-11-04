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

    public Object getKey() {
        return key;
    }

    public String toString(){

    }
    public boolean equals(Object other){
        HashObject obj = (HashObject) other;
        if (key.equals(obj.key)) {
            return true;
        } else {
            return false;
        }
    }
}

