import java.util.Arrays;

/**
 * Provides a static method generateTwinPrime(int min, int max)
 * that generates a value for the HashTable
 * table size m in the range of [min:max].
 * A good table size is a prime m that is 2 away
 * from another prime (such that m and m − 2 are primes).
 * Two primes (that differ by two) are called “twin primes.”
 * The method to generate twin primes should find the
 * smallest set of twin primes both in the given range.
 * The HashtableTest class will call generateTwinPrime(95500, 96000)
 * to get an appropriate twin prime for the experiment.
 */
public class TwinPrimeGenerator {


    static int generateTwinPrime(int n1, int n2) {

        int from = n1, to = n2, i, twinPrimeNumber = 0;
        boolean[] a = new boolean[to + 1];
        Arrays.fill(a, true);

        // 0 and 1 are not prime
        a[0] = false;
        a[1] = false;
        for (i = 2; i <= Math.sqrt(to); i++) {
            if (a[i]) {
                for (int j = i * i; j <= to; j += i) {
                    a[j] = false;
                }
            }
        }
        for (int count = n1; count <= n2; ++count) {
           // System.out.println("i = " + count + " " + a[count] + " " + a[count + 2]);
            if (a[count] && a[count + 2]) {
                return count + 2;
            }
        }

        return 0;
    }


}




