package MultiThreading;

import java.awt.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberGenerator rand1=new RandomNumberGenerator();
        RandomNumberGenerator rand2=new RandomNumberGenerator();

        ExecutorService executorService= Executors.newFixedThreadPool(1);//thread pool initialization
        System.out.println("Waiting");
        Future<Integer>x = executorService.submit(rand1);//tasks submit
        Future<Integer>y = executorService.submit(rand2);
        //waits for 2 milisec
        System.out.println("x:"+x.get());
        //waits for 2 milisec(Thread Pool Size is 1) so tasks gets assigned one after the one gets completed

        //if the thread pool size is 2 then total wait time will be 2 milisecs as both the tasks will be assigned simultaneously to both the threads
        System.out.println("y:"+y.get());
        System.out.println("Sum is:"+ (x.get()+y.get()));
        System.out.println("Completed");
    }
}
