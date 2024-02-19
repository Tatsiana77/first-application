package com.tatchik.cs.homework5.inheritancePolymorphism;

public class Sun implements Star {
    private double mass;
    private String spectralClass;

    public Sun(double mass, String spectralClass) {
        this.mass = mass;
        this.spectralClass = spectralClass;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public double calculateDiameter() {
        return Math.sqrt(mass);
    }

    @Override
    public void compareMass(CosmicObject otherObject) {
        if (this.mass > otherObject.getMass()) {
            System.out.println("This object has greater mass.");
        } else if (this.mass < otherObject.getMass()) {
            System.out.println("Other object has greater mass.");
        } else {
            System.out.println("Both objects have equal mass.");
        }
    }

    @Override
    public void rotate() {
        System.out.println("The star is rotating.");
    }

    @Override
    public void shine() {
        System.out.println("The star is shining.");
    }

    @Override
    public String toString() {
        return "Sun [mass=" + mass + ", spectralClass=" + spectralClass + "]";
    }
}
