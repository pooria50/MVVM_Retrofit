package com.example.pooria.mvvm_retrofit.model;

public class Products {
    public String name ,location , price,description, image_url;

    public Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Products() {
    }

    public Products(Integer id ,String name, String location, String price, String description, String image_url) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.image_url = image_url;
    }
}
