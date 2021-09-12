package billionTraffic.ch04;

public class MyThread implements Runnable {
    private String threadName;

    public MyThread(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run(){
        try{
            System.out.println("threadName:"+ this.threadName);
            System.out.println(this.threadName+" ran 1s!");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getThreadName(){
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
