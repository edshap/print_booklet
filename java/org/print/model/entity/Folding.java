package org.print.model.entity;

/**
 * Created by Alina on 17.02.2018.
 */
public class Folding {
    private int id;
    private String fold;
    private double price;

    public Folding() {
    }
    public Folding(int id, String fold, double price) {
        this.id = id;
        this.fold = fold;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFold() {
        return fold;
    }
    public void setFold(String fold) {
        this.fold = fold;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String toString() {
        return "Folding{" +
                "id=" + id +
                ", fold='" + fold + '\'' +
                ", price=" + price +
                '}';
    }
}
