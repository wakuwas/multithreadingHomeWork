package дз;

public class myClass {
        public static void main(String[] args) {
            Counter counter = new Counter();
            SecondThread secondThread1 = new SecondThread("firstThread",counter);
            SecondThread secondThread2 = new SecondThread("secondThread",counter);
            new Thread(secondThread1).start();
            new Thread(secondThread2).start();

        }

}
class Counter {
    public void met(String name) {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println("Поток "+ name +" " + i);
                Thread.sleep(1000);

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
class SecondThread implements Runnable{
    Counter counter;
    String name;

    public SecondThread(String name,Counter counter) {
        this.name = name;
        this.counter = counter;
    }


    @Override
    public void run() {
        try {
            counter.met(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
