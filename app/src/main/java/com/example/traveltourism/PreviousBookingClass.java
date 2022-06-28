package com.example.traveltourism;

public class PreviousBookingClass {
    String pkgID;
    String pkgName;
    String price;
    String Details;
    String Date;
    String Img;

    public PreviousBookingClass(String pkgID, String pkgName, String price, String details, String date, String img) {
        this.pkgID = pkgID;
        this.pkgName = pkgName;
        this.price = price;
        Details = details;
        Date = date;
        Img = img;
    }

    public PreviousBookingClass() {
    }

    public String getPkgID() {
        return pkgID;
    }

    public void setPkgID(String pkgID) {
        this.pkgID = pkgID;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        Details = details;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }


}
