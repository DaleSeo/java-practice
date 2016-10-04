package seo.dale.practice.java.lang.thread;

/**
 * @author Dale Seo
 */
public class ThreadDataShare2 {

	public static void main(String[] args) {
		Runnable runnable = new AccountManager();

		Thread th1 = new Thread(runnable);
		Thread th2 = new Thread(runnable);

		th1.start();
		th2.start();
	}

}

class AccountManager implements Runnable {

	Account account = new Account();

	@Override
	public void run() {
		while (account.getBalance() > 0) {
			int money = (int) (Math.random() * 3 + 1) * 100;
			account.withdraw(money);
			// System.out.println("balance: " + account.getBalance());
		}
	}

}

class Account {

	private int balance = 1000;

	public synchronized void withdraw(int money) {
		System.out.println("withdraw " + money);
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
		System.out.println("balance: " + balance);
	}

//	public void withdraw(int money) {
//		System.out.println("withdraw " + money);
//		synchronized(this) {
//			if (balance >= money) {
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				balance -= money;
//			}
//		}
//		System.out.println("balance: " + balance);
//	}

	public int getBalance() {
		return balance;
	}

}
