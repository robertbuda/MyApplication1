package com.example.robert.myapplication1;

/**
 * Created by Robert on 2018-03-21.
 */

public class ResourcesPlacViever {

    private int imageRes;
    private String titleRes;
    private String textRes;
    private String langRes;
    private String longRes;

    public ResourcesPlacViever(int imageRes, String titleRes, String textRes, String langRes, String longRes) {
        this.imageRes = imageRes;
        this.titleRes = titleRes;
        this.textRes = textRes;
        this.langRes = langRes;
        this.longRes = longRes;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }

    public String getTitleRes() {
        return titleRes;
    }

    public void setTitleRes(String titleRes) {
        this.titleRes = titleRes;
    }

    public String getTextRes() {
        return textRes;
    }

    public void setTextRes(String textRes) {
        this.textRes = textRes;
    }

    public String getLangRes() {
        return langRes;
    }

    public void setLangRes(String langRes) {
        this.langRes = langRes;
    }

    public String getLongRes() {
        return longRes;
    }

    public void setLongRes(String longRes) {
        this.longRes = longRes;
    }
}
