package com.example.utsmobile;

public class Book {
    private String title;
    private String description;
    private String publisher;
    private String synopsis;
    private PhysicalDescription physicalDescription;  // Tambahkan field physicalDescription

    // Getter dan setter untuk title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter dan setter untuk description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter dan setter untuk publisher
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    // Getter dan setter untuk synopsis
    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    // Getter dan setter untuk physicalDescription
    public PhysicalDescription getPhysicalDescription() {
        return physicalDescription;
    }

    public void setPhysicalDescription(PhysicalDescription physicalDescription) {
        this.physicalDescription = physicalDescription;
    }

}
