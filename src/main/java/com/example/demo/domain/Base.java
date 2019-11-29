package com.example.demo.domain;

public class Base {
    private String REGION_ID;

    private Long TIME_STAMP;

    private String SIGN;

    private Data DATA;

    public String getREGION_ID() {
        return REGION_ID;
    }

    public void setREGION_ID(String rEGION_ID) {
        REGION_ID = rEGION_ID;
    }

    public Long getTIME_STAMP() {
        return TIME_STAMP;
    }

    public void setTIME_STAMP(Long tIME_STAMP) {
        TIME_STAMP = tIME_STAMP;
    }

    public String getSIGN() {
        return SIGN;
    }

    public void setSIGN(String sIGN) {
        SIGN = sIGN;
    }

    public Data getDATA() {
        return DATA;
    }

    public void setDATA(Data dATA) {
        DATA = dATA;
    }
}
