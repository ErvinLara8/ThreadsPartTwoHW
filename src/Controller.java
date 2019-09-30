public class Controller {

    private double actualMin;
    private double actualMax;
    private int totalThreads;
    private int lastWorker = 0;
    userThread[] totalWorkers;

    public Controller(double actualMin, double actualMax, int totalThreads){

        this.actualMax = actualMax;
        this.actualMin = actualMin;
        this.totalThreads = totalThreads;
        totalWorkers = new userThread[totalThreads];

        for (int i = 0; i < totalThreads; i++) {

            userThread temp = new userThread();
            totalWorkers[i] = temp;
        }

    }

    public synchronized void work(){

    }

    public userThread getWorker(){
        return totalWorkers[(lastWorker++)%totalThreads];
    }
}
