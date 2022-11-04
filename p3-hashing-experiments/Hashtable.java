/**
 *  Defines an abstract hash table class using an array of
 *  HashObject and all of the common hash table functionality
 *  should be in this abstract parent class and the subclasses
 *  would only have the functionality that is specific to the
 *  subclasses.
 */
public class Hashtable {

    protected int positiveMod (int dividend, int divisor) {
        int quotient = dividend % divisor;
        if (quotient < 0)
            quotient += divisor;
        return quotient;
    }

}
