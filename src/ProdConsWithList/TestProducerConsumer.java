package ProdConsWithList;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TestProducerConsumer {

	public static void main(String[] args) {
		 final List<Integer> sharedQ = new LinkedList < Integer >();
         
	        Thread consumerThread = new Thread(new Consumer(sharedQ, 4), "CONSUMER");
	        Thread producerThread = new Thread(new Producer1(sharedQ, 4), "PRODUCER");
	         
	        producerThread.start();
	        consumerThread.start();	
	}

}
class Producer1 implements Runnable
{
    private  List sharedQ;
    private int maxSize;
     
    public Producer1(List sharedQ, int maxSize)
    {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
    }
     
    @Override
    public void run(){
         
        while(true)
        {
            synchronized (sharedQ) {
                while(sharedQ.size()==maxSize)
                {
                    try
                    {
                        System.out.println("Queue is full");
                        sharedQ.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                     
                }
                
                Random random = new Random(); 
                int number = random.nextInt(100);
                System.out.println("Producing value " + number);
                sharedQ.add(number);
                sharedQ.notify();
                 
            }
             
        }
    }
}
class Consumer implements Runnable
{
    private  List<Integer> sharedQ;
    private int maxSize;
     
    public Consumer(List sharedQ, int maxSize)
    {
        this.sharedQ = sharedQ;
        this.maxSize = maxSize;
    }
     
    @Override
    public void run(){
        while(true)
        {
            synchronized (sharedQ) {
                while(sharedQ.isEmpty())
                {
                    try {
                        System.out.println("List is Empty");
                        sharedQ.wait();
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace(); 
                    }
                }
                 
                int number = (int) sharedQ.remove(0);
                System.out.println("removing Element " + number);
                System.out.println("first syso inserted");// commit in repository
                System.out.println("Second commit");
                System.out.println("Suraj");
                System.out.println("Suraj Sonawane");
                System.out.println("Prasad.....");
                sharedQ.notify();
                 
            }
        }
    }
     
}