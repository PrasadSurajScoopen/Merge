package Queue.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerDemo {

	public static void main(String[] args) {
		BlockingQueue<Integer>blockingQueue = new ArrayBlockingQueue<Integer>(10);
		Thread th1= new Thread(new ProducerClass(blockingQueue));
		Thread th2 = new Thread(new ConsumerClass(blockingQueue));
		th1.start();
		th2.start();
	}

}
class ProducerClass implements Runnable{
	//char[] chararray = new char[]{'a','1','@','$','A'};
 private int i = 0;
 private BlockingQueue<Integer> blockingQueue=null;
 
	public ProducerClass(BlockingQueue<Integer> blockingQueue) {
	super();
	this.blockingQueue = blockingQueue;
}
	@Override
	public void run() {
		for (int i=0;i<100;i++){
			try {
				Producer(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void Producer(int i) throws InterruptedException{
		System.out.println("Producer produced element"+i);
		blockingQueue.put(i);
		//Thread.sleep(1);
	}
}
class ConsumerClass implements Runnable{
	 private int i = 0;
	 private BlockingQueue<Integer> blockingQueue=null;
	 
		public ConsumerClass(BlockingQueue<Integer> blockingQueue) {
		super();
		this.blockingQueue = blockingQueue;
	}
		@Override
		public void run() {
			for (int i=0;i<100;i++){
				try {
					Consume();
	 			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		public void Consume() throws InterruptedException{
			System.out.println("Consumer Consumed element"+blockingQueue.take());
 			//Thread.sleep(500);
		}
	}
