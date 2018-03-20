import java.io.*;
import java.util.*;
import java.net.*;

class print1to10 implements Runnable{
    public void run(){
        for(int i=0; i<10; i++){
            try{
                System.out.println(Thread.currentThread().getName()+" is at "+i);
                Thread.sleep(1000);
            }catch(Exception E){
                System.out.println("Error!");
            }
        }
    }
}
public class Multi1{
    public static void main(String args[]){
        try{
            Thread t1 = new Thread(new print1to10());
            Thread t2 = new Thread(new print1to10());
            t1.start();
            Thread.sleep(100);
            t2.start();
            System.out.println("Before join!");
            t1.join();
            t2.join();
            System.out.println("After join!");
        }catch(Exception E){
            System.out.println("Error!");
        }

    }
}