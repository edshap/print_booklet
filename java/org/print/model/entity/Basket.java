package org.print.model.entity;

public class Basket {
    private int idBasket;
    private int numberOrder;
    private String formatOrder;
    private String grammOrder;
    private String colorOrder;
    private String foldOrder;
    private Double quantityOrder;
    private Double summOrder;
    private String payCondition;
    private String shipment;
    private String payType;
    private int idUser;

    public Basket() {
    }

    public Basket(int numberOrder, String formatOrder, String grammOrder, String colorOrder, String foldOrder,
                  Double quantityOrder, Double summOrder, String payCondition, String shipment, String payType, int idUser) {
        this.numberOrder = numberOrder;
        this.formatOrder = formatOrder;
        this.grammOrder = grammOrder;
        this.colorOrder = colorOrder;
        this.foldOrder = foldOrder;
        this.quantityOrder = quantityOrder;
        this.summOrder = summOrder;
        this.payCondition = payCondition;
        this.shipment = shipment;
        this.payType = payType;
        this.idUser = idUser;
    }

    public Basket(int idBasket, int numberOrder, String formatOrder, String grammOrder, String colorOrder,
                  String foldOrder, Double quantityOrder, Double summOrder, String payCondition, String shipment, String payType, int idUser) {
        this.idBasket = idBasket;
        this.numberOrder = numberOrder;
        this.formatOrder = formatOrder;
        this.grammOrder = grammOrder;
        this.colorOrder = colorOrder;
        this.foldOrder = foldOrder;
        this.quantityOrder = quantityOrder;
        this.summOrder = summOrder;
        this.payCondition = payCondition;
        this.shipment = shipment;
        this.payType = payType;
        this.idUser = idUser;
    }

    public int getIdBasket() {
        return idBasket;
    }

    public void setIdBasket(int idBasket) {
        this.idBasket = idBasket;
    }

    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getFormatOrder() {
        return formatOrder;
    }

    public void setFormatOrder(String formatOrder) {
        this.formatOrder = formatOrder;
    }

    public String getGrammOrder() {
        return grammOrder;
    }

    public void setGrammOrder(String grammOrder) {
        this.grammOrder = grammOrder;
    }

    public String getColorOrder() {
        return colorOrder;
    }

    public void setColorOrder(String colorOrder) {
        this.colorOrder = colorOrder;
    }

    public String getFoldOrder() {
        return foldOrder;
    }

    public void setFoldOrder(String foldOrder) {
        this.foldOrder = foldOrder;
    }

    public Double getQuantityOrder() {
        return quantityOrder;
    }

    public void setQuantityOrder(Double quantityOrder) {
        this.quantityOrder = quantityOrder;
    }

    public Double getSummOrder() {
        return summOrder;
    }

    public void setSummOrder(Double summOrder) {
        this.summOrder = summOrder;
    }

    public String getPayCondition() {
        return payCondition;
    }

    public void setPayCondition(String payCondition) {
        this.payCondition = payCondition;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "idBasket=" + idBasket +
                ", numberOrder=" + numberOrder +
                ", formatOrder='" + formatOrder + '\'' +
                ", grammOrder='" + grammOrder + '\'' +
                ", colorOrder='" + colorOrder + '\'' +
                ", foldOrder='" + foldOrder + '\'' +
                ", quantityOrder=" + quantityOrder +
                ", summOrder=" + summOrder +
                ", payCondition='" + payCondition + '\'' +
                ", shipment='" + shipment + '\'' +
                ", payType='" + payType + '\'' +
                ", idUser='" + idUser + '\'' +
                '}';
    }
}
