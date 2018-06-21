package Queue.example;

import java.util.concurrent.ArrayBlockingQueue;

public class TestQueue {

	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<Integer> abq= new ArrayBlockingQueue<Integer>(6);
		abq.offer(11);
		abq.offer(12);
		abq.offer(13);
		abq.offer(14);
		abq.offer(15);
		abq.offer(20);
		System.out.println(abq.offer(16));
		System.out.println(abq);
		System.out.println(abq.remove());
		System.out.println(abq);
		System.out.println(abq.peek());
		System.out.println(abq);
//		abq.add(1);
//		abq.add(2);
//		abq.add(3);
		//System.out.println(abq );
	}

}
