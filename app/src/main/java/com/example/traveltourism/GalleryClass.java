package com.example.traveltourism;

public class GalleryClass {
    String url;
    String Name;

    public GalleryClass() { }

    public GalleryClass(String url, String name) {
        this.url = url;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
