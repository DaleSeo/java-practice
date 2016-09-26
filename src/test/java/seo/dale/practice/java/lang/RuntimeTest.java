package seo.dale.practice.java.lang;

import org.junit.Test;

public class RuntimeTest {

    @Test
    public void test() {
        long totalMemory1 = Runtime.getRuntime().totalMemory();
        long freeMemory1 = Runtime.getRuntime().freeMemory();
        long usedMemory1 = totalMemory1 - freeMemory1;
        System.out.printf("totalMemory1 = %d, freeMemory1 = %d, usedMemory1 = %d\n", totalMemory1, freeMemory1, usedMemory1);

        Runtime.getRuntime().gc();

        long totalMemory2 = Runtime.getRuntime().totalMemory();
        long freeMemory2 = Runtime.getRuntime().freeMemory();
        long usedMemory2 = totalMemory2 - freeMemory2;
        System.out.printf("totalMemory2 = %d, freeMemory2 = %d, usedMemory2 = %d\n", totalMemory2, freeMemory2, usedMemory2);
    }

}
