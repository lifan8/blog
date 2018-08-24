package thread;

public class DeadThread implements Runnable{

    int flag=1;
    private static Object a = new Object();
    private static Object b = new Object();

    public void run(){
        System.out.println("开始执行"+this.flag);
        if(flag==1){
            synchronized(a){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(b){
                    System.out.println("flag1成功");
                }
            }
        }
        if(flag==0){
            synchronized(b){
                try{
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(a){
                    System.out.println("flag2成功");
                }
            }
        }
    }

    public static void main(String[] args){
        DeadThread dt1 = new DeadThread();
        DeadThread dt2 = new DeadThread();
        Thread t1 = new Thread(dt1);
        Thread t2 = new Thread(dt2);
        dt1.flag=0;
        dt2.flag=1;
        t1.start();
        t2.start();
    }
}
