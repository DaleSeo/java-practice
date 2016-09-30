package seo.dale.practice.java.lang.thread;

import org.junit.Test;

/**
 * @author Dale Seo
 */
public class ThreadGroupTest {

	@Test
	public void test() {
		ThreadGroup mainGrp = Thread.currentThread().getThreadGroup();
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");

		ThreadGroup subGrp1 = new ThreadGroup(grp1, "SubGroup1");
		grp1.setMaxPriority(3);

		Thread th1 = new Thread(grp1, "Thread1");
		Thread th2 = new Thread(subGrp1, "Thread2");
		Thread th3 = new Thread(grp2, "Thread3");

		th1.start();
		th2.start();
		th3.start();

		System.out.println(">> List of ThreadGroup : " + mainGrp.getName() +
				", Active ThreadGroup: " + mainGrp.activeGroupCount() +
				", Active Thread : " + mainGrp.activeCount());

		mainGrp.list();
	}

}
