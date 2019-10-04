/**
 * This is where the magic happens. Each factory is in charged of computing primes.
 * @property work:: work that has to be done by the factory
 * @property primeThreads:: array of primeThreads available to do work.
 * @property n_threads:: total number of Threads available.
 */
public class Factory {
    private Work work;
    PrimeThread [] primeThreads;
    int n_threads;
    private int totalPrimes;
    private double totalThreadTime;
    private double totalRunningTime;
    public Factory(int actual_min, int actual_max, int n_threads, int bite_size){
        this.n_threads = n_threads;
        work = new Work(actual_min, actual_max,bite_size);
        primeThreads = new PrimeThread[n_threads];
        for(int i = 0; i < n_threads; i++){
            primeThreads[i] = new PrimeThread(work, "Thread " + (i+1));
        }
    }

    /**
     * Compute() turns the factory on until it is done. It actualizes statistics on the fly.
     */
    public void compute(){
        long start = System.nanoTime();
        for(int i = 0; i < n_threads; i++){
            primeThreads[i].start();
        }
        try{
            for (int i = 0; i<n_threads; i++){
                primeThreads[i].join();
            }
        }catch (Exception e){
            System.out.println(e);
        }
        long end = System.nanoTime();
        totalRunningTime = (end-start)/1000000000.0;
        //Joining the total amount of primes
        for(int i = 0; i < n_threads; i++){
            totalPrimes += primeThreads[i].getN_primes();
            totalThreadTime += primeThreads[i].getRunningTime();
        }
    }

    public double getTotalRunningTime() {
        return totalRunningTime;
    }

    public int getTotalPrimes() {
        return totalPrimes;
    }
    public double getTotalThreadTime(){
        return totalThreadTime/1000000000.0;
    }
    public void presentStats(){
        for(int i = 0; i<n_threads; i++){
            System.out.println(primeThreads[i].getStatistics());
        }
    }
}