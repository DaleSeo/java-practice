package seo.dale.practice.java.lang.thread;

/**
 * https://wikidocs.net/230
 * @author Dale Seo
 */
public class MultiThreadRunner {

    public static void main(String[] args) {
	    Runnable runnable = () -> {
		    System.out.println(Thread.currentThread() + " starts.");
		    try {
			    Thread.sleep((int) (1000 * Math.random()));
		    }catch(Exception e) {
		    }
		    System.out.println(Thread.currentThread() + " ends.");
	    };
        System.out.println(Thread.currentThread() + " starts.");
        for(int i = 1; i <= 10; i++) {
            Thread thread = new Thread(runnable);
	        thread.setPriority(i);
            thread.start();
        }
        System.out.println(Thread.currentThread() + " ends.");
    }

}
