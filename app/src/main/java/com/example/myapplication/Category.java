package com.example.myapplication;

public class Category {
    private String name;
    private String description;
    private int imageResId; // ID del recurso de la imagen (e.g., R.drawable.icon_adventure)

    public Category(String name, String description, int imageResId) {
        this.name = name;
        this.description = description;
        this.imageResId = imageResId;
    }

    // Métodos Getter para acceder a las propiedades
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }

    // Métodos Setter (opcionales si las categorías son inmutables)
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }
}
