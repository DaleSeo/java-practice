package seo.dale.practice.java;

public class SampleThree extends Thread
{
	static long wakeUpTime = System.currentTimeMillis() + (1000*20);
	static int inT;
	public static void main(String args[])
	{
		System.out.println("initial:" + inT);
		for(int i=0; i<500; i++)
			new SampleThree().start();
		try {
			Thread.sleep(wakeUpTime - System.currentTimeMillis() + (1000*30));
			System.out.println("o/p:" + inT);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void run()
	{
		try {
			long s = wakeUpTime - System.currentTimeMillis();
			System.out.println("will sleep ms: " + s);
			Thread.sleep(s);
			inT++; // System.out.println(inT);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
