package MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class ArrayCreator implements Callable<List<Integer>> {
    int num;

    public ArrayCreator(int num) {
        this.num = num;
    }

    @Override
    public List<Integer> call() throws Exception {
        List<Integer>arr=new ArrayList<>();
        for(int i=0;i<num;i++)
            arr.add(i+1);
        return arr;
    }
}
