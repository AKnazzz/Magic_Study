package org.workwork.c_java_core_one.homework_c4.workshop;

import java.util.Objects;

public final class Wheel {
    private final String id;
    private final String model;
    private final String category;
    private final String plate;
    private final int quantity;

    public Wheel(String id, String model, String category, String plate, int quantity) {
        this.id = id;
        this.model = model;
        this.category = category;
        this.plate = plate;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getCategory() {
        return category;
    }

    public String getPlate() {
        return plate;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Wheel) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.model, that.model) &&
                Objects.equals(this.category, that.category) &&
                Objects.equals(this.plate, that.plate) &&
                this.quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, category, plate, quantity);
    }

    @Override
    public String toString() {
        return "Wheel[" +
                "id=" + id + ", " +
                "model=" + model + ", " +
                "category=" + category + ", " +
                "plate=" + plate + ", " +
                "quantity=" + quantity + ']';
    }

}
