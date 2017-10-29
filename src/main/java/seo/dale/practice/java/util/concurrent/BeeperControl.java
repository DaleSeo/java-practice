package seo.dale.practice.java.util.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledExecutorService.html
 */
public class BeeperControl {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void beepForAnHour() {
        final ScheduledFuture<?> beeperHandle = scheduler.scheduleAtFixedRate(()
                -> System.out.println("beep"),0, 1, TimeUnit.SECONDS);
        scheduler.schedule(() -> {
            beeperHandle.cancel(true);
        }, 10, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        new BeeperControl().beepForAnHour();
    }
}
