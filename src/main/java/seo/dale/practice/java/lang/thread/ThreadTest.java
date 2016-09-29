package seo.dale.practice.java.lang.thread;

/**
 * https://wikidocs.net/230
 * @author Dale Seo
 */
public class ThreadTest implements Runnable {

    int seq;

    public ThreadTest(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts.");
        try {
            Thread.sleep((int) (10000 * Math.random()));
        }catch(Exception e) {
        }
        System.out.println(Thread.currentThread().getName() + " ends.");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " starts.");
        for(int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ThreadTest(i));
            thread.start();
        }
        System.out.println(Thread.currentThread().getName() + " ends.");
    }

}
