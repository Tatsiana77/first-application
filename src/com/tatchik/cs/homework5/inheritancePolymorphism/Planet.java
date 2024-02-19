package com.tatchik.cs.homework5.inheritancePolymorphism;

public class Planet implements CosmicObject , Rotatable{
    private double mass;
    private double radius;

    public Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public double calculateDiameter() {
        return 2 * radius;
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
        System.out.println("The planet is rotating.");
    }

    @Override
    public String toString() {
        return "Planet [mass=" + mass + ", radius=" + radius + "]";
    }
}
