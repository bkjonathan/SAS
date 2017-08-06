package com.example.erp.data.models;

/**
 * Created by zwe on 8/6/17.
 */

public class MainModel {
    private int image;
    private String title;

    public MainModel(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
