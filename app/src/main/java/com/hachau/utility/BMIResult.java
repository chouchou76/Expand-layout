package com.hachau.utility;

public class BMIResult {
    private double BMI;
    public String description;

    public BMIResult() {
    }

    public BMIResult(double BMI, String description) {
        this.BMI = BMI;
        this.description = description;
    }

    public double getBMI() {
        return BMI;
    }

    public void setBMI(double BMI) {
        this.BMI = BMI;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
