import java.io.*;
import java.util.*;

class Counter implements Runnable{
    static int count = 0;
    static synchronized void increment(){
        count++;
    }
    public void run(){
        for(int i=0; i<10000000; i++){
            increment();
        }
        System.out.println(count);
    }
}

public class Multi2{
    public static void main(String args[]){
        Thread t1 = new Thread(new Counter());
        Thread t2 = new Thread(new Counter());
        t1.start();
        t2.start();
    }
} 