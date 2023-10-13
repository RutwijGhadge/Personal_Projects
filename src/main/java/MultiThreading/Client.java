package MultiThreading;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//number of elements in the arraylist
        ExecutorService executorService= Executors.newCachedThreadPool();   //Thread pool
        ArrayCreator ac=new ArrayCreator(n);

        Future< List<Integer>> ft =executorService.submit(ac);
        System.out.println(ft.get());
    }
}
