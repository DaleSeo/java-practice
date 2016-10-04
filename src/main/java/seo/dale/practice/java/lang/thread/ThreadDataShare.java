package seo.dale.practice.java.lang.thread;

/**
 * @author Dale Seo
 */
public class ThreadDataShare {

	public static void main(String[] args) {
		Data data = new Data();
		Runnable runnable = new RunnableImpl(data);

		Thread th1 = new Thread(runnable);
		Thread th2 = new Thread(runnable);

		th1.start();
		th2.start();
	}


}

class RunnableImpl implements Runnable {

	int instanceVal = 0;
	Data data;

	public RunnableImpl(Data data) {
		this.data = data;
	}

	@Override
	public void run() {
		int localVal = 0;
		String name = "[" + Thread.currentThread().getName() + "]";

		while (localVal < 3) {
			System.out.println(name + " Local Var:" + ++localVal);
			System.out.println(name + " Instance Var:" + ++instanceVal);
			System.out.println(name + " Instance Data:" + ++data.vale);
			System.out.println();
		}
	}

}

class Data {
	int vale = 0;
}
