import java.util.ArrayList;
import java.util.List;

public class Monitor {
    private final List<Integer> primes = new ArrayList<>();

    // hold calculated primes of all threads
    public synchronized void addPrime(int nPrime) {
        primes.add(nPrime);
    }

    public List<Integer> getPrimes() {
        return primes;
    }
}
