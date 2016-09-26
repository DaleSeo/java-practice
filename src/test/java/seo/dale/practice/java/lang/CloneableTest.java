package seo.dale.practice.java.lang;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

public class CloneableTest {

    @Test
    public void test() throws Exception {
        Bean bean = new Bean();
        bean.setId(3307);
        bean.setName("Dale Seo");
        bean.setArray(new int[]{2, 4, 6, 8});
        System.out.println(bean);
        Bean clone = (Bean) bean.clone();
        System.out.println(clone);
        assertNotSame(bean, clone);
        assertEquals(bean.getId(), clone.getId());

        // shallow copy
        bean.setName("Kate Kim");
        assertEquals("Dale Seo", clone.getName());
        bean.getArray()[0] = 1;
        assertEquals(1, clone.getArray()[0]);
    }
}

class Bean implements Cloneable {

    private long id;

    private String name;

    private int[] array;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}