package MultiThreading;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumberGenerator implements Callable<Integer> {//implements Callable Call
    @Override
    public Integer call() throws Exception {
        Thread.sleep(2000);//4 milisec sleep timer
        Random random=new Random();
        return random.nextInt();
    }
}
