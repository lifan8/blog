package thread;

public class ThreadTest {
    public static void main(String args[]){
        RunTest runTest = new RunTest();
        RunTest2 runTest2 = new RunTest2();
        runTest.start();
        runTest2.start();
//
//        for(int i=0;i<50;i++){
//            System.out.println("---main:"+i);
//        }

    }
}

class RunTest extends Thread{
    Produce produce = new Produce();
    public void run(){
        for(int i=0;i<50;i++){
//            System.out.println("---runTest:"+i);
            produce.produce();
        }
    }

}

class RunTest2 extends Thread{
    Produce produce = new Produce();
    public void run(){
        for(int i=0;i<50;i++){
//            System.out.println("---runTest:"+i);
            produce.consume();
        }
    }

}
