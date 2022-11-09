/**
 * Subclass that extends Hashtable.java and only
 * contains differing hash table functionality
 * specific to double hashing. The primary hash
 * function is h1(k) = k mod m and the secondary
 * hash function is h2(k) = 1 + (k mod (m − 2)).
 */
public class DoubleHashing extends Hashtable {

    // h2(key) = 1 + positiveMod (key.hashCode(), tablesize - 2);
    public DoubleHashing (int tableSize){
        super(tableSize);

        System.out.println("        Using Double Hashing");
    }
}
