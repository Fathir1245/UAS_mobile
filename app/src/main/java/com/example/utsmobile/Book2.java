package com.example.utsmobile;

import com.google.gson.annotations.SerializedName;

public class Book2 {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("synopsis")
    private String synopsis;

    // Constructor (opsional, jika ingin menggunakan)
    public Book2(String title, String description, String synopsis) {
        this.title = title;
        this.description = description;
        this.synopsis = synopsis;
    }

    // Getter and Setter untuk title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter untuk description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and Setter untuk synopsis
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    @Override
    public String toString() {
        return "Book2{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", synopsis='" + synopsis + '\'' +
                '}';
    }
}
