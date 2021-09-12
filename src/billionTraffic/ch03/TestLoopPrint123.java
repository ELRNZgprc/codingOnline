package billionTraffic.ch03;

public class TestLoopPrint123 {
    public static void main(String[] args) {
        LoopPrint123 loopPrint = new LoopPrint123();
        new Thread(() -> {
            while (true) {
                loopPrint.print1();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                loopPrint.print2();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                loopPrint.print3();
            }
        }).start();
    }
}
