package billionTraffic.ch04;

import java.util.ArrayList;
import java.util.concurrent.*;

public class TestThreadPoolWithCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        ArrayList<Future<Integer>> futureList = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 6; i++) {
            Future<Integer> result = pool.submit(() -> {
                        int sum = 0;
                        for (int j = 0; j <= 10; j++) {
                            sum += j;
                        }
                        return sum;
                    }
            );
            futureList.add(result);
        }
        for (Future<Integer> future : futureList) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
