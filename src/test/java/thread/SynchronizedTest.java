package thread;

public class SynchronizedTest implements Runnable{

    Test test = new Test();
    public static void main(String args[]){
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        Thread thread1 = new Thread(synchronizedTest);
        Thread thread2 = new Thread(synchronizedTest);
        thread1.setName("thread1");
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }


    @Override
    public void run() {
        test.add(Thread.currentThread().getName());
    }
}

class Test{

    public static int num = 0;
    void add(String name){
        num++;
        try{
            Thread.sleep(1);
        }catch (InterruptedException e){}
        System.out.println(name+"开启了第"+num+"个线程");
    }
}
