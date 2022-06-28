package com.example.traveltourism;


public class BookingClass {
    int id;
    String date;

    public BookingClass() { }

    public BookingClass(int id, String date) {
        this.id = id;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
