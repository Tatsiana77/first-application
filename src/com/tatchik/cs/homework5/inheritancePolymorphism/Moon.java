package com.tatchik.cs.homework5.inheritancePolymorphism;

public class Moon implements Satellite{
    private double mass;
    private String name;

    public Moon(double mass, String name) {
        this.mass = mass;
        this.name = name;
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
    public void orbit() {
        System.out.println("The satellite is orbiting.");
    }

    @Override
    public void rotate() {
        System.out.println("The satellite is rotating.");
    }

    @Override
    public String toString() {
        return "Moon [mass=" + mass + ", name=" + name + "]";
    }
}
