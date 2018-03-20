import java.io.*;
import java.util.LinkedList;

class Producer implements Runnable{
    PC pc;
    Producer(PC pc){
        this.pc = pc;
    }
    public void run(){
        try{
        pc.produce();
        }catch(Exception e){

        }
    }
}

class Consumer implements Runnable{
    PC pc;
    Consumer(PC pc){
        this.pc = pc;
    }
    public void run(){
        try{
        pc.consume();
        }catch(Exception e){

        }
    }
}

class PC{
        LinkedList<Integer> l;
        int maxSize;
        int val;
        PC(){
            l = new LinkedList<Integer>();
            maxSize = 2;
            val=0;
        }
        void produce() throws InterruptedException{
            while(true){
                synchronized(this){
                    while(l.size()==maxSize)wait();
                    l.add(val);
                    System.out.println("Added: "+val);
                    val++;
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        void consume() throws InterruptedException{
            while(true){
                synchronized(this){
                    while(l.size()==0)wait();
                    int n = l.removeFirst();
                    System.out.println("Removed: "+n);
                    notify();
                    //Thread.sleep(1000);
                }
            }

        }
    }

public class ProducerConsumer{
    public static void main(String args[]) throws InterruptedException{
        final PC pc = new PC();
        Thread producer = new Thread(new Producer(pc));
        Thread consumer = new Thread(new Consumer(pc));
        producer.start();
        consumer.start();
    }


    
}