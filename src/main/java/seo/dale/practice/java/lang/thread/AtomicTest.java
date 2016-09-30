package seo.dale.practice.java.lang.thread;

/**
 * http://egloos.zum.com/iilii/v/5564982
 * @author Dale Seo
 */
public class AtomicTest {

    private int a = 0;

    public int incrementAndGet(){
        return a++;
    }

    public static void main(String[] args) {
        final AtomicTest test = new AtomicTest();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
	            for (int j = 0; j < 1000; j++) {
		            System.out.println(Thread.currentThread().getName() + " : " + test.incrementAndGet());
	            }
            }).start();
        }
    }

}
