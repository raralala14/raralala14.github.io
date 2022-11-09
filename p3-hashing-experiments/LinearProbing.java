/**
 * Subclass that extends Hashtable.java and only contains
 * differing hash table functionality specific to linear probing.
 */
public class LinearProbing extends Hashtable {
    // h1(key) = positiveMod (key.hashCode(), tablesize);
    public LinearProbing (int tableSize){
        super(tableSize);
        System.out.println("        Using Linear Probing");

    }

}
