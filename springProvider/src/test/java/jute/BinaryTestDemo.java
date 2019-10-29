package jute;

import org.apache.jute.BinaryInputArchive;
import org.apache.jute.BinaryOutputArchive;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author huangy on 2019-10-20
 */
public class BinaryTestDemo {

    public static void main(String[] args) throws IOException {
        // 序列化
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BinaryOutputArchive boa = BinaryOutputArchive.getArchive(baos);
        new TestBean(1, "testbean1").serialize(boa, "tag1");
        byte array[] = baos.toByteArray();

        // 反序列化
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        BinaryInputArchive bia = BinaryInputArchive.getArchive(bais);
        TestBean newBean1 = new TestBean();
        newBean1.deserialize(bia, "tag1");

        System.out.println("intV = " + newBean1.getIntV() + ",stringV = "
                + newBean1.getStringV());
        bais.close();
        baos.close();
    }

}
