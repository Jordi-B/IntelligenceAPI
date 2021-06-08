package com.danielR.danielspring.scrapeObjects;

public class scrapeData {
    private String text;
    private String publish_date;
    private String scraping_date;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getScraping_date() {
        return scraping_date;
    }

    public void setScraping_date(String scraping_date) {
        this.scraping_date = scraping_date;
    }
}
