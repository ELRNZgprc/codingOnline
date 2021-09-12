package billionTraffic.ch03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LoopPrint123 {
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition con1 = lock.newCondition();
    private Condition con2 = lock.newCondition();
    private Condition con3 = lock.newCondition();

    public void print1() {
        lock.lock();
        try {
            if (num != 1) {
                con1.await();
            }
            System.out.println(1);
            num = 2;
            con2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print2() {
        lock.lock();
        try {
            if (num != 2) {
                con2.await();
            }
            System.out.println(2);
            num = 3;
            con3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print3() {
        lock.lock();
        try {
            if (num != 3) {
                con3.await();
            }
            System.out.println(3);
            num = 1;
            con1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}
