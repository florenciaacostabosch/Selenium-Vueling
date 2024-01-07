package Helpers;

public class Helpers {
	public static void sleepSeconds(double seconds) {
		try {
			int segs=(int) (seconds * 1000);
			Thread.sleep(segs);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

