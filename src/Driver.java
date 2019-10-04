
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args)  {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Minimum Value in Range: ");
        int userMin = input.nextInt();
        int actualMin;

        if(userMin < 3){
            actualMin = 3;
        }else{
            actualMin = userMin;
        }

        System.out.print("Enter Maximum Value in Range: ");
        int userMax = input.nextInt();

        System.out.print("Enter Byte Size: ");
        int byteSize = input.nextInt();

        System.out.print("Enter Number of Threads: ");
        int numThreads = input.nextInt();



        Factory factory = new Factory(actualMin,userMax, numThreads, byteSize);
        factory.compute();

        Factory factory2 = new Factory(actualMin,userMax, 1, byteSize);
        factory2.compute();

        System.out.println("\n----------------------------------------------------------------------------------------------");

        factory.presentStats();

        System.out.println("----------------------------------------------------------------------------------------------");

        double timeVarious = factory.getTotalThreadTime();
        double timeOne = factory.getTotalRunningTime();

        System.out.println("Over View \n-------------");
        System.out.println("Range: " + (userMax - userMin) + "\nBite Size: " + byteSize);
        System.out.println("Total Primes: "+factory.getTotalPrimes());
        System.out.println("Total Thread Time: "+ timeVarious);
        System.out.println("Total Running Time: "+ timeOne);
        System.out.println("Speed Up: " + Math.round((timeVarious/timeOne)*100.0)/100.0);

    }
}