public class Main {

    public static void main(String[] args) {

        int maxNumber = 100000; // calculation limit
        int numCores = Runtime.getRuntime().availableProcessors();
        int range = maxNumber / numCores; // how many numbers get checked per core

        Monitor monitor = new Monitor();
        Thread[] threads = new Thread[numCores];

        for (int i = 0; i < numCores; i++) {
            int start = i * range + 1;
            int end = (i == numCores - 1) ? maxNumber : (i + 1) * range;

            // start a thread on every core with a different range
            threads[i] = new Thread(new Calculator(start, end, monitor));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                // wait for threads to finish before printing results
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Primes: " + monitor.getPrimes());
    }
}
