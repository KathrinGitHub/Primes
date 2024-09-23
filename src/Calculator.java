public class Calculator implements Runnable {
    private final int start;
    private final int end;
    private final Monitor monitor;

    public Calculator(int start, int end, Monitor monitor) {
        this.start = start;
        this.end = end;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                monitor.addPrime(i);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 2 || n == 3 || n == 5) return true;
        if (n <= 1 || (n & 1) == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
        return true;
    }
}
