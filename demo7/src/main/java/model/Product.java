package model;

public class Product {
    private int id;
    private int maSP;
    private String name;
    private double price;
    private String nhaSX;
    private String note;

    public Product() {
    }

    public Product(int id, int maSP, String name, double price, String nhaSX, String note) {
        this.id = id;
        this.maSP = maSP;
        this.name = name;
        this.price = price;
        this.nhaSX = nhaSX;
        this.note = note;
    }

    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int maSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double price() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String nhaSX() {
        return nhaSX;
    }

    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }

    public String note() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
