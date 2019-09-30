public class userThread extends Thread{

//   class variables
    private int min;
    private int max;
    private int totalPrimes;
    private long timeUsed;


//    Default Constructor
    public userThread(){
        this.min = 0;
        this.max = 0;
    }

//    Constructor
    public userThread(int min, int max){

        this.min = min;
        this.max = max;
    }

//    Run Method to start the thread
    public void run(){

//        Getting the beginning start of the thread
        long startTime = System.nanoTime();

//        for loop that finds all the prime numbers
        for (double i = (double)min; i <= max; i++) {

//          variable that determines if the number is prime
            boolean isPrime = true;
//            getting the range of the possible dividends of the current number
            double tempRange = Math.ceil(Math.sqrt(i));

//            nested loop that checks the modulus of the current num to the range of dividends
            for (int j = 2; j <= tempRange; j++) {
                if(i % j == 0.0){
                    isPrime = false;
                    break;
                }
            }

//            checking if the number is prime
            if(isPrime) {
                totalPrimes++;
            }
        }

//      getting end of the thread
        long endTime = System.nanoTime();

//        setting end time as the end minus the beginning time and converting it to seconds
        timeUsed = (endTime - startTime)/1000000000;

    }

//    get total primes method
    public int getTotalPrimes() {
        return totalPrimes;
    }
//  get time used method
    public long getTimeUsed() {
        return timeUsed;
    }
//setting max method
    public void setMax(int max) {
        this.max = max;
    }
//setting min method
    public void setMin(int min) {
        this.min = min;
    }
}
