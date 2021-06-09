package com.danielR.danielspring.scrapeObjects;

public class scrapeProfile {
    private String person_id;
    private String image;
    private String name;
    private scrapeData[] data;

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public scrapeData[] getData() {
        return data;
    }

    public void setData(scrapeData[] data) {
        this.data = data;
    }
}
