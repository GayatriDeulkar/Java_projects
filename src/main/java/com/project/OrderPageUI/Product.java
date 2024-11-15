package com.project.OrderPageUI;





public class Product {
    private String imgPath;
    private String name;
    private double price;
    private String description;

    public Product(String imgPath, String name, double price, String description) {
        this.imgPath = imgPath;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }
}
