package org.print.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alina on 17.02.2018.
 */
public class Gramm {
    private int id;
    private String gramm;
    private double price;
    List<Format> formats = new ArrayList<>();

    public Gramm() {
    }
    public Gramm(int id, String gramm, double price, List<Format> formats) {
        this.id = id;
        this.gramm = gramm;
        this.price = price;
        this.formats = formats;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGramm() {
        return gramm;
    }
    public void setGramm(String gramm) {
        this.gramm = gramm;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public List<Format> getFormats() {
        return formats;
    }
    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }
    public String toString() {
        return "Gramm{" +
                "id=" + id +
                ", gramm='" + gramm + '\'' +
                ", price=" + price +
                '}';
    }
}
