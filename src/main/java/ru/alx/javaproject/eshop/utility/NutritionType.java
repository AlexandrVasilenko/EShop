package ru.alx.javaproject.eshop.utility;

public enum NutritionType {
    MEATEATER("MeatEater"),
    VEGETARIAN("Vegetarian"),
    VEGAN("Vegan"),
    RAWVEGAN("Raw Vegan");


    private final String type;

    NutritionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
