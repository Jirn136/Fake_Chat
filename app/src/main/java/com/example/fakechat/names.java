package com.example.fakechat;

public class names {
    private String names;
    private int imgId;

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public names(String names, int imgId) {
        this.names = names;
        this.imgId = imgId;
    }
}
