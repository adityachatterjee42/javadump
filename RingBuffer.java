public class RingBuffer{
    int ar[];
    int start;
    int end;
    boolean isEmpty;
    RingBuffer(int n){
        ar = new int[n];
        start = 0;
        end = 0;
        isEmpty=true;
    }
    void enqueue(int val){
        //RingBuffer empty
        if(start==end && isEmpty){
            isEmpty=false;
            ar[start]=val;
            end=(end+1)%ar.length;
        }
        else if(start==end && !isEmpty){
            System.out.println("RingBuffer full!");
        }
        else{
            ar[end]=val;
            end=(end+1)%ar.length;
        }
    }
    int dequeue(){
        if(start==end && isEmpty){
            System.out.println("RingBuffer empty!");
            return -1;
        }
        else{
            int returnValue=ar[start];
            start=(start+1)%ar.length;
            if(start==end)isEmpty=true;
            return returnValue;
        }
    }
    public static void main(String args[]){
        RingBuffer rb = new RingBuffer(3);
        rb.enqueue(1);
        rb.enqueue(2);
        rb.enqueue(3);
        rb.enqueue(4);
        System.out.println(rb.dequeue());
        System.out.println(rb.dequeue());
        System.out.println(rb.dequeue());
        System.out.println(rb.dequeue());
        rb=new RingBuffer(3);
        rb.enqueue(1);
        rb.dequeue();
        rb.enqueue(2);
        rb.enqueue(3);
        rb.enqueue(4);
        System.out.println(rb.dequeue());

    }
}