package com.tatchik.cs.homework5.inheritancePolymorphism;

public class Vesta implements Asteroid {
    private double mass;
    private String type;

    public Vesta(double mass, String type) {
        this.mass = mass;
        this.type = type;
    }

    @Override
    public double getMass() {
        return mass;
    }

    @Override
    public double calculateDiameter() {
        return Math.sqrt(Math.sqrt(mass));
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
    public void collide() {
        System.out.println("The asteroid is colliding with another object.");
    }

    @Override
    public String toString() {
        return "Vesta [mass=" + mass + ", type=" + type + "]";
    }
}
