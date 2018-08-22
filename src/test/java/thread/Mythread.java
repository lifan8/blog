package thread;

public class Mythread extends Thread {

    private int i;

    @Override
    public void run(){
        for(i=0;i<100;i++){
            System.out.println(getName() + " " +i);
        }
    }

    public static void main(String[] args){
        Mythread xx = new Mythread();
        xx.setName("xx");
        xx.start();
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+"------ " +i);
            if(i==20){
                new Mythread().start();
                new Mythread().start();

            }
        }
    }
}
