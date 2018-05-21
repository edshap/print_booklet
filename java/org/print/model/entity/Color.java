package org.print.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alina on 17.02.2018.
 */
public class Color {
    private int id;
    private String color;
    private double price;
    private String format;
    List<Format> formats = new ArrayList<>();
    public Color() {
    }
    public Color(int id, String color, double price, List<Format> formats) {
        this.id = id;
        this.color = color;
        this.price = price;
        this.format = format;
        this.formats = formats;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public List<Format> getFormats() {
        return formats;
    }
    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", format=" + format +
                '}';
    }
}
