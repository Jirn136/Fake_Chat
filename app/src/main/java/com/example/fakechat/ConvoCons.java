package com.example.fakechat;

public class ConvoCons {
    String convMe;
    String conEnd;

    public String getConvMe() {
        return convMe;
    }

    public void setConvMe(String convMe) {
        this.convMe = convMe;
    }

    public String getConEnd() {
        return conEnd;
    }

    public void setConEnd(String conEnd) {
        this.conEnd = conEnd;
    }

    public ConvoCons(String convMe, String conEnd) {
        this.convMe = convMe;
        this.conEnd = conEnd;
    }
}
