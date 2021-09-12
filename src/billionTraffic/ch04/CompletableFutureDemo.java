package billionTraffic.ch04;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CompletableFutureDemo {
    public static void main(String[] args) {
        ArrayList<Character> resultList = new ArrayList<>();
        CopyOnWriteArrayList<Integer> taskList = new CopyOnWriteArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        taskList.add(1);
        taskList.add(2);
        taskList.add(3);
        taskList.add(4);
        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(
                        () -> calcASCII(integer), executorService)
                        .thenApply(i -> {
                            char c = (char) (i.intValue());
                            System.out.println("[step 2] Thread" + Thread.currentThread().getName() + "completed: 将int " + i + "转为char " + c);
                            return c;
                        })
                        .whenComplete((ch, e) -> {
                                    resultList.add(ch);
                                    System.out.println("[step 3] Thread" + Thread.currentThread().getName() + "completed: 将" + ch + "添加至" + resultList);
                                    executorService.shutdown();
                                }
                        )).toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(cfs).join();
        System.out.println(resultList);

    }

    public static Integer calcASCII(Integer i) {
        try {
            Thread.sleep(i * 2000);
            i = i + 64;
            System.out.println("[step 1] Thread" + Thread.currentThread().getName() + "completed: 将int " + i + "转为对应的ASCII " + i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
