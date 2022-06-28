package com.example.traveltourism;

public class Products {
    private String id;
    private String countryname;
    private String price;
    private String img;
    private  String Details;

    public Products(String id, String countryname, String price, String img, String details) {
        this.id = id;
        this.countryname = countryname;
        this.price = price;
        this.img = img;
        this.Details = details;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getDetails() {
        return this.Details;
    }

    public void setDetails(String details) {
        this.Details = details;
    }


    public Products() {

    }


    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }


}


    