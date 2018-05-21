package org.print.model.entity;

/**
 * Created by Alina on 17.02.2018.
 */
public class Format {
    private int id;
    private String format;

    public Format() {
    }
    public Format(int id, String format) {
        this.id = id;
        this.format = format;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String toString() {
        return "Format{" +
                "id=" + id +
                ", format='" + format + '\'' +
                '}';
    }
}
