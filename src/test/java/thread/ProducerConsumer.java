package thread;

public class ProducerConsumer {
    public static void main(String[] args){
        Basket bk = new Basket();
        Producer p = new Producer(bk);
        Consumer c = new Consumer(bk);

        new Thread(p).start();
        new Thread(p).start();
        new Thread(p).start();
        new Thread(c).start();
    }

}


class Wotou{
    int id;

    Wotou(int id){
        this.id= id;
    }

    public String  toString(){
        return "Wotou:"+id;
    }
}

class Basket{

    int index=0;

    Wotou[] arrWT = new Wotou[6];

    public synchronized void push(Wotou wt){
        if(index == arrWT.length){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        arrWT[index]=wt;
        index++;
    }

    public synchronized Wotou pull(){
        if(index == 0){
            try{
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.notify();
        index--;
        return arrWT[index];
    }
}

class Producer implements Runnable{

    Basket bk = null;

    Producer(Basket bk){
        this.bk = bk;
    }

    public void run(){
        for(int i=0; i<20; i++){
            Wotou wt = new Wotou(i);
            bk.push(wt);
            System.out.println("生产了：" + wt);
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable{

    Basket bk = null;

    Consumer(Basket bk){
        this.bk = bk;
    }

    public void run(){
        for(int i=0; i<20; i++){
            Wotou wt = bk.pull();
            System.out.println("消费了：" + wt);
            try{
                Thread.sleep((int)(Math.random()*1000));
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}