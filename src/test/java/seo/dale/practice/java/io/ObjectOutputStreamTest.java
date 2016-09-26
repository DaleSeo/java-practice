package seo.dale.practice.java.io;

import org.junit.Ignore;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class ObjectOutputStreamTest {

    @Test
    public void testWrite() throws IOException {
        final ByteArrayOutputStream bos = new ByteArrayOutputStream();
        final ObjectOutputStream oos = new ObjectOutputStream(bos);

        oos.writeInt(101);
        oos.writeBoolean(false);
        oos.writeUTF("Writing a string");

        final User user = new User("Noel", "secret321");
        oos.writeObject(user);

        oos.flush();
        oos.close();

        System.out.println(Arrays.toString(bos.toByteArray()));

        bos.close();
    }

    @Ignore
    @Test
    public void testRead() throws IOException, ClassNotFoundException {
        byte[] byteArray = {-84, -19, 0, 5, 119, 23, 0, 0, 0, 101, 0, 0, 16, 87, 114, 105, 116, 105, 110, 103, 32, 97, 32, 115, 116, 114, 105, 110, 103, 115, 114, 0, 21, 115, 101, 111, 46, 100, 97, 108, 101, 46, 106, 97, 118, 97, 46, 105, 111, 46, 85, 115, 101, 114, 52, -94, -26, -125, -47, -44, -18, 103, 2, 0, 1, 76, 0, 8, 117, 115, 101, 114, 110, 97, 109, 101, 116, 0, 18, 76, 106, 97, 118, 97, 47, 108, 97, 110, 103, 47, 83, 116, 114, 105, 110, 103, 59, 120, 112, 116, 0, 4, 78, 111, 101, 108};
        final ByteArrayInputStream bis = new ByteArrayInputStream(byteArray);
        final ObjectInputStream ois = new ObjectInputStream(bis);

        final int number = ois.readInt();
        final boolean bool = ois.readBoolean();
        final String string = ois.readUTF();
        final User user = (User) ois.readObject();

        assertEquals(101, number);
        assertFalse(bool);
        assertEquals("Writing a string", string);
        assertEquals("Noel", user.getUsername());
        assertNull(user.getPassword()); // transient filed must be null
    }

}
