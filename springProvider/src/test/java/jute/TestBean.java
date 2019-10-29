package jute;

import org.apache.jute.InputArchive;
import org.apache.jute.OutputArchive;
import org.apache.jute.Record;

import java.io.IOException;

public class TestBean implements Record {

    private int intV;
    private String stringV;

    public TestBean() {

    }

    public TestBean(int intV, String stringV) {
        this.intV = intV;
        this.stringV = stringV;
    }

    //get/set方法

    @Override
    public void deserialize(InputArchive archive, String tag)
            throws IOException {
        archive.startRecord(tag);
        this.intV = archive.readInt("intV");
        this.stringV = archive.readString("stringV");
        archive.endRecord(tag);
    }

    @Override
    public void serialize(OutputArchive archive, String tag) throws IOException {
        archive.startRecord(this, tag);
        archive.writeInt(intV, "intV");
        archive.writeString(stringV, "stringV");
        archive.endRecord(this, tag);
    }

    public int getIntV() {
        return intV;
    }

    public void setIntV(int intV) {
        this.intV = intV;
    }

    public String getStringV() {
        return stringV;
    }

    public void setStringV(String stringV) {
        this.stringV = stringV;
    }
}
